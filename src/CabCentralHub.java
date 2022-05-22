import java.util.HashMap;

public class CabCentralHub {//admin

    private static HashMap<StationPoint, CabCentre> allCabCentres;

    CabCentralHub(){
        allCabCentres = new HashMap<>();
    }
    static void addCabCentre(Admin admin, CabCentre cabCentre, StationPoint stationPoint){
        allCabCentres.put(stationPoint, new CabCentre(stationPoint));
    }

    static void  addToCabCentre(Vehicle vehicle){}
    void addToCabCentre(Driver driver, StationPoint driverStationPoint){

    }
    static void addToCabCentre(Driver driver, Vehicle vehicle, StationPoint driverStationPoint){

    }

    static void getAvailableVehiclesFromStation(StationPoint stationPoint){
       CabCentre chosenCabCentre = allCabCentres.get(stationPoint);
       chosenCabCentre.
    }
    static void arrangeTrip(String passengerName, Location passengerFromLocation,
                            Location passengerToLocation, int tripOtp){
        CabCentre chosenCabCentre = allCabCentres.get(passengerFromLocation.getStationPoint());
        chosenCabCentre.
    }

}
