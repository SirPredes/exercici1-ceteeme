package org.example.transport.busline.domain;

import org.example.transport.busStop.domain.BusStop;
import org.example.transport.schedule.domain.Schedule;

import java.io.Serializable;
import java.util.*;

public class Busline implements Serializable {
    private static final long serialVersionUID = 1L;
    private final BuslineId lineId;
    private final String name;

    private String origin;
    private String destination;

    private Schedule schedule;

    private BusType busType;

    public Busline(BuslineId lineId, String name, String origin, String destination, Schedule schedule, BusType busType) {
        this.lineId = lineId;
        this.name = name;
        this.origin = origin;
        this.destination = destination;
        this.schedule = schedule;
        this.busType = busType;
    }

    public BuslineId getBuslineId() {
        return lineId;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getName(){
        return name;
    }

    public String getCurrentTimetableURL() {
        return schedule.getCurrentTimetableURL();
    }

    public List<String> getPreviousTimetablesURL(){
        return schedule.getPreviousTimetableURL();
    }

    public BusType getBusType() {
        return busType;
    }

    public void setBusType(BusType busType) {
        this.busType = busType;
    }

    public List<BusStop> getBusStops() {
        return schedule.getBusStopList();
    }
}
