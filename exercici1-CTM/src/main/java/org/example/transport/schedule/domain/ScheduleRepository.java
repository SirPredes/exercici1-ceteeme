package org.example.transport.schedule.domain;

import org.example.transport.busline.domain.Busline;

import java.util.List;

public interface ScheduleRepository {
    List<Schedule> allSchedules();
    Schedule findById(String id);
    void save(Busline line, Schedule schedule);
}
