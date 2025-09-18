package org.example.transport.Busline.Application;

import org.example.transport.Busline.Domain.Busline;
import org.example.transport.Busline.Domain.BuslineRepository;

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
