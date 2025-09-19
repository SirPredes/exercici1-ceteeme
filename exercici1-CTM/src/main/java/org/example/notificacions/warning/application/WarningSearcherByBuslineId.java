package org.example.notificacions.warning.application;

import org.example.notificacions.warning.domain.Warning;
import org.example.notificacions.warning.domain.WarningRepository;

import java.util.List;

public class WarningSearcherByBuslineId {
    private WarningRepository repository;

    public WarningSearcherByBuslineId(WarningRepository repository){
        this.repository = repository;
    }

    public List<Warning> search(String lineId){
        return repository.findAlarmByBusline(lineId);
    }
}
