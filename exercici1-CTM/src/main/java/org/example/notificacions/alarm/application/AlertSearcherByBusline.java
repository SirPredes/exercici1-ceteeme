package org.example.notificacions.alarm.application;

import org.example.notificacions.alarm.domain.Alert;
import org.example.notificacions.alarm.domain.AlertRepository;

import java.util.List;

public class AlertSearcherByBusline {
    private AlertRepository repository;

    public AlertSearcherByBusline(AlertRepository repository){
        this.repository = repository;
    }

    public List<Alert> search(String lineId){
        return repository.findAlarmByBusline(lineId);
    }
}
