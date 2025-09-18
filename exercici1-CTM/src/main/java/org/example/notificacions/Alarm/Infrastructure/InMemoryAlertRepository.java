package org.example.notificacions.Alarm.Infrastructure;

import org.example.notificacions.Alarm.Domain.Alert;
import org.example.notificacions.Alarm.Domain.AlertRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryAlertRepository implements AlertRepository {
    private final Map<String, List<Alert>> alerts = new HashMap<String, List<Alert>>();

    @Override
    public List<Alert> findAll(){
        return alerts.values().stream()
                .flatMap(List::stream)
                .toList();
    }

    @Override
    public List<Alert> findById(String alarmId){
        return this.findAll()
                .stream().filter(e -> alarmId.compareTo(e.getId()));
    }

    @Override
    public List<Alert> findAlarmByBusline(String lineId){
        return alerts.get(lineId);
    }

    @Override
    public void save(Alert alert){
        //TODO: Implement it in the domain
    }
}
