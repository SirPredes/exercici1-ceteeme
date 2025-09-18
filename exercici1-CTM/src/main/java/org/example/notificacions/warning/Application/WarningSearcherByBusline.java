package org.example.notificacions.warning.Application;

import org.example.notificacions.warning.Domain.Warning;
import org.example.notificacions.warning.Domain.WarningRepository;

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
