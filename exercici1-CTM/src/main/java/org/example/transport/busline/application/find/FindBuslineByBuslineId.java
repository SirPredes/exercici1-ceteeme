package org.example.transport.busline.application.find;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import org.example.transport.busline.domain.Busline;
import org.example.transport.busline.domain.BuslineRepository;

import java.io.Serializable;
import java.util.Optional;

@Dependent
public class FindBuslineByBuslineId implements Serializable {
    private static final long serialVersionUID = 1L;

    private BuslineRepository repository;

    public FindBuslineByBuslineId(){}

    @Inject
    public FindBuslineByBuslineId(BuslineRepository repository){
        this.repository = repository;
    }

    public Optional<Busline> search(String id){
        return repository.findById(id);
    }
}
