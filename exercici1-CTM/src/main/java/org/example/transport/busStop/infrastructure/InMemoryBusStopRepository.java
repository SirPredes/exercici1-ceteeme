package org.example.transport.busStop.infrastructure;

import org.example.transport.busStop.domain.BusStop;
import org.example.transport.busStop.domain.BusStopId;
import org.example.transport.busStop.domain.BusStopRepository;


import java.util.*;

public class InMemoryBusStopRepository implements BusStopRepository {
    private final Map<String, BusStop> busStops = new HashMap<String, BusStop>();

    @Override
    public List<BusStop> findAll(){
        return busStops.values().stream().toList();
    }

    @Override
    public Optional<BusStop> findByBusStopId(String stopId){
        return Optional.ofNullable(busStops.get(stopId));
    }

    @Override
    public BusStopId verifiedBusStopId(String id){
        Optional<BusStop> busStop = this.findByBusStopId(id);
        BusStopId verifiedBusStopId;

        if(busStop.isEmpty()){
            verifiedBusStopId = new BusStopId(id, this);
        }else{
            verifiedBusStopId = busStop.get().getStopId();
        }

        return verifiedBusStopId;
    }

    @Override
    public void save(BusStop stop){
        busStops.put(stop.getStopId().value(), stop);
    }
}
