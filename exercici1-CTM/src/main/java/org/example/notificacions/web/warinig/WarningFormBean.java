package org.example.notificacions.web.warinig;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.example.notificacions.warning.application.create.WarningCreator;
import org.example.notificacions.warning.application.find.AllWarningSearcher;
import org.example.transport.busStop.application.create.BusStopCreator;
import org.example.transport.busStop.application.find.FindBusStopByBusStopId;
import org.example.transport.busStop.domain.BusStop;
import org.example.transport.busline.application.find.FindBuslineByBuslineId;
import org.example.transport.busline.domain.Busline;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Named("warningFormBean")
@ViewScoped
public class WarningFormBean  implements Serializable {

    @Inject
    private WarningCreator warningCreator;

    @Inject
    private BusStopCreator busStopCreator;

    @Inject
    private AllWarningSearcher allWarningSearcher;

    @Inject
    private FindBuslineByBuslineId findBuslineByBuslineId;

    @Inject
    private FindBusStopByBusStopId findBusStopByBusStopId;

    @Inject
    private WarningTableBean warningTableBean;
    private String targetDate;
    private String buslineId;
    private String busStopId;
    private String direction;
    private String description;

    public void createWarning() {
        try {
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
                showMessage(FacesMessage.SEVERITY_ERROR, "Error al crear avís", "La línia o la parada no existeixen");
            } else {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(targetDate, formatter);
                warningCreator.create(
                        obtainWarningId(),
                        LocalDate.now(),
                        date,
                        optLine.get().getBuslineId().value(),
                        optStop.get().getStopId().value(),
                        direction,
                        description
                );

                warningTableBean.reload();
                clearForm();
                showMessage(FacesMessage.SEVERITY_INFO, "Avís creat correctament", null);
            }
        }catch(IllegalArgumentException e){
            showMessage(FacesMessage.SEVERITY_ERROR, "Error al crear l'avís", e.getMessage());
        }
    }

    private void showMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }

    private void clearForm(){
        targetDate = buslineId = busStopId = direction = description = null;
    }

    private String obtainWarningId() {
        return String.valueOf(
                allWarningSearcher.search().stream()
                        .mapToInt(a -> Integer.parseInt(a.getWarningId().getValue()))
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

    public String getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(String targetDate) {
        this.targetDate = targetDate;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getBuslineId() {
        return buslineId;
    }

    public void setBuslineId(String buslineId) {
        this.buslineId = buslineId;
    }
}
