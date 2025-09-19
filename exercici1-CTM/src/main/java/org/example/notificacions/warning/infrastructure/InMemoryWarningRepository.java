package org.example.notificacions.warning.infrastructure;

import org.example.notificacions.warning.domain.Warning;
import org.example.notificacions.warning.domain.WarningId;
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
    public void save(String id, Warning warning) {
        warnings.get(id).add(warning);
    }
}
