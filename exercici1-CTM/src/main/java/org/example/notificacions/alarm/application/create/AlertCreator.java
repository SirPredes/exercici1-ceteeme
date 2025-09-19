package org.example.notificacions.alarm.application.create;

import org.example.notificacions.alarm.domain.Alert;
import org.example.notificacions.alarm.domain.AlertId;
import org.example.notificacions.alarm.domain.AlertRepository;

import java.util.Date;

public class AlertCreator {
    private AlertRepository repository;

    public AlertCreator(AlertRepository repository){
        this.repository = repository;
    }

    public void create(String alertId, Date alertDate, String buslineId, String busStopId, String description){
        AlertId verifiedAlertId = repository.verifiedAlertId(alertId);

        Alert newAlert = new Alert(verifiedAlertId, alertDate, buslineId, busStopId, description);

        repository.save(buslineId, newAlert);
    }
}
