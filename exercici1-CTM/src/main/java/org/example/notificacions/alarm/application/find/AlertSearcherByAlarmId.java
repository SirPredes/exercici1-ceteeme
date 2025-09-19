package org.example.notificacions.alarm.application.find;

import org.example.notificacions.alarm.domain.Alert;
import org.example.notificacions.alarm.domain.AlertRepository;

import java.util.Optional;

public class AlertSearcherByAlarmId {
    private final AlertRepository repository;

    public AlertSearcherByAlarmId(AlertRepository repository){
        this.repository = repository;
    }

    public Alert search(String id){
        Optional<Alert> alertOpt = repository.findById(id);

        if (alertOpt.isEmpty()){
            throw new IllegalArgumentException("Alerta no encontrada: " + id);
        }

        Alert alert = alertOpt.get();

        return alert;
    }
}
