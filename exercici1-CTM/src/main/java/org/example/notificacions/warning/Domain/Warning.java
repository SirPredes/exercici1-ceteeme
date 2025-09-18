package org.example.notificacions.warning.Domain;

import org.example.transport.Busline.Domain.Busline;

import java.util.Date;

public class Warning {
    private String warningId;
    private Date warningDate;
    private Date targetDate;

    private String buslineId;
    private String busStopId;
    private String direction;

    private String description;

    public Warning(String warningId, Date warningDate, Date targetDate, String buslineId, String busStopId, String direction, String description) {
        this.warningId = warningId;
        this.warningDate = warningDate;
        this.targetDate = targetDate;
        this.buslineId = buslineId;
        this.busStopId = busStopId;
        this.direction = direction;
        this.description = description;
    }

    public String getWarningId() {
        return warningId;
    }

    public void setWarningId(String warningId) {
        this.warningId = warningId;
    }

    public Date getWarningDate() {
        return warningDate;
    }

    public void setWarningDate(Date warningDate) {
        this.warningDate = warningDate;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
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
