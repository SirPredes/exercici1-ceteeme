package org.example.transport.Busline.Application;

import org.example.transport.BusStop.Domain.BusStop;
import org.example.transport.BusStop.Domain.BusStopRepository;
import org.example.transport.Busline.Domain.Busline;
import org.example.transport.Busline.Domain.BuslineRepository;

import java.util.List;
import java.util.Optional;

public class FindBusStopsByBusline {
    private final BuslineRepository lineRepo;

    public FindBusStopsByBusline(BusStopRepository stopRepo, BuslineRepository lineRepo){
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
