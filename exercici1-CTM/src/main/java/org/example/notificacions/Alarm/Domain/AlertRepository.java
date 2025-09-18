package org.example.notificacions.Alarm.Domain;

import java.util.List;
import java.util.Optional;

public interface AlertRepository {
    Optional<Alert> findById(String id);
    List<Alert> findAll();
    List<Alert> findAlarmByBusline(String lineId);
    void save(Alert alert);

}
