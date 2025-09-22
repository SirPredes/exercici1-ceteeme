package org.example.transport.schedule.application.find;

import org.example.transport.schedule.domain.Schedule;
import org.example.transport.schedule.domain.ScheduleRepository;

import java.util.Optional;

public class FindScheduleByScheduleId {
    private ScheduleRepository repository;

    public FindScheduleByScheduleId(ScheduleRepository repository){
        this.repository = repository;
    }

    public Optional<Schedule> search(String id){
        return repository.findById(id);
    }
}
