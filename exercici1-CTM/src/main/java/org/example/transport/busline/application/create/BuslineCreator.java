package org.example.transport.busline.application.create;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import org.example.transport.busline.domain.BusType;
import org.example.transport.busline.domain.Busline;
import org.example.transport.busline.domain.BuslineRepository;
import org.example.transport.schedule.domain.Schedule;

import java.io.Serializable;

@Dependent
public class BuslineCreator implements Serializable {
    private static final long serialVersionUID = 1L;
    private BuslineRepository repository;

    public BuslineCreator(){}

    @Inject
    public BuslineCreator(BuslineRepository repository){
        this.repository = repository;
    }

    public void create(String lineId, String name, String origin, String destination, Schedule schedule, BusType busType){

        Busline newBusline = new Busline(repository
                .verifiedBuslineId(lineId),
                name,
                origin,
                destination,
                schedule,
                busType
        );

        repository.save(newBusline);
    }
}
