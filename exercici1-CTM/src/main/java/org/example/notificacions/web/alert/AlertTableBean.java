package org.example.notificacions.web.alert;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.example.notificacions.alarm.application.find.AllAlertSearcher;
import org.example.notificacions.alarm.domain.Alert;

import java.io.Serializable;
import java.util.List;

@Named("alertTableBean")
@ViewScoped
public class AlertTableBean  implements Serializable {

    @Inject
    private AllAlertSearcher allAlertSearcher;

    private List<Alert> alerts;
    private int rows = 10;

    @PostConstruct
    public void init(){
        alerts = allAlertSearcher.search();
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void reload(){
        alerts = allAlertSearcher.search();
        System.out.println("Ha arribat al reload de AlertTable");
    }
}
