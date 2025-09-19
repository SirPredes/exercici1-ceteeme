package org.example.transport.busStop.domain;

import java.util.List;
import java.util.Optional;

public interface BusStopRepository {
    Optional<BusStop> findByBusStopId(String BusStopId);
    List<BusStop> findAll();
    BusStopId verifiedBusStopId(String id);
    void save(BusStop stop);
}
