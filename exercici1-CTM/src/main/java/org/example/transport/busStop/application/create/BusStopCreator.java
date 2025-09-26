package org.example.transport.busStop.application.create;

import jakarta.inject.Inject;
import org.example.transport.busStop.domain.BusStop;
import org.example.transport.busStop.domain.BusStopRepository;
import org.example.transport.busline.domain.Busline;

import java.io.Serializable;
import java.util.Set;

public class BusStopCreator implements Serializable {
    private static final long serialVersionUID = 1L;

    private final BusStopRepository repository;

    @Inject
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
