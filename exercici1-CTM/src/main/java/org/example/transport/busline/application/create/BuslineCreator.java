package org.example.transport.busline.application.create;

import org.example.transport.busline.domain.BusType;
import org.example.transport.busline.domain.Busline;
import org.example.transport.busline.domain.BuslineId;
import org.example.transport.busline.domain.BuslineRepository;
import org.example.transport.schedule.domain.Schedule;

public class BuslineCreator {
    private final BuslineRepository repository;

    public BuslineCreator(BuslineRepository repository){
        this.repository = repository;
    }

    public void create(String lineId, String name, String origin, String destination, Schedule schedule, BusType busType){
        BuslineId verifiedBuslineId = repository.verifiedBuslineId(lineId);

        Busline newBusline = new Busline(verifiedBuslineId, name, origin, destination, schedule, busType);

        repository.save(newBusline);
    }
}
