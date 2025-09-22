package org.example.notificacions.alarm.domain;

import java.util.List;
import java.util.Optional;

public interface AlertRepository {
    Optional<Alert> findById(String id);
    List<Alert> findAllOrderedById();
    List<Alert> findAlarmByBusline(String lineId);
    AlertId verifiedAlertId(String id);
    void save(String id, Alert alert);

}
