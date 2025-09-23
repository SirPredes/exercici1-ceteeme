package org.example.transport.schedule.application.find;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import org.example.transport.schedule.domain.Schedule;
import org.example.transport.schedule.domain.ScheduleRepository;

import java.util.List;

@Dependent
public class AllSchedulesSearcher {
    private ScheduleRepository repository;

    @Inject
    public AllSchedulesSearcher(ScheduleRepository repository){
        this.repository = repository;
    }

    public List<Schedule> search(){
        return repository.findAllOrderedById();
    }
}
