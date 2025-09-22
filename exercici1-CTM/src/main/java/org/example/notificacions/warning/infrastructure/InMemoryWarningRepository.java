package org.example.notificacions.warning.infrastructure;

import org.example.notificacions.warning.domain.Warning;
import org.example.notificacions.warning.domain.WarningId;
import org.example.notificacions.warning.domain.WarningRepository;

import java.util.*;

public class InMemoryWarningRepository implements WarningRepository {
    private final Map<String, List<Warning>> warnings = new TreeMap<>();

    @Override
    public List<Warning> findAllOrderedById() {
        return warnings.values().stream()
                .flatMap(List::stream)
                .toList();
    }

    @Override
    public Optional<Warning> findById(String warningId) {
        return this.findAllOrderedById().stream()
                .filter(w -> w.getWarningId().value().equals(warningId))
                .findAny();
    }

    @Override
    public List<Warning> findAlarmByBusline(String lineId) {
        return warnings.get(lineId);
    }

    @Override
    public WarningId verifiedWarningId(String id){
        Optional<Warning> warning = this.findById(id);
        WarningId verifiedWarningId;

        if(warning.isEmpty()){
            verifiedWarningId = new WarningId(id, this);
        }else{
            verifiedWarningId = warning.get().getWarningId();
        }

        return verifiedWarningId;
    }

    @Override
    public void save(String buslineId, Warning warning) {
        warnings.computeIfAbsent(buslineId, k -> new ArrayList<>())
                .add(warning);
    }
}
