package org.example.transport.schedule.application.find;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import org.example.transport.schedule.domain.Schedule;
import org.example.transport.schedule.domain.ScheduleRepository;

import java.io.Serializable;
import java.util.Optional;

@Dependent
public class FindScheduleByScheduleId implements Serializable {
    private static final long serialVersionUID = 1L;
    private ScheduleRepository repository;

    public FindScheduleByScheduleId(){}

    @Inject
    public FindScheduleByScheduleId(ScheduleRepository repository){
        this.repository = repository;
    }

    public Optional<Schedule> search(String id){
        return repository.findById(id);
    }
}
