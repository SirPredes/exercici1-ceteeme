package org.example.transport.web.warinig;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.example.notificacions.warning.application.find.AllWarningSearcher;
import org.example.notificacions.warning.domain.Warning;

import java.io.Serializable;
import java.util.List;

@Named("warningTableBean")
@ViewScoped
public class WarningTableBean  implements Serializable {

    @Inject
    private AllWarningSearcher allWarningSearcher;

    private List<Warning> warnings;
    private int rows = 10;

    @PostConstruct
    public void init(){
        warnings = allWarningSearcher.search();
    }

    public List<Warning> getWarnings() {
        return warnings;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void reload(){
        warnings = allWarningSearcher.search();
    }
}
