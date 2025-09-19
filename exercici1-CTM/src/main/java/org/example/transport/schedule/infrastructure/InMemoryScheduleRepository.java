package org.example.transport.schedule.infrastructure;

import org.example.transport.schedule.domain.Schedule;
import org.example.transport.schedule.domain.ScheduleRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryScheduleRepository implements ScheduleRepository{
    private final Map<String, Schedule> schedules = new HashMap<>();

    @Override
    public List<Schedule> allSchedules(){
        return schedules.values()
                .stream()
                .toList();
    }

    @Override
    public Optional<Schedule> findById(String id){
        return Optional.ofNullable(schedules.get(id));
    }

    @Override
    public void save(String line, Schedule schedule) {
        //TODO: Aixo es una prova pero s'ha de refer segurament a nivell de domini
        schedules.put(line, schedule);
    }
}
