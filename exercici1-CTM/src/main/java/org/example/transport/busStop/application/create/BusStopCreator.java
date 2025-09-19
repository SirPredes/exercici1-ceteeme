package org.example.transport.busStop.application.create;

import org.example.transport.busStop.domain.BusStop;
import org.example.transport.busStop.domain.BusStopId;
import org.example.transport.busStop.domain.BusStopRepository;
import org.example.transport.busline.domain.Busline;

import java.util.Set;

public class BusStopCreator {
    private final BusStopRepository repository;

    public BusStopCreator(BusStopRepository repository){
        this.repository = repository;
    }

    public void create(String busStopId, String address, Set<Busline> buslines){
        BusStopId verifiedBusStopId = repository.verifiedBusStopId(busStopId);

        BusStop newBusStop = new BusStop(verifiedBusStopId, address, buslines);

        repository.save(newBusStop);
    }
}
