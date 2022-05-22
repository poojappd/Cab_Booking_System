import java.util.ArrayList;
import java.util.HashMap;

public class CabCentralHub {//admin

    private static HashMap<StationPoint, CabCentre> allCabCentres = new HashMap<>();

    CabCentralHub(){
        allCabCentres = new HashMap<>();
    }
    static void addCabCentre(Admin admin, CabCentre cabCentre, StationPoint stationPoint){
        allCabCentres.put(stationPoint, cabCentre);
    }

    static void  addToCabCentre(Vehicle vehicle){}
    void addToCabCentre(Driver driver, StationPoint driverStationPoint){

    }
    static void addToCabCentre(Driver driver, Vehicle vehicle, StationPoint driverStationPoint){

    }

    private static CabCentre getNearbyCabCentre(Location fromLocation, Location destination){
        StationPoint stationPoint = fromLocation.getStationPoint();
        CabCentre chosenCabCentre = allCabCentres.get(stationPoint);
        if (chosenCabCentre == null) {
            chosenCabCentre = allCabCentres.get(Map.getNearestStationPoint(stationPoint, allCabCentres.keySet()));
        }
        return chosenCabCentre;
    }
    static void viewAvailableVehiclesFromLocation(Location fromLocation, Location destination){
        CabCentre chosenCabCentre = getNearbyCabCentre(fromLocation, destination);

        if(chosenCabCentre != null) {
           ArrayList<String> driverIds = new ArrayList<>();
           HashMap<VehicleType, ArrayList<VehicleInfo>> activeVehicles = chosenCabCentre.getAvailableVehicleInfo();
           System.out.printf("\n%25s%s %25s\n","***********      Displaying all Vehicles Nearby ",stationPoint,"       ***********\n" +
                   "____________________________________________________________________________________________________________________________________________________________________");
           System.out.printf("%25s %25s %25s %25s %25s\n", "S.No.", "Vehicle", "Model", "Max Occupants", "Fare");
           System.out.println("____________________________________________________________________________________________________________________________________________________________________");
           int i = 1;
           for (VehicleType vehicleType : activeVehicles.keySet()) {


               for (VehicleInfo vehicleInfo : activeVehicles.get(vehicleType)) {
                   if (vehicleInfo.activeStatus == ActiveStatus.ACTIVE) {
                       System.out.printf("%25d %25s %25s %25s %25s", i, vehicleInfo.getVehicleType(), vehicleInfo.getModel(),
                               vehicleInfo.getMaxOccupants(),
                               FareCalculator.calculateFare(vehicleInfo.getVehicleType(), vehicleInfo.getModel(),
                                       Map.calculateDistance(fromLocation, destination)));
                       System.out.println();
                       i++;
                       driverIds.add(vehicleInfo.getDriverId());
                   }
               }
           }
       }

    }
    static void arrangeTrip(String passengerName, Location passengerFromLocation,
                            Location passengerToLocation, int tripOtp){
        CabCentre chosenCabCentre = allCabCentres.get(passengerFromLocation.getStationPoint());
        //chosenCabCentre.
    }

    public static void main(String[] args) {
        Admin admin = Admin.instantiateOnce("Admin@123");
        admin.createMap();
        admin.initializeCabCentralHub();

        Location location = Map.getLocationFromOption(StationPoint.PALLAVARAM, 2);
        Location location1 = Map.getLocationFromOption(StationPoint.GUDUVANCHERY,1);

        viewAvailableVehiclesFromLocation(location, location1);

    }

}
