package org.example.transport.busStop.infrastructure;

import org.example.transport.busStop.domain.BusStop;
import org.example.transport.busStop.domain.BusStopId;
import org.example.transport.busStop.domain.BusStopRepository;


import java.util.TreeMap;
import java.util.Map;
import java.util.List;
import java.util.Optional;

public class InMemoryBusStopRepository implements BusStopRepository {
    private final Map<String, BusStop> busStops = new TreeMap<>();

    @Override
    public List<BusStop> findAllOrderedById(){
        return busStops.values().stream().toList();
    }

    @Override
    public Optional<BusStop> findByBusStopId(String stopId){
        return Optional.ofNullable(busStops.get(stopId));
    }

    @Override
    public BusStopId verifiedBusStopId(String id){
        return new BusStopId(id, this);
    }

    @Override
    public void save(BusStop stop){
        busStops.put(stop.getStopId().value(), stop);
    }
}
