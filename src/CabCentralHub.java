import java.util.HashMap;

public class CabCentralHub {

    private HashMap<StationPoint, CabCentre> allCabCentres;

    CabCentralHub(){
        allCabCentres = new HashMap<>();
    }
    void createCabCentre(StationPoint stationPoint){
        allCabCentres.put(stationPoint, new CabCentre(stationPoint));
    }

    void addToCabCentre(){}
}
