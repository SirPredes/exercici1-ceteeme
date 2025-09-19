package org.example.transport.schedule.domain;

import org.example.transport.busStop.domain.BusStop;

import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private String buslineId;

    private List<BusStop> busStopList;

    private String currentTimetableURL;
    private List<String> previousTimetableURL;

    public Schedule(String buslineId, String currentTimetableURL, List<BusStop> busStopList) {
        this.buslineId = buslineId;
        this.currentTimetableURL = currentTimetableURL;
        this.busStopList = busStopList;
        this.previousTimetableURL = new ArrayList<>();
    }

    public String getBuslineId() {
        return buslineId;
    }

    public List<BusStop> getBusStopList() {
        return busStopList;
    }

    public String getCurrentTimetableURL() {
        return currentTimetableURL;
    }

    public List<String> getPreviousTimetableURL() {
        return previousTimetableURL;
    }

    public void updateTimetable(String updatedTimetable){
        previousTimetableURL.add(currentTimetableURL);
        currentTimetableURL = updatedTimetable;
    }
}
