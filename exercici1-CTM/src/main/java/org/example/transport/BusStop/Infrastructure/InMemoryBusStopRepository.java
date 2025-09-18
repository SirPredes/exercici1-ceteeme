package org.example.transport.BusStop.Infrastructure;

import org.example.transport.BusStop.Domain.BusStop;
import org.example.transport.BusStop.Domain.BusStopRepository;


import java.util.*;

public class InMemoryBusStopRepository implements BusStopRepository {
    private final Map<String, BusStop> busStops = new HashMap<String, BusStop>();

    @Override
    public List<BusStop> findAll(){
        return busStops.values().stream().toList();
    }

    @Override
    public Optional<BusStop> findByNumber(String stopId){
        return Optional.ofNullable(busStops.get(stopId));
    }

    @Override
    public void save(BusStop stop){
        busStops.put(stop.getStopId(), stop);
    }
}
