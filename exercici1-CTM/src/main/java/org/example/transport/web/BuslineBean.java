package org.example.transport.web;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.example.transport.busline.application.create.BuslineCreator;
import org.example.transport.busline.application.find.AllBuslinesSearcher;
import org.example.transport.busline.domain.BusType;
import org.example.transport.busline.domain.Busline;
import org.example.transport.schedule.application.create.ScheduleCreator;
import org.example.transport.schedule.application.find.AllSchedulesSearcher;
import org.example.transport.schedule.application.find.FindScheduleByScheduleId;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class BuslineBean implements Serializable {

    @Inject
    private AllBuslinesSearcher allBuslinesSearcher;

    @Inject
    private AllSchedulesSearcher allSchedulesSearcher;

    @Inject
    private FindScheduleByScheduleId findScheduleByScheduleId;

    @Inject
    private BuslineCreator buslineCreator;

    @Inject
    private ScheduleCreator scheduleCreator;

    private List<Busline> buslines;

    // Campos del formulario
    private String lineId;
    private String name;
    private String origin;
    private String destination;
    private BusType busType;

    // Control de filas en la tabla
    private int rows = 20;

    @PostConstruct
    public void init() {
        buslines = allBuslinesSearcher.search();
    }

    public void createBusline(String lineId) {
        int oldScheduleId = Integer.parseInt(allSchedulesSearcher.search().getLast().getScheduleId().value());
        Integer newScheduleId = oldScheduleId + 1;
        String scheduleId = newScheduleId.toString();

        scheduleCreator.create(
                lineId,
                scheduleId,
                new ArrayList<>(),
                ""
        );

        buslineCreator.create(
                lineId,
                name,
                origin,
                destination,
                findScheduleByScheduleId.search(scheduleId).get(),
                busType
        );
        buslines = allBuslinesSearcher.search();
        clearForm();
    }

    private void clearForm() {
        lineId = name = origin = destination = null;
        busType = null;
    }

    // Getters y setters
    public List<Busline> getBuslines() { return buslines; }

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

    public int getRows() { return rows; }
    public void setRows(int rows) { this.rows = rows; }
}
