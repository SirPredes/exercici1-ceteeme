package org.example.notificacions.web.alert;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.example.notificacions.alarm.application.create.AlertCreator;
import org.example.notificacions.alarm.application.find.AllAlertSearcher;
import org.example.transport.busStop.application.create.BusStopCreator;
import org.example.transport.busStop.application.find.FindBusStopByBusStopId;
import org.example.transport.busStop.domain.BusStop;
import org.example.transport.busline.application.find.FindBuslineByBuslineId;
import org.example.transport.busline.domain.Busline;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Named("alertFormBean")
@ViewScoped
public class AlertFormBean  implements Serializable {

    @Inject
    private AlertCreator alertCreator;

    @Inject
    private BusStopCreator busStopCreator;

    @Inject
    private AllAlertSearcher allAlertSearcher;

    @Inject
    private FindBuslineByBuslineId findBuslineByBuslineId;

    @Inject
    private FindBusStopByBusStopId findBusStopByBusStopId;

    @Inject
    private AlertTableBean alertTableBean;

    private String buslineId;
    private String busStopId;
    private String description;

    public void createAlert(){
        try{
            Optional<Busline> optLine = findBuslineByBuslineId.search(buslineId);
            Optional<BusStop> optStop = findBusStopByBusStopId.search(busStopId);

            //FOR NOW WE CREATE BUS STOPS HERE BECAUSE THERE ISN'T AN INTERFACE FOR THAT YET
            if(optStop.isEmpty()){
                Set<Busline> busSet = new HashSet<>();
                busSet.add(optLine.get());

                busStopCreator.create(
                        "1",
                        "C/Example Address, 33",
                        busSet
                );
                optStop = findBusStopByBusStopId.search(busStopId);
            }

            if (optLine.isEmpty() || optStop.isEmpty()) {
                showMessage(FacesMessage.SEVERITY_ERROR, "Error al crear alerta", "La línia o la parada no existeixen");
            }else{
                alertCreator.create(
                        obtainAlertId(),
                        LocalDate.now(),
                        optLine.get().getBuslineId().value(),
                        optStop.get().getStopId().value(),
                        description
                );

                alertTableBean.reload();
                clearForm();
                showMessage(FacesMessage.SEVERITY_INFO, "Alerta creada correctament", null);
            }
        }catch(IllegalArgumentException e){
            showMessage(FacesMessage.SEVERITY_ERROR, "Error al crear alerta", e.getMessage());
        }
    }

    private void showMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }

    private void clearForm(){
        buslineId = busStopId = description = null;
    }

    private String obtainAlertId() {
        return String.valueOf(
                allAlertSearcher.search().stream()
                        .mapToInt(a -> Integer.parseInt(a.getAlertId().getValue()))
                        .max()
                        .orElse(0) + 1
        );

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBusStopId() {
        return busStopId;
    }

    public void setBusStopId(String busStopId) {
        this.busStopId = busStopId;
    }

    public String getBuslineId() {
        return buslineId;
    }

    public void setBuslineId(String buslineId) {
        this.buslineId = buslineId;
    }

}
