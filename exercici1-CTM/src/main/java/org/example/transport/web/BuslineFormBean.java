package org.example.transport.web;

import jakarta.enterprise.context.RequestScoped;
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
@RequestScoped
public class BuslineFormBean implements Serializable {

    @Inject
    private BuslineCreator buslineCreator;

    @Inject
    private ScheduleCreator scheduleCreator;

    @Inject
    private AllSchedulesSearcher allSchedulesSearcher;

    @Inject
    private FindScheduleByScheduleId findScheduleByScheduleId;

    private String lineId;
    private String name;
    private String origin;
    private String destination;
    private BusType busType;

    public void createBusline() {
        int oldScheduleId = Integer.parseInt(allSchedulesSearcher.search().getLast().getScheduleId().value());
        String scheduleId = String.valueOf(oldScheduleId + 1);

        scheduleCreator.create(lineId, scheduleId, new ArrayList<>(), "");

        buslineCreator.create(
                lineId,
                name,
                origin,
                destination,
                findScheduleByScheduleId.search(scheduleId).get(),
                busType
        );

        clearForm();
    }

    private void clearForm() {
        lineId = name = origin = destination = null;
        busType = null;
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
}