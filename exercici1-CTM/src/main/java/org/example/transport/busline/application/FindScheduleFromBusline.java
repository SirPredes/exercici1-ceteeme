package org.example.transport.busline.application;

import org.example.transport.busline.domain.BuslineRepository;
import org.example.transport.schedule.domain.Schedule;

public class FindScheduleFromBusline {
    private final BuslineRepository repository;

    public FindScheduleFromBusline(BuslineRepository repository){
        this.repository = repository;
    }

    public Schedule search(String buslineId){
        return repository.findScheduleByBusline(buslineId);
    }
}
