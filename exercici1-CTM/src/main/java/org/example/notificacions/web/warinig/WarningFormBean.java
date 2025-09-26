package org.example.notificacions.web.warinig;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.example.notificacions.warning.application.create.WarningCreator;
import org.example.notificacions.warning.application.find.AllWarningSearcher;
import org.example.notificacions.warning.domain.Warning;
import org.example.transport.busStop.application.create.BusStopCreator;
import org.example.transport.busStop.application.find.FindBusStopByBusStopId;
import org.example.transport.busStop.domain.BusStop;
import org.example.transport.busline.application.find.FindBuslineByBuslineId;
import org.example.transport.busline.domain.Busline;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Named("warningFormBean")
@ViewScoped
public class WarningFormBean  implements Serializable {

    @Inject
    private WarningCreator warningCreator;

    @Inject
    private BusStopCreator busStopCreator;

    @Inject
    private AllWarningSearcher allwarningSearcher;

    @Inject
    private FindBuslineByBuslineId findBuslineByBuslineId;

    @Inject
    private FindBusStopByBusStopId findBusStopByBusStopId;

    private String warningId;
    private String targetDate;
    private String buslineId;
    private String busStopId;
    private String direction;
    private String description;

    public void createWarning(){
        String warningId = obtainWarningId();

        try{
            //FOR NOW WE CREATE BUS STOPS HERE BECAUSE THERE ISN'T AN INTERFACE FOR THAT YET
            Set<Busline> busSet = new HashSet<>();


            Optional<Busline> optLine = findBuslineByBuslineId.search(buslineId);
            Optional<BusStop> optStop = findBusStopByBusStopId.search(busStopId);

            if(optLine.isEmpty() || optStop.isEmpty()){
                FacesContext.getCurrentInstance()
                        .addMessage(
                                null,
                                new FacesMessage(
                                        FacesMessage.SEVERITY_ERROR,
                                        "Error al crear avís",
                                        "La línia o la parada no existeixen"
                                )
                        );
            }else{
                busSet.add(optLine.get());

                busStopCreator.create(
                        "1",
                        "C/Example Address, 33",
                        busSet
                );
                warningCreator.create(
                        warningId,
                        LocalDate.now(),
                        LocalDate.parse(targetDate),
                        optLine.get().getBuslineId().value(),
                        optStop.get().getStopId().value(),
                        direction,
                        description
                );

                FacesContext.getCurrentInstance()
                        .addMessage(
                                null,
                                new FacesMessage(
                                        FacesMessage.SEVERITY_INFO,
                                        "Alvis creat correctamente",
                                        null
                                )
                        );
            }

        }catch(IllegalArgumentException e){
            FacesContext.getCurrentInstance()
                    .addMessage(
                            null,
                            new FacesMessage(
                                    FacesMessage.SEVERITY_ERROR,
                                    "Error al crear warninga",
                                    "Algun error ha ocorregut a l'hora de crear l'avís"
                            )
                    );
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBusStopId() {
        return busStopId;
    }

    public void setBusStopId(String busStopId) {
        this.busStopId = busStopId;
    }

    public String getBuslineId() {
        return buslineId;
    }

    public void setBuslineId(String buslineId) {
        this.buslineId = buslineId;
    }

    public String getWarningId() {
        return warningId;
    }

    public void setWarningId(String warningId) {
        this.warningId = warningId;
    }

    private String obtainWarningId() {
        Optional<Warning> a = allwarningSearcher.search().stream().findAny();

        int oldWarningId = a.map(warning -> Integer.parseInt(warning.getWarningId().value())).orElse(1);

        return String.valueOf(oldWarningId + 1);
    }

}
