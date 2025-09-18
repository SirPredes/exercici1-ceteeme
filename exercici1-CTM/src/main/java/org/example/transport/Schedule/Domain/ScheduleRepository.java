package org.example.transport.Schedule.Domain;

import org.example.transport.Busline.Domain.Busline;

public interface ScheduleRepository {
    void save(Busline line, Schedule schedule);
}
