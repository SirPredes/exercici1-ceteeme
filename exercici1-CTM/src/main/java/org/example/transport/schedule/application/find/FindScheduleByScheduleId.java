package org.example.transport.schedule.application.find;

import org.example.transport.schedule.domain.Schedule;
import org.example.transport.schedule.domain.ScheduleRepository;

public class FindScheduleByScheduleId {
    private ScheduleRepository repository;

    public FindScheduleByScheduleId(ScheduleRepository repository){
        this.repository = repository;
    }

    public Schedule search(String id){
        return repository.findById(id);
    }
}
