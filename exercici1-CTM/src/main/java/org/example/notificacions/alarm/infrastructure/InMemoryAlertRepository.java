package org.example.notificacions.alarm.infrastructure;

import org.example.notificacions.alarm.domain.Alert;
import org.example.notificacions.alarm.domain.AlertId;
import org.example.notificacions.alarm.domain.AlertRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryAlertRepository implements AlertRepository {
    private final Map<String, List<Alert>> alerts = new HashMap<String, List<Alert>>();

    @Override
    public List<Alert> findAll(){
        return alerts.values().stream()
                .flatMap(List::stream)
                .toList();
    }

    @Override
    public Optional<Alert> findById(String alarmId){
        return this.findAll().stream()
                .filter(e -> alarmId.equals(e.getAlertId()))
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
        alerts.get(id)
                .add(alert);
    }
}
