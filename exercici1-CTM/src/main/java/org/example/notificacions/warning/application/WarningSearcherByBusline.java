package org.example.notificacions.warning.application;

import org.example.notificacions.warning.domain.Warning;
import org.example.notificacions.warning.domain.WarningRepository;

import java.util.List;

public class WarningSearcherByBusline {
    private WarningRepository repository;

    public WarningSearcherByBusline(WarningRepository repository){
        this.repository = repository;
    }

    public List<Warning> search(String lineId){
        return repository.findAlarmByBusline(lineId);
    }
}
