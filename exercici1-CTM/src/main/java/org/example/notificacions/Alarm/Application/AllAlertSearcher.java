package org.example.notificacions.Alarm.Application;

import org.example.notificacions.Alarm.Domain.Alert;
import org.example.notificacions.Alarm.Domain.AlertRepository;

import java.util.List;

public class AllAlertSearcher {
    private final AlertRepository repository;

    public AllAlertSearcher(AlertRepository repository){
        this.repository = repository;
    }

    public List<Alert> search(){
        return repository.findAll();
    }
}
