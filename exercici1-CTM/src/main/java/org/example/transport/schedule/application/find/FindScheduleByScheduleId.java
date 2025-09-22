package org.example.transport.schedule.application.find;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.transport.schedule.domain.Schedule;
import org.example.transport.schedule.domain.ScheduleRepository;

import java.util.Optional;

@ApplicationScoped
public class FindScheduleByScheduleId {
    private ScheduleRepository repository;

    @Inject
    public FindScheduleByScheduleId(ScheduleRepository repository){
        this.repository = repository;
    }

    public Optional<Schedule> search(String id){
        return repository.findById(id);
    }
}
