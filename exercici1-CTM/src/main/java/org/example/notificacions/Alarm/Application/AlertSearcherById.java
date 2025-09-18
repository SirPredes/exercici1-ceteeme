package org.example.notificacions.Alarm.Application;

import org.example.notificacions.Alarm.Domain.Alert;
import org.example.notificacions.Alarm.Domain.AlertRepository;

import java.util.Optional;

public class AlertSearcherById {
    private final AlertRepository repository;

    public AlertSearcherById(AlertRepository repository){
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
