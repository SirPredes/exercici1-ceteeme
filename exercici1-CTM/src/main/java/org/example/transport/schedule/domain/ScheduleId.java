package org.example.transport.schedule.domain;

import java.io.Serializable;

public class ScheduleId implements Serializable {
    private static final long serialVersionUID = 1L;

    private String value;

    private ScheduleRepository repository;

    public ScheduleId(String id, ScheduleRepository repository){
        this.createId(id, repository);
    }

    public String value(){
        return value;
    }

    private void createId(String id, ScheduleRepository repository){
        if(repository.findById(id).isEmpty()){
            this.value = id;
            this.repository = repository;
        }else{
            throw new IllegalArgumentException("This id is already being used by another schedule");
        }
    }
}
