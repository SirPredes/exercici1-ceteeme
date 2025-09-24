package org.example.transport.schedule.infrastructure;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.transport.schedule.domain.Schedule;
import org.example.transport.schedule.domain.ScheduleId;
import org.example.transport.schedule.domain.ScheduleRepository;

import java.util.TreeMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
public class InMemoryScheduleRepository implements ScheduleRepository{
    private final Map<String, Schedule> schedules = new TreeMap<>();

    public InMemoryScheduleRepository(){}

    @Override
    public List<Schedule> findAllOrderedById(){
        return schedules.values()
                .stream()
                .toList();
    }

    @Override
    public Optional<Schedule> findById(String id){
        return this.findAllOrderedById().stream()
                .filter(s -> s.getScheduleId().value().equals(id))
                .findAny();
    }

    public ScheduleId verifiedScheduleId(String id){
        return new ScheduleId(id, this);
    }

    @Override
    public void save(String line, Schedule schedule) {
        schedules.put(line, schedule);
    }
}
