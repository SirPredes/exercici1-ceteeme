package org.example.notificacions.warning.application.create;

import org.example.notificacions.warning.domain.Warning;
import org.example.notificacions.warning.domain.WarningId;
import org.example.notificacions.warning.domain.WarningRepository;

import java.util.Date;

public class WarningCreator {
    private WarningRepository repository;

    public WarningCreator(WarningRepository repository){
        this.repository = repository;
    }

    public void create(String warningId, Date warningDate, Date targetDate, String buslineId, String busStopId, String direction, String description){
        WarningId verifiedWarningId = repository.verifiedWarningId(warningId);

        Warning newWarning = new Warning(verifiedWarningId, warningDate, targetDate, buslineId, busStopId, direction, description);

        repository.save(buslineId, newWarning);
    }
}
