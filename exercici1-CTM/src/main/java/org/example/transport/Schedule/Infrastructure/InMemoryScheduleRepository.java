package org.example.transport.Schedule.Infrastructure;

import org.example.transport.Busline.Domain.Busline;
import org.example.transport.Schedule.Domain.ScheduleRepository;
import org.example.transport.Schedule.Domain.Schedule;

import java.util.*;

public class InMemoryScheduleRepository implements ScheduleRepository{
    private final Map<Object, Object> schedules = new HashMap<>();

    @Override
    public void save(Busline line, Schedule schedule) {
        //TODO: Aixo es una prova pero s'ha de refer segurament a nivell de domini
        schedules.put(line.getBuslineId(), schedule);
    }
}
