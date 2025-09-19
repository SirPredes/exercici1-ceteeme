package org.example.transport.busline.application.find;

import org.example.transport.busStop.domain.BusStop;
import org.example.transport.busStop.domain.BusStopRepository;
import org.example.transport.busline.domain.Busline;
import org.example.transport.busline.domain.BuslineRepository;

import java.util.List;
import java.util.Optional;

public class FindBusStopsByBuslineId {
    private final BuslineRepository lineRepo;

    public FindBusStopsByBuslineId(BusStopRepository stopRepo, BuslineRepository lineRepo){
        this.lineRepo = lineRepo;
    }

    public List<BusStop> search(String line){

        Optional<Busline> lineaOpt = lineRepo.findById(line);

        if (lineaOpt.isEmpty()) {
            throw new IllegalArgumentException("Línea no encontrada: " + line);
        }

        Busline linea = lineaOpt.get();

        return linea.getBusStops();
    }
}
