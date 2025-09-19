package org.example.transport.busline.application;

import org.example.transport.busline.domain.Busline;
import org.example.transport.busline.domain.BuslineRepository;

import java.util.List;

public class AllBuslinesSearcher {
    private final BuslineRepository repository;

    public AllBuslinesSearcher(BuslineRepository repository){
        this.repository = repository;
    }

    public List<Busline> search(){
        return repository.findAll();
    }
}
