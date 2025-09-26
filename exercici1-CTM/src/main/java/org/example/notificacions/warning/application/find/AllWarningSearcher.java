package org.example.notificacions.warning.application.find;

import jakarta.inject.Inject;
import org.example.notificacions.warning.domain.Warning;
import org.example.notificacions.warning.domain.WarningRepository;

import java.io.Serializable;
import java.util.List;

public class AllWarningSearcher implements Serializable {
    private static final long serialVersionUID = 1L;

    private WarningRepository repository;

    public AllWarningSearcher(){}

    @Inject
    public AllWarningSearcher(WarningRepository repository){
        this.repository = repository;
    }

    public List<Warning> search(){
        return repository.findAllOrderedById();
    }
}
