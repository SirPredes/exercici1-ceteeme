package org.example.notificacions.alarm.application.find;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import org.example.notificacions.alarm.domain.Alert;
import org.example.notificacions.alarm.domain.AlertRepository;

import java.io.Serializable;
import java.util.List;

@Dependent
public class AllAlertSearcher implements Serializable {
    private static final long serialVersionUID = 1L;

    private AlertRepository repository;

    public AllAlertSearcher(){}

    @Inject
    public AllAlertSearcher(AlertRepository repository){
        this.repository = repository;
    }

    public List<Alert> search(){
        return repository.findAllOrderedById();
    }
}
