package org.example.transport.schedule.application;

import org.example.transport.schedule.domain.Schedule;
import org.example.transport.schedule.domain.ScheduleRepository;

import java.util.List;

public class AllSchedulesSearcher {
    private ScheduleRepository repository;

    public AllSchedulesSearcher(ScheduleRepository repository){
        this.repository = repository;
    }

    public List<Schedule> search(){
        return repository.allSchedules();
    }
}
