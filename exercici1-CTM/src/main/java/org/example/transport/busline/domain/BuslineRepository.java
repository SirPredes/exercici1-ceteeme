package org.example.transport.busline.domain;

import org.example.transport.schedule.domain.Schedule;

import java.util.List;
import java.util.Optional;

public interface BuslineRepository {
    Optional<Busline> findById(String id);
    List<Busline> findAll();
    Schedule findScheduleByBusline(String lineId);
    BuslineId verifiedBuslineId(String id);
    void save(Busline line);
}
