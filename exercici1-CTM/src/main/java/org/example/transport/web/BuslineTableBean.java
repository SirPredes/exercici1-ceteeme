package org.example.transport.web;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.example.transport.busline.application.find.AllBuslinesSearcher;
import org.example.transport.busline.domain.Busline;

import java.io.Serializable;
import java.util.List;

@Named("buslineTableBean")
@ViewScoped
public class BuslineTableBean implements Serializable {

    @Inject
    private AllBuslinesSearcher allBuslinesSearcher;

    private List<Busline> buslines;
    private int rows = 10;

    @PostConstruct
    public void init() {
        buslines = allBuslinesSearcher.search();
    }

    public List<Busline> getBuslines() {
        return buslines;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void reload(){
        buslines = allBuslinesSearcher.search();
    }
}