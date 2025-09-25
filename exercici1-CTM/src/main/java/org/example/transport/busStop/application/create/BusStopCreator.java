package org.example.transport.busStop.application.create;

import org.example.transport.busStop.domain.BusStop;
import org.example.transport.busStop.domain.BusStopRepository;
import org.example.transport.busline.domain.Busline;

import java.util.Set;

public class BusStopCreator {
    private final BusStopRepository repository;

    public BusStopCreator(BusStopRepository repository){
        this.repository = repository;
    }

    public void create(String busStopId, String address, Set<Busline> buslines){

        BusStop newBusStop = new BusStop(repository
                .verifiedBusStopId(busStopId),
                address,
                buslines
        );

        repository.save(newBusStop);
    }
}
