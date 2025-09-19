package org.example.transport.busStop.application.find;

import org.example.transport.busStop.domain.BusStop;
import org.example.transport.busStop.domain.BusStopRepository;

import java.util.Optional;

public class FindBusStopByBusStopId {
    private final BusStopRepository busStopRepository;

    public FindBusStopByBusStopId(BusStopRepository busStopRepository){
        this.busStopRepository = busStopRepository;
    }

    public Optional<BusStop> search(String number){
        return busStopRepository.findByNumber(number);
    }
}
