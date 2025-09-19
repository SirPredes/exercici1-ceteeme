package org.example.notificacions.warning.domain;

public class WarningId {
    private String value;

    private WarningRepository repository;

    public WarningId(String id, WarningRepository repository){
        this.createId(id, repository);
    }

    public String value(){
        return value;
    }

    private void createId(String id, WarningRepository repository){
        if(repository.findById(id).isPresent()){
            this.value = id;
            this.repository = repository;
        }else{
            throw new IllegalArgumentException("This id is already being used by another warning");
        }
    }
}
