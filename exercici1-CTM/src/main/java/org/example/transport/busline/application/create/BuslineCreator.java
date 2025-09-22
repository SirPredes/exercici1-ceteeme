package org.example.transport.busline.application.create;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.transport.busline.domain.BusType;
import org.example.transport.busline.domain.Busline;
import org.example.transport.busline.domain.BuslineId;
import org.example.transport.busline.domain.BuslineRepository;
import org.example.transport.schedule.domain.Schedule;

@ApplicationScoped
public class BuslineCreator {
    private BuslineRepository repository;

    @Inject
    public BuslineCreator(BuslineRepository repository){
        this.repository = repository;
    }

    public void create(String lineId, String name, String origin, String destination, Schedule schedule, BusType busType){
        BuslineId verifiedBuslineId = repository.verifiedBuslineId(lineId);

        Busline newBusline = new Busline(verifiedBuslineId, name, origin, destination, schedule, busType);

        repository.save(newBusline);
    }
}
