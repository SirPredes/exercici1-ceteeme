package org.example.notificacions.warning.application;

import org.example.notificacions.warning.domain.Warning;
import org.example.notificacions.warning.domain.WarningRepository;

import java.util.Optional;

public class WarningSearcherByWarningId {
    private final WarningRepository repository;

    public WarningSearcherByWarningId(WarningRepository repository){
        this.repository = repository;
    }

    public Warning search(String id){
        Optional<Warning> warningOpt = repository.findById(id);

        if(warningOpt.isEmpty()){
            throw new IllegalArgumentException("Warning no encontrado: " + id);
        }

        Warning warning = warningOpt.get();

        return warning;
    }
}
