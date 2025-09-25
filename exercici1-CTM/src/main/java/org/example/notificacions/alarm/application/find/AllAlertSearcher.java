package org.example.notificacions.alarm.application.find;

import jakarta.inject.Inject;
import org.example.notificacions.alarm.domain.Alert;
import org.example.notificacions.alarm.domain.AlertRepository;

import java.io.Serializable;
import java.util.List;

public class AllAlertSearcher implements Serializable {
    private static final long serialVersionUID = 1L;

    private final AlertRepository repository;

    @Inject
    public AllAlertSearcher(AlertRepository repository){
        this.repository = repository;
    }

    public List<Alert> search(){
        return repository.findAllOrderedById();
    }
}
