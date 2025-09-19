package org.example.transport.busStop.domain;

import org.example.transport.busline.domain.Busline;

import java.util.List;
import java.util.Set;

public class BusStop {
    private final String stopId;
    private String address;

    private Set<Busline> lines;

    public BusStop(String stopId, String address, Set<Busline> lines) {
        this.stopId = stopId;
        this.address = address;
        this.lines = lines;
    }

    public String getStopId() {
        return stopId;
    }

    public String getAddress() {
        return address;
    }

    public List<Busline> getLines() {
        List<Busline> buslines = lines.stream().toList();
        return buslines;
    }

    public void addLine(Busline line){
        lines.add(line);
    }
}
