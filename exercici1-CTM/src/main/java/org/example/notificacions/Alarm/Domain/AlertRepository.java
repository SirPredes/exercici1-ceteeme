package org.example.notificacions.Alarm.Domain;

import java.util.List;

public interface AlertRepository {
    List<Alert> findById(String id);
    List<Alert> findAll();
    List<Alert> findAlarmByBusline(String lineId);
    void save(Alert alert);

}
