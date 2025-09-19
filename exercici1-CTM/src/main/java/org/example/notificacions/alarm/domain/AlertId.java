package org.example.notificacions.alarm.domain;

public class AlertId {
    private String value;

    private AlertRepository repository;

    public AlertId(String id, AlertRepository repository){
        this.createId(id, repository);
    }

    public String value(){
        return value;
    }

    private void createId(String id, AlertRepository repository){
        if(repository.findById(id).isPresent()){
            this.value = id;
            this.repository = repository;
        }else{
            throw new IllegalArgumentException("This id is already being used by another schedule");
        }
    }
}
