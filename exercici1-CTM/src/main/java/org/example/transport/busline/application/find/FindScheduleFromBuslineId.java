package org.example.transport.busline.application.find;

import org.example.transport.busline.domain.BuslineRepository;
import org.example.transport.schedule.domain.Schedule;

public class FindScheduleFromBuslineId {
    private final BuslineRepository repository;

    public FindScheduleFromBuslineId(BuslineRepository repository){
        this.repository = repository;
    }

    public Schedule search(String buslineId){
        return repository.findScheduleByBusline(buslineId);
    }
}
