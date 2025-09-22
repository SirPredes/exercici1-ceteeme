package org.example.notificacions.warning.domain;

import java.util.List;
import java.util.Optional;

public interface WarningRepository {
    Optional<Warning> findById(String id);
    List<Warning> findAllOrderedById();
    List<Warning> findAlarmByBusline(String lineId);
    WarningId verifiedWarningId(String id);
    void save(String id, Warning warning);
}
