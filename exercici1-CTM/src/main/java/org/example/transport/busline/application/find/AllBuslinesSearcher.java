package org.example.transport.busline.application.find;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.transport.busline.domain.Busline;
import org.example.transport.busline.domain.BuslineRepository;

import java.util.List;

@ApplicationScoped
public class AllBuslinesSearcher {
    private BuslineRepository repository;

    @Inject
    public AllBuslinesSearcher(BuslineRepository repository){
        this.repository = repository;
    }

    public List<Busline> search(){
        return repository.findAllOrderedById();
    }
}
