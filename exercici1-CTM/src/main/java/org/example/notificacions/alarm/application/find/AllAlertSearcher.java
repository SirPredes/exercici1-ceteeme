package org.example.notificacions.alarm.application.find;

import org.example.notificacions.alarm.domain.Alert;
import org.example.notificacions.alarm.domain.AlertRepository;

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
