package org.example.transport.busline.infrastructure;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.transport.busline.domain.Busline;
import org.example.transport.busline.domain.BuslineId;
import org.example.transport.busline.domain.BuslineRepository;
import org.example.transport.schedule.domain.Schedule;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

@ApplicationScoped
public class InMemoryBuslineRepository implements BuslineRepository {
    private final Map<String, Busline> buslines = new TreeMap<String, Busline>();

    public InMemoryBuslineRepository(){}

    @Override
    public Optional<Busline> findById(String id) {
        return Optional.ofNullable(buslines.get(id));
    }

    @Override
    public List<Busline> findAllOrderedById() {
        return buslines.values().stream()
                .toList();
    }

    @Override
    public Schedule findScheduleByBusline(String lineId) {
        return buslines.get(lineId).getSchedule();
    }

    @Override
    public BuslineId verifiedBuslineId(String id){
        return new BuslineId(id, this);
    }

    @Override
    public void save(Busline line) {
        buslines.put(line.getBuslineId().value(), line);
    }
}
