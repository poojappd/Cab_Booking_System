import java.util.HashMap;

public class CabCentralHub {

    private static HashMap<StationPoint, CabCentre> allCabCentres;

    CabCentralHub(){
        allCabCentres = new HashMap<>();
    }
    static void addCabCentre(CabCentre cabCentre, StationPoint stationPoint){
        allCabCentres.put(stationPoint, new CabCentre(stationPoint));
    }

    static void  addToCabCentre(Vehicle vehicle){}
    void addToCabCentre(Driver driver, StationPoint driverStationPoint){

    }
    static void addToCabCentre(Driver driver, Vehicle vehicle, StationPoint driverStationPoint){

    }

}
