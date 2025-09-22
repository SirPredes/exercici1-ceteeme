package org.example.transport.busStop.application.find;

import org.example.transport.busStop.domain.BusStop;
import org.example.transport.busStop.domain.BusStopRepository;

import java.util.List;

public class AllBusStopsSearcher {
    private final BusStopRepository repository;

    public AllBusStopsSearcher(BusStopRepository repository){
        this.repository = repository;
    }

    public List<BusStop> search(){
        return repository.findAllOrderedById();
    }
}
