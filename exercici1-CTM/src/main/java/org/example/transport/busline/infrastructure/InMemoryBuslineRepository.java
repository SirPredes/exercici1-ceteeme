package org.example.transport.busline.infrastructure;

import org.example.transport.busline.domain.Busline;
import org.example.transport.busline.domain.BuslineId;
import org.example.transport.busline.domain.BuslineRepository;
import org.example.transport.schedule.domain.Schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


public class InMemoryBuslineRepository implements BuslineRepository {
    private final HashMap<String, Busline> buslines = new HashMap<String, Busline>();

    @Override
    public Optional<Busline> findById(String id) {
        return Optional.ofNullable(buslines.get(id));
    }

    @Override
    public List<Busline> findAll() {
        return new ArrayList<>(buslines.values());
    }

    @Override
    public Schedule findScheduleByBusline(String lineId) {
        return buslines.get(lineId).getSchedule();
    }

    @Override
    public BuslineId verifiedBuslineId(String id){
        Optional<Busline> busline = this.findById(id);
        BuslineId verifiedBuslineId;

        if(busline.isEmpty()){
            verifiedBuslineId = new BuslineId(id, this);
        }else{
            verifiedBuslineId = busline.get().getBuslineId();
        }

        return verifiedBuslineId;
    }

    @Override
    public void save(Busline line) {
        buslines.put(line.getBuslineId().value(), line);
    }
}
