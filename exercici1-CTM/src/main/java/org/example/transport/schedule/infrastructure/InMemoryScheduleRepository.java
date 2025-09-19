package org.example.transport.schedule.infrastructure;

import org.example.transport.busline.domain.Busline;
import org.example.transport.schedule.domain.ScheduleRepository;
import org.example.transport.schedule.domain.Schedule;

import java.util.*;

public class InMemoryScheduleRepository implements ScheduleRepository{
    private final Map<String, Schedule> schedules = new HashMap<>();

    @Override
    public List<Schedule> allSchedules(){
        return schedules.values()
                .stream()
                .toList();
    }

    @Override
    public void save(Busline line, Schedule schedule) {
        //TODO: Aixo es una prova pero s'ha de refer segurament a nivell de domini
        schedules.put(line.getBuslineId(), schedule);
    }
}
