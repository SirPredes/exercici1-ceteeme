package org.example.notificacions.Alarm.Application;

import org.example.notificacions.Alarm.Domain.Alert;
import org.example.notificacions.Alarm.Domain.AlertRepository;

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
