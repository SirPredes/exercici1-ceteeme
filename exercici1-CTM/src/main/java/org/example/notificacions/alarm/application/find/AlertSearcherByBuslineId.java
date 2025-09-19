package org.example.notificacions.alarm.application.find;

import org.example.notificacions.alarm.domain.Alert;
import org.example.notificacions.alarm.domain.AlertRepository;

import java.util.List;

public class AlertSearcherByBuslineId {
    private AlertRepository repository;

    public AlertSearcherByBuslineId(AlertRepository repository){
        this.repository = repository;
    }

    public List<Alert> search(String lineId){
        return repository.findAlarmByBusline(lineId);
    }
}
