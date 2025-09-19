package org.example.transport.busStop.domain;

public class BusStopId {
    private String value;

    private BusStopRepository repository;

    public BusStopId(String id, BusStopRepository repository){
        this.createId(id, repository);
    }

    public String value(){
        return value;
    }

    private void createId(String id, BusStopRepository repository){
        if(repository.findByBusStopId(id).isPresent()){
            this.value = id;
            this.repository = repository;
        }else{
            throw new IllegalArgumentException("This id is already being used by another bus stop");
        }
    }
}
