package org.example.notificacions.warning.Application;

import org.example.notificacions.warning.Domain.Warning;
import org.example.notificacions.warning.Domain.WarningRepository;

import java.util.List;

public class AllWarningSearcher {
    private final WarningRepository repository;

    public AllWarningSearcher(WarningRepository repository){
        this.repository = repository;
    }

    public List<Warning> search(){
        return repository.findAll();
    }
}
