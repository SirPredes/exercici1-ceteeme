package org.example.transport.BusStop.Application;

import org.example.transport.BusStop.Domain.BusStop;
import org.example.transport.BusStop.Domain.BusStopRepository;

import java.util.List;

public class AllBusStopsSearcher {
    private final BusStopRepository repository;

    public AllBusStopsSearcher(BusStopRepository repository){
        this.repository = repository;
    }

    public List<BusStop> search(){
        return repository.findAll();
    }
}
