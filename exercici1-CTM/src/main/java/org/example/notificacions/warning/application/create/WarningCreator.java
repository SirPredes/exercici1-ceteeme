package org.example.notificacions.warning.application.create;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import org.example.notificacions.warning.domain.Warning;
import org.example.notificacions.warning.domain.WarningRepository;

import java.io.Serializable;
import java.util.Date;

@Dependent
public class WarningCreator implements Serializable {
    private static final long serialVersionUID = 1L;

    private WarningRepository repository;

    @Inject
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
