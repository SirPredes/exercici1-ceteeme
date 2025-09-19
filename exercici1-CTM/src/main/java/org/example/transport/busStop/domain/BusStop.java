package org.example.transport.busStop.domain;

import org.example.transport.busline.domain.Busline;

import java.util.List;
import java.util.Set;

public class BusStop {
    private final BusStopId stopId;
    private String address;

    private Set<Busline> lines;

    public BusStop(BusStopId stopId, String address, Set<Busline> lines) {
        this.stopId = stopId;
        this.address = address;
        this.lines = lines;
    }

    public BusStopId getStopId() {
        return stopId;
    }

    public String getAddress() {
        return address;
    }

    public List<Busline> getLines() {
        return lines.stream().toList();
    }

    public void addLine(Busline line){
        lines.add(line);
    }
}
