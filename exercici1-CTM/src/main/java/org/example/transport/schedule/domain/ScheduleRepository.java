package org.example.transport.schedule.domain;

import org.example.transport.busline.domain.Busline;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {
    List<Schedule> allSchedules();
    Optional<Schedule> findById(String id);
    void save(Busline line, Schedule schedule);
}
