package org.example.transport.busline.application.find;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import org.example.transport.busline.domain.Busline;
import org.example.transport.busline.domain.BuslineRepository;

import java.io.Serializable;
import java.util.List;

@Dependent
public class AllBuslinesSearcher implements Serializable {
    private static final long serialVersionUID = 1L;

    private BuslineRepository repository;

    public AllBuslinesSearcher(){}

    @Inject
    public AllBuslinesSearcher(BuslineRepository repository){
        this.repository = repository;
    }

    public List<Busline> search(){
        return repository.findAllOrderedById();
    }
}
