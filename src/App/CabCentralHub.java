package App;

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
    static ArrayList<Object> searchAvailableVehiclesFromLocation(Location fromLocation, Location destination) {

        CabCentre chosenCabCentre = getNearbyCabCentre(fromLocation, destination);
        ArrayList<Object> resultList = new ArrayList<>();
        resultList.add(chosenCabCentre.getLocatedStationPoint());
        HashMap<VehicleType, ArrayList<VehicleInfo>> activeVehicles = chosenCabCentre.getAvailableVehicleInfo();

        try {
           if (!fromLocation.getStationPoint().equals(chosenCabCentre.getLocatedStationPoint())) {
               System.out.println("\nNo Cab Centres found at your location...\n");
               Thread.sleep(2000);

               System.out.println("Contacting other nearby cab centres...");
               Thread.sleep(4000);
           }
        }
        catch (InterruptedException ie){
           System.out.println("Some unexpected error has occured");
        }


        System.out.printf("\n%25s%s %25s\n","***********      Displaying all Vehicles Nearby ",chosenCabCentre.getLocatedStationPoint(),"       ***********\n" +
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
                   resultList.add(vehicleInfo.getDriverId());
               }
           }
        }
        return resultList;
    }


    static void arrangeTrip(String passengerName, Location passengerFromLocation,
                            Location passengerToLocation, int tripOtp, String driverId, StationPoint cabCentreStationPoint){
        CabCentre chosenCabCentre = allCabCentres.get(cabCentreStationPoint);
        chosenCabCentre.arrangeRide(driverId, passengerName, passengerFromLocation,
                passengerToLocation, tripOtp );

    }



}
