package org.example.notificacions.warning.domain;

import java.io.Serializable;
import java.time.LocalDate;

public class Warning implements Serializable {
    private static final long serialVersionUID = 1L;

    private WarningId warningId;
    private LocalDate warningDate;
    private LocalDate targetDate;

    private String buslineId;
    private String busStopId;
    private String direction;

    private String description;

    public Warning(WarningId warningId, LocalDate warningDate, LocalDate targetDate, String buslineId, String busStopId, String direction, String description) {
        this.warningId = warningId;
        this.warningDate = warningDate;
        this.targetDate = targetDate;
        this.buslineId = buslineId;
        this.busStopId = busStopId;
        this.direction = direction;
        this.description = description;
    }

    public WarningId getWarningId() {
        return warningId;
    }

    public void setWarningId(WarningId warningId) {
        this.warningId = warningId;
    }

    public LocalDate getWarningDate() {
        return warningDate;
    }

    public void setWarningDate(LocalDate warningDate) {
        this.warningDate = warningDate;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public String getBuslineId() {
        return buslineId;
    }

    public void setBuslineId(String buslineId) {
        this.buslineId = buslineId;
    }

    public String getBusStopId() {
        return busStopId;
    }

    public void setBusStopId(String busStopId) {
        this.busStopId = busStopId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
