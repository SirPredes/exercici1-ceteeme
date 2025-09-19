package org.example.transport.schedule.domain;

import org.example.transport.busStop.domain.BusStop;
import org.example.transport.busline.domain.BuslineId;

import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private BuslineId buslineId;
    private ScheduleId scheduleId;

    private List<BusStop> busStopList;

    private String currentTimetableURL;
    private List<String> previousTimetableURL;

    public Schedule(BuslineId buslineId, ScheduleId scheduleId, String currentTimetableURL, List<BusStop> busStopList) {
        this.buslineId = buslineId;
        this.scheduleId = scheduleId;
        this.currentTimetableURL = currentTimetableURL;
        this.busStopList = busStopList;
        this.previousTimetableURL = new ArrayList<>();
    }

    public BuslineId getBuslineId() {
        return buslineId;
    }

    public ScheduleId getScheduleId(){
        return scheduleId;
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
