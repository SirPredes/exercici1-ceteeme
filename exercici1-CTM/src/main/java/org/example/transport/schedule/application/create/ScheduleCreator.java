package org.example.transport.schedule.application.create;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import org.example.transport.busStop.domain.BusStop;
import org.example.transport.busline.domain.BuslineId;
import org.example.transport.busline.domain.BuslineRepository;
import org.example.transport.schedule.domain.Schedule;
import org.example.transport.schedule.domain.ScheduleId;
import org.example.transport.schedule.domain.ScheduleRepository;

import java.util.List;

@Dependent
public class ScheduleCreator {
    private ScheduleRepository scheduleRepo;
    private BuslineRepository buslineRepo;

    @Inject
    public ScheduleCreator(ScheduleRepository scheduleRepo, BuslineRepository buslineRepo){
        this.scheduleRepo = scheduleRepo;
        this.buslineRepo = buslineRepo;
    }

    public void create(String buslineId, String scheduleId, List<BusStop> busStopList, String TimeTable){
        BuslineId verifiedBuslineId = buslineRepo.verifiedBuslineId(buslineId);
        ScheduleId verifiedScheduleId = scheduleRepo.verifiedScheduleId(scheduleId);

        Schedule newSchedule = new Schedule(verifiedBuslineId, verifiedScheduleId, TimeTable, busStopList);

        scheduleRepo.save(verifiedBuslineId.value(), newSchedule);
    }
}
