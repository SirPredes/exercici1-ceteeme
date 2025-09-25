package org.example.notificacions.warning.application.create;

import org.example.notificacions.warning.domain.Warning;
import org.example.notificacions.warning.domain.WarningRepository;

import java.util.Date;

public class WarningCreator {
    private WarningRepository repository;

    public WarningCreator(WarningRepository repository){
        this.repository = repository;
    }

    public void create(String warningId, Date warningDate, Date targetDate, String buslineId, String busStopId, String direction, String description){

        Warning newWarning = new Warning(repository
                .verifiedWarningId(warningId),
                warningDate,
                targetDate,
                buslineId,
                busStopId,
                direction,
                description
        );

        repository.save(buslineId, newWarning);
    }
}
