import java.util.HashMap;

public class CabCentralHub {

    HashMap<StationPoint, CabCentre> allCabCentres;

    CabCentralHub(){
        allCabCentres = new HashMap<>();
    }
    void createCabCentre(StationPoint stationPoint){
        allCabCentres.put(stationPoint, new CabCentre(stationPoint));
    }

    void addToCabCentre(){}
}
