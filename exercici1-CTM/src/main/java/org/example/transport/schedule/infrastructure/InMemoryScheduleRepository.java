package org.example.transport.schedule.infrastructure;

import org.example.transport.schedule.domain.Schedule;
import org.example.transport.schedule.domain.ScheduleId;
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

    public ScheduleId verifiedScheduleId(String id){
        Optional<Schedule> schedule = this.findById(id);
        ScheduleId verifiedScheduleId;

        if(schedule.isEmpty()){
            verifiedScheduleId = new ScheduleId(id, this);
        }else{
            verifiedScheduleId = schedule.get().getScheduleId();
        }

        return verifiedScheduleId;
    }

    @Override
    public void save(String line, Schedule schedule) {
        schedules.put(line, schedule);
    }
}
