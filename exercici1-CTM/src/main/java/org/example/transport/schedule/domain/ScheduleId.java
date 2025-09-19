package org.example.transport.schedule.domain;

public class ScheduleId {
    private String value;

    private ScheduleRepository repository;

    public ScheduleId(String id, ScheduleRepository repository){
        this.createId(id, repository);
    }

    public String value(){
        return this.value;
    }

    private void createId(String id, ScheduleRepository repository){
        if(repository.findById(id) != null){
            this.value = id;
        }else{
            throw new IllegalArgumentException("This id is already being used by another schedule");
        }
    }
}
