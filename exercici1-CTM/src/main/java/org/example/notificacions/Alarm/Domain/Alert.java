package org.example.notificacions.Alarm.Domain;

import org.example.transport.BusStop.Domain.BusStop;
import org.example.transport.Busline.Domain.Busline;

import java.util.Date;

public class Alert {
    private String alertId;
    private Date alertDate;

    private Busline busline;
    private BusStop busStop;
    private String description;

    public Alert(String alertId, Date alertDate, Busline busline, BusStop busStop, String description) {
        this.alertId = alertId;
        this.alertDate = alertDate;
        this.busline = busline;
        this.busStop = busStop;
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

    public Busline getBusline() {
        return busline;
    }

    public void setBusline(Busline busline) {
        this.busline = busline;
    }

    public BusStop getBusStop() {
        return busStop;
    }

    public void setBusStop(BusStop busStop) {
        this.busStop = busStop;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
