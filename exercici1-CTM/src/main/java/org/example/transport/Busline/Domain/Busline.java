package org.example.transport.Busline.Domain;

import org.example.transport.BusStop.Domain.BusStop;
import org.example.transport.Schedule.Domain.Schedule;

import java.util.*;

public class Busline {
    private final String lineId;
    private String origin;
    private String destination;
    private Schedule schedule;

    private BusType busType;

    public Busline(String lineId, String origin, String destination, Schedule schedule, BusType busType) {
        this.lineId = lineId;
        this.origin = origin;
        this.destination = destination;
        this.schedule = schedule;
        this.busType = busType;
    }

    public String getBuslineId() {
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
