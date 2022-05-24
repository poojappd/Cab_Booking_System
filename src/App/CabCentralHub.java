package App;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class CabCentralHub {//admin

    private static final HashMap<StationPoint, CabCentre> allCabCentres = new HashMap<>();
    private static final CabCentralHub thisCentralHub = new CabCentralHub();
    private static final HashMap<String, BookingHistory> allPassengerBookingHistory = new HashMap<>();

    static void addCabCentre(Admin admin, CabCentre cabCentre, StationPoint stationPoint){
        allCabCentres.put(stationPoint, cabCentre);
    }

    static void  addToCabCentre(Vehicle vehicle){}
    void addToCabCentre(Driver driver, StationPoint driverStationPoint){

    }
    static void addToCabCentre(Driver driver, Vehicle vehicle, StationPoint driverStationPoint){

    }

    private static CabCentre getNearbyCabCentre(Location fromLocation){
        StationPoint stationPoint = fromLocation.getStationPoint();
        CabCentre chosenCabCentre = allCabCentres.get(stationPoint);
        if (chosenCabCentre == null) {
            chosenCabCentre = allCabCentres.get(Map.getNearestStationPoint(stationPoint, allCabCentres.keySet()));
        }
        return chosenCabCentre;
    }
    public static ArrayList<Object> searchAvailableVehiclesFromLocation(Location fromLocation, Location destination) {

        CabCentre chosenCabCentre = getNearbyCabCentre(fromLocation);
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
                   double fare = FareCalculator.calculateFare(vehicleInfo.getVehicleType(), vehicleInfo.getModel(),
                           Map.calculateDistance(fromLocation, destination));

                   System.out.printf("%25d %25s %25s %25s %25s", i, vehicleInfo.getVehicleType(), vehicleInfo.getModel(),
                           vehicleInfo.getMaxOccupants(), fare);
                   System.out.println();
                   i++;
                   vehicleInfo.setFare(fare);
                   resultList.add(vehicleInfo);
               }

           }

        }
        return resultList;
    }


    public static BookingHistory arrangeTrip(String userName, String passengerName, Location passengerFromLocation,
                                             Location passengerToLocation, int tripOtp, String driverId, StationPoint cabCentreStationPoint, VehicleInfo vehicleInfo){

        CabCentre chosenCabCentre = allCabCentres.get(cabCentreStationPoint);
        String chosenDriverName = chosenCabCentre.getDriverNameFromId(driverId);
        LocalDateTime bookingTime = LocalDateTime.now();
        BookingHistory newBookingHistory = new BookingHistory(passengerName, chosenDriverName,
                CabServiceType.CAB_BOOKING, bookingTime, passengerFromLocation,
                passengerToLocation, vehicleInfo);
        allPassengerBookingHistory.put(newBookingHistory.getBookingId(), newBookingHistory);

        chosenCabCentre.arrangeRide(driverId, passengerName, passengerFromLocation,
                passengerToLocation, tripOtp, newBookingHistory.getBookingId() );

        return newBookingHistory;

    }

    public static void arrangeCarPool(){

    }

    public static void rentCab(CarType carType, int preferredDuration){



    }

    static void updateDriverStatus(Driver driver, ActiveStatus activeStatus){
        CabCentre driverCabCentre = allCabCentres.get(driver.getDefaultStationPoint());
        HashMap<VehicleType, ArrayList<VehicleInfo>> activeVehiclesInfo = driverCabCentre.getAvailableVehicleInfo();
        activeVehiclesInfo.forEach((k,v) ->
        {
            for (VehicleInfo vehicleInfo: v) {
                if(vehicleInfo.getDriverId().equals(driver.getDriverId())){
                    vehicleInfo.setActiveStatus(activeStatus);
                }
            }
        });

    }

    static void setBookingStatus(Driver driver, String bookingId, CabBookingStatus status){
        BookingHistory pastBookingHistory = allPassengerBookingHistory.get(bookingId);
        if(pastBookingHistory != null){
            pastBookingHistory.setCabBookingStatus(status);
        }

    }




}
