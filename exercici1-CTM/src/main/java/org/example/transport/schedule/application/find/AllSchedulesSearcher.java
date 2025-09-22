package org.example.transport.schedule.application.find;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.transport.schedule.domain.Schedule;
import org.example.transport.schedule.domain.ScheduleRepository;

import java.util.List;

@ApplicationScoped
public class AllSchedulesSearcher {
    private final ScheduleRepository repository;

    @Inject
    public AllSchedulesSearcher(ScheduleRepository repository){
        this.repository = repository;
    }

    public List<Schedule> search(){
        return repository.findAllOrderedById();
    }
}
