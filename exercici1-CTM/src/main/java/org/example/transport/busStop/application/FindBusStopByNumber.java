package org.example.transport.busStop.application;

import org.example.transport.busStop.domain.BusStop;
import org.example.transport.busStop.domain.BusStopRepository;

import java.util.Optional;

public class FindBusStopByNumber {
    private final BusStopRepository busStopRepository;

    public FindBusStopByNumber(BusStopRepository busStopRepository){
        this.busStopRepository = busStopRepository;
    }

    public Optional<BusStop> search(String number){
        return busStopRepository.findByNumber(number);
    }
}
