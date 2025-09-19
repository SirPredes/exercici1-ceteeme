package org.example.notificacions.alarm.domain;

import java.util.Date;

public class Alert {
    private String alertId;
    private Date alertDate;

    private String buslineId;
    private String busStopId;
    private String description;

    public Alert(String alertId, Date alertDate, String buslineId, String busStopId, String description) {
        this.alertId = alertId;
        this.alertDate = alertDate;
        this.buslineId = buslineId;
        this.busStopId = busStopId;
        this.description = description;
    }

    public String getAlertId() {
        return alertId;
    }

    public void setAlertId(String alertId) {
        this.alertId = alertId;
    }

    public Date getAlertDate() {
        return alertDate;
    }

    public void setAlertDate(Date alertDate) {
        this.alertDate = alertDate;
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
}
