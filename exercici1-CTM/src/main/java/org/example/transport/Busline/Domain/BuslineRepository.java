package org.example.transport.Busline.Domain;

import org.example.transport.Schedule.Domain.Schedule;

import java.util.List;
import java.util.Optional;

public interface BuslineRepository {
    Optional<Busline> findById(String id);
    List<Busline> findAll();
    Schedule findScheduleByBusline(String lineId);
    void save(Busline line);
}
