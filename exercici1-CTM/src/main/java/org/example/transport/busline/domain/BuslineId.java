package org.example.transport.busline.domain;

public class BuslineId {
    private String value;

    private BuslineRepository repository;

    public BuslineId(String id, BuslineRepository repository){
        this.createId(id, repository);
    }

    public String value(){
        return value;
    }

    private void createId(String id, BuslineRepository repository){
        if(repository.findById(id).isPresent()){
            this.value = id;
            this.repository = repository;
        }else{
            throw new IllegalArgumentException("This id is already being used by another busline");
        }
    }
}
