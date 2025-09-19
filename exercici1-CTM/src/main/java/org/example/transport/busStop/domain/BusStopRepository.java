package org.example.transport.busStop.domain;

import java.util.List;
import java.util.Optional;

public interface BusStopRepository {
    Optional<BusStop> findByNumber(String numBusStop);
    List<BusStop> findAll();
    void save(BusStop stop);
}
