package org.example.notificacions.alarm.infrastructure;

import org.example.notificacions.alarm.domain.Alert;
import org.example.notificacions.alarm.domain.AlertId;
import org.example.notificacions.alarm.domain.AlertRepository;

import java.util.*;

public class InMemoryAlertRepository implements AlertRepository {
    private final Map<String, List<Alert>> alerts = new TreeMap<>();

    @Override
    public List<Alert> findAllOrderedById(){
        return alerts.values().stream()
                .flatMap(List::stream)
                .toList();
    }

    @Override
    public Optional<Alert> findById(String alarmId){
        return this.findAllOrderedById().stream()
                .filter(e -> e.getAlertId().value().equals(alarmId))
                .findAny();
    }

    @Override
    public List<Alert> findAlarmByBusline(String lineId){
        return alerts.get(lineId);
    }

    @Override
    public AlertId verifiedAlertId(String id){
        Optional<Alert> alert = this.findById(id);
        AlertId verifiedAlertId;

        if(alert.isEmpty()){
            verifiedAlertId = new AlertId(id, this);
        }else{
            verifiedAlertId = alert.get().getAlertId();
        }

        return verifiedAlertId;
    }

    @Override
    public void save(String id, Alert alert){
        alerts.computeIfAbsent(id, k -> new ArrayList<>())
                .add(alert);
    }
}
