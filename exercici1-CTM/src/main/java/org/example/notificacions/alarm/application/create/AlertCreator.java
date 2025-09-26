package org.example.notificacions.alarm.application.create;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import org.example.notificacions.alarm.domain.Alert;
import org.example.notificacions.alarm.domain.AlertRepository;

import java.io.Serializable;
import java.time.LocalDate;

@Dependent
public class AlertCreator implements Serializable {
    private static final long serialVersionUID = 1L;

    private AlertRepository repository;

    public AlertCreator(){}

    @Inject
    public AlertCreator(AlertRepository repository){
        this.repository = repository;
    }

    public void create(String alertId, LocalDate alertDate, String buslineId, String busStopId, String description){

        Alert newAlert = new Alert(repository
                .verifiedAlertId(alertId),
                alertDate,
                buslineId,
                busStopId,
                description
        );

        repository.save(buslineId, newAlert);
    }
}
