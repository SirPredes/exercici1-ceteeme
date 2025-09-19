package org.example.transport.schedule.domain;

import org.example.transport.busline.domain.Busline;

public interface ScheduleRepository {
    void save(Busline line, Schedule schedule);
}
