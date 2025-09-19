package org.example.notificacions.warning.application.find;

import org.example.notificacions.warning.domain.Warning;
import org.example.notificacions.warning.domain.WarningRepository;

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
