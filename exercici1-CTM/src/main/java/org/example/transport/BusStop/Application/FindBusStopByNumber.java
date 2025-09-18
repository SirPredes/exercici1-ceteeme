package org.example.transport.BusStop.Application;

import org.example.transport.BusStop.Domain.BusStop;
import org.example.transport.BusStop.Domain.BusStopRepository;

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
