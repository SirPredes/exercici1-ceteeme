package org.example.transport.Busline.Application;

import org.example.transport.Busline.Domain.BuslineRepository;
import org.example.transport.Schedule.Domain.Schedule;

public class FindScheduleFromBusline {
    private final BuslineRepository repository;

    public FindScheduleFromBusline(BuslineRepository repository){
        this.repository = repository;
    }

    public Schedule search(String buslineId){
        return repository.findScheduleByBusline(buslineId);
    }
}
