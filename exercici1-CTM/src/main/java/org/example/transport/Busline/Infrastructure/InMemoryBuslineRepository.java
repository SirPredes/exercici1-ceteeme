package org.example.transport.Busline.Infrastructure;

import java.util.*;

import org.example.transport.Busline.Domain.Busline;
import org.example.transport.Busline.Domain.BuslineRepository;
import org.example.transport.Schedule.Domain.Schedule;


public class InMemoryBuslineRepository implements BuslineRepository {
    private final HashMap<String, Busline> buslines = new HashMap<String, Busline>();

    @Override
    public Optional<Busline> findById(String id) {
        return Optional.ofNullable(buslines.get(id));
    }

    @Override
    public void save(Busline line) {
        buslines.put(line.getBuslineId(), line);
    }

    @Override
    public List<Busline> findAll() {
        return new ArrayList<>(buslines.values());
    }

    @Override
    public Schedule findScheduleByBusline(String lineId) {
        return buslines.get(lineId).getSchedule();
    }
}
