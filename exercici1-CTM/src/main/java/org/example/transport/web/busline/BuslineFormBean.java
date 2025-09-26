package org.example.transport.web.busline;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.example.transport.busline.application.create.BuslineCreator;
import org.example.transport.busline.domain.BusType;
import org.example.transport.schedule.application.create.ScheduleCreator;
import org.example.transport.schedule.application.find.AllSchedulesSearcher;
import org.example.transport.schedule.application.find.FindScheduleByScheduleId;

import java.io.Serializable;
import java.util.ArrayList;

@Named("buslineFormBean")
@ViewScoped
public class BuslineFormBean implements Serializable {

    @Inject
    private BuslineCreator buslineCreator;

    @Inject
    private ScheduleCreator scheduleCreator;

    @Inject
    private AllSchedulesSearcher allSchedulesSearcher;

    @Inject
    private FindScheduleByScheduleId findScheduleByScheduleId;

    @Inject
    private BuslineTableBean buslineTableBean;

    private String lineId;
    private String name;
    private String origin;
    private String destination;
    private BusType busType;

    public void createBusline() {
        String scheduleId = obtainScheduleId();

        try{
            scheduleCreator.create(lineId, scheduleId, new ArrayList<>(), "");

            buslineCreator.create(
                    lineId,
                    name,
                    origin,
                    destination,
                    findScheduleByScheduleId.search(scheduleId).get(),
                    busType
            );

            showMessage(FacesMessage.SEVERITY_INFO, "Línea creada correctamente", null);

        }catch(IllegalArgumentException e){
            showMessage(FacesMessage.SEVERITY_ERROR, "Error al crear línea", e.getMessage());
        }

        buslineTableBean.reload();
        clearForm();
    }

    private void clearForm() {
        lineId = name = origin = destination = null;
        busType = null;
    }

    private void showMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance()
                .addMessage(
                        null,
                        new FacesMessage(severity, summary, detail)
                );
    }

    public String obtainScheduleId(){
        return String.valueOf(
                allSchedulesSearcher.search().stream()
                        .mapToInt(s -> Integer.parseInt(s.getScheduleId().value()))
                        .max()
                        .orElse(0) + 1
        );
    }

    // Getters y setters
    public String getLineId() { return lineId; }

    public void setLineId(String lineId) { this.lineId = lineId; }
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
    public String getOrigin() { return origin; }

    public void setOrigin(String origin) { this.origin = origin; }
    public String getDestination() { return destination; }

    public void setDestination(String destination) { this.destination = destination; }
    public BusType getBusType() { return busType; }
    public void setBusType(BusType busType) { this.busType = busType; }

    public BusType[] getBusTypes(){ return BusType.values(); }
}