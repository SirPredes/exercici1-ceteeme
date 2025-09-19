package org.example.notificacions.warning.domain;

import java.util.List;
import java.util.Optional;

public interface WarningRepository {
    Optional<Warning> findById(String id);
    List<Warning> findAll();
    List<Warning> findAlarmByBusline(String lineId);
    void save(Warning warning);
}
