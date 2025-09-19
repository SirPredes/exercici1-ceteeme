package org.example.notificacions.warning.infrastructure;

import org.example.notificacions.warning.domain.Warning;
import org.example.notificacions.warning.domain.WarningRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryWarningRepository implements WarningRepository {
    private final Map<String, List<Warning>> warnings = new HashMap<String, List<Warning>>();

    @Override
    public List<Warning> findAll() {
        return warnings.values().stream()
                .flatMap(List::stream)
                .toList();
    }

    @Override
    public Optional<Warning> findById(String warningId) {
        return this.findAll().stream()
                .filter(w -> warningId.equals(w.getWarningId()))
                .findAny();
    }

    @Override
    public List<Warning> findAlarmByBusline(String lineId) {
        return warnings.get(lineId);
    }

    @Override
    public void save(Warning warning) {
        //TODO: Implement it in the domain
    }
}
