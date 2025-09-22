package org.example.transport.schedule.domain;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {
    List<Schedule> findAllOrderedById();
    Optional<Schedule> findById(String id);
    ScheduleId verifiedScheduleId(String id);
    void save(String line, Schedule schedule);
}
