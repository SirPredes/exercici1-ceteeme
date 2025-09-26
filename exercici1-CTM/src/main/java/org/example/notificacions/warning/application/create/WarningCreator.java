package org.example.notificacions.warning.application.create;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import org.example.notificacions.warning.domain.Warning;
import org.example.notificacions.warning.domain.WarningRepository;

import java.io.Serializable;
import java.time.LocalDate;

@Dependent
public class WarningCreator implements Serializable {
    private static final long serialVersionUID = 1L;

    private WarningRepository repository;

    public WarningCreator(){}

    @Inject
    public WarningCreator(WarningRepository repository){
        this.repository = repository;
    }

    public void create(String warningId, LocalDate warningDate, LocalDate targetDate, String buslineId, String busStopId, String direction, String description){

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
