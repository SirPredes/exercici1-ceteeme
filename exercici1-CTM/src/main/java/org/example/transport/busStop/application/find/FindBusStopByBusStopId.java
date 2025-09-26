package org.example.transport.busStop.application.find;

import jakarta.enterprise.context.Dependent;
import org.example.transport.busStop.domain.BusStop;
import org.example.transport.busStop.domain.BusStopRepository;

import java.io.Serializable;
import java.util.Optional;

@Dependent
public class FindBusStopByBusStopId implements Serializable {
    private static final long serialVersionUID = 1L;

    private BusStopRepository busStopRepository;

    public FindBusStopByBusStopId(){}

    public FindBusStopByBusStopId(BusStopRepository busStopRepository){
        this.busStopRepository = busStopRepository;
    }

    public Optional<BusStop> search(String number){
        return busStopRepository.findByBusStopId(number);
    }
}
