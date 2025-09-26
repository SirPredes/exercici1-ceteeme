package org.example.notificacions.web.alert;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.example.notificacions.alarm.application.create.AlertCreator;
import org.example.notificacions.alarm.application.find.AllAlertSearcher;
import org.example.notificacions.alarm.domain.Alert;
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

    private String alertId;
    private String buslineId;
    private String busStopId;
    private String description;

    public void createAlert(){
        String alertId = obtainAlertId();



        try{
            //FOR NOW WE CREATE BUS STOPS HERE BECAUSE THERE ISN'T AN INTERFACE FOR THAT YET
            Set<Busline> busSet = new HashSet<>();
            busSet.add(findBuslineByBuslineId.search(buslineId).get());

            Optional<Busline> optLine = findBuslineByBuslineId.search(buslineId);
            Optional<BusStop> optStop = findBusStopByBusStopId.search(busStopId);

            if(optLine.isEmpty() || optStop.isEmpty()){
                FacesContext.getCurrentInstance()
                        .addMessage(
                                null,
                                new FacesMessage(
                                        FacesMessage.SEVERITY_ERROR,
                                        "Error al crear Alerta",
                                        "La línia o la parada no existeixen"
                                )
                        );
            }else{

                busStopCreator.create(
                        "1",
                        "C/Example Address, 33",
                        busSet
                );
                alertCreator.create(
                        alertId,
                        LocalDate.now(),
                        optLine.get().getBuslineId().value(),
                        optStop.get().getStopId().value(),
                        description
                );

                FacesContext.getCurrentInstance()
                        .addMessage(
                                null,
                                new FacesMessage(
                                        FacesMessage.SEVERITY_INFO,
                                        "Alerta creada correctamente",
                                        null
                                )
                        );
            }

        }catch(IllegalArgumentException e){
            FacesContext.getCurrentInstance()
                    .addMessage(
                            null,
                            new FacesMessage(
                                    FacesMessage.SEVERITY_ERROR,
                                    "Error al crear Alerta",
                                    "Algun error ha ocorregut a l'hora de crear l'alarma"
                            )
                    );
        }
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

    public String getAlertId() {
        return alertId;
    }

    public void setAlertId(String alertId) {
        this.alertId = alertId;
    }

    private String obtainAlertId() {
        Optional<Alert> a = allAlertSearcher.search().stream().findAny();

        int oldAlertId = a.map(alert -> Integer.parseInt(alert.getAlertId().value())).orElse(1);

        return String.valueOf(oldAlertId + 1);
    }

}
