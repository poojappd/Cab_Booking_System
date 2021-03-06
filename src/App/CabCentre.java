package App;

import java.util.ArrayList;
import java.util.HashMap;

class CabCentre {
    private final StationPoint locatedStationPoint;
    private HashMap<VehicleType, ArrayList<VehicleInfo>> activeVehiclesInfo;
    private HashMap<VehicleType, ArrayList<Vehicle>> allAvailableVehicles;
    private HashMap<String, Driver> availableDrivers;

    private HashMap<VehicleType, ArrayList<Vehicle>> vehiclesWithNoDriverAssigned;
    private HashMap<VehicleType, ArrayList<Driver>> driverWithNoVehicleAssigned;


    StationPoint getLocatedStationPoint(){
        return locatedStationPoint;
    }

    CabCentre(StationPoint locatedStationPoint){
        this.locatedStationPoint = locatedStationPoint;
        setCabCentre();
    }

    void addVehicleWithDriver(Vehicle newVehicle, Driver newDriver){
        //pre assigned driver with vehicle shud only be passed
        newVehicle.setVehicleDriverId(newDriver.getDriverId());
        allAvailableVehicles.get(newVehicle.getVehicleType()).add(newVehicle);
        availableDrivers.put(newDriver.getDriverId(), newDriver);
        CarType carType;
        if(newVehicle instanceof Car){
            carType = ((Car) newVehicle).getCarType();
        }
        else {
            carType = CarType.NONE;
        }

        activeVehiclesInfo.get(newVehicle.getVehicleType()).add(
                new VehicleInfo(newDriver.getDriverId(), newVehicle.getVehicleId(),newVehicle.getVehicleType(),
                        newVehicle.getVehicleName(), newVehicle.getMaxOccupants(),newDriver.getFullName(), carType));

    }

    void addVehicleOnly(Vehicle newVehicle){//has ownerId pre assigned
        ArrayList<Driver> driversWithoutVehicle =
                driverWithNoVehicleAssigned.get(newVehicle.getVehicleType());
        if(!driversWithoutVehicle.isEmpty() ){
            Driver driver = driversWithoutVehicle.remove(0);
            addVehicleWithDriver(newVehicle, driver);
        }
        else {
            vehiclesWithNoDriverAssigned.get(newVehicle.getVehicleType()).add(newVehicle);
        }
    }
    void addDriverOnly(Driver newDriver){
        ArrayList<Vehicle> vehiclesWithoutDriver =
                vehiclesWithNoDriverAssigned.get(newDriver.getDrivableVehicleType());
        if( !vehiclesWithoutDriver.isEmpty()) {
            Vehicle vehicle = vehiclesWithoutDriver.remove(0);
            addVehicleWithDriver(vehicle, newDriver);
        }
        else{
            driverWithNoVehicleAssigned.get(newDriver.getDrivableVehicleType()).add(newDriver);
        }

    }

    private Driver getDriverFromId(String driverId){
        return availableDrivers.get(driverId);
    }

    String getDriverNameFromId(String driverId){
        return availableDrivers.get(driverId).getFullName();
    }

    HashMap<VehicleType, ArrayList<VehicleInfo>> getAvailableVehicleInfo(){

       return activeVehiclesInfo;
    }
    void arrangeRide(String driverId, String passengerName, Location passengerFromLocation,
                     Location passengerToLocation, int tripOtp, String bookingId ){
        Driver assignedDriver = getDriverFromId(driverId);
        assignedDriver.pickupCustomer(passengerFromLocation, passengerToLocation, tripOtp, bookingId);

    }
    private void setCabCentre(){
        allAvailableVehicles = new HashMap<>();
        vehiclesWithNoDriverAssigned = new HashMap<>();
        driverWithNoVehicleAssigned = new HashMap<>();
        availableDrivers = new HashMap<>();
        activeVehiclesInfo = new HashMap<>();
        allAvailableVehicles.put(VehicleType.CAR, new ArrayList<>());
        allAvailableVehicles.put(VehicleType.AUTO_RICKSHAW, new ArrayList<>());
        allAvailableVehicles.put(VehicleType.BIKE, new ArrayList<>());
        vehiclesWithNoDriverAssigned.put(VehicleType.CAR, new ArrayList<>());
        vehiclesWithNoDriverAssigned.put(VehicleType.AUTO_RICKSHAW, new ArrayList<>());
        vehiclesWithNoDriverAssigned.put(VehicleType.BIKE, new ArrayList<>());
        driverWithNoVehicleAssigned.put(VehicleType.CAR,new ArrayList<>());
        driverWithNoVehicleAssigned.put(VehicleType.AUTO_RICKSHAW, new ArrayList<>());
        driverWithNoVehicleAssigned.put(VehicleType.BIKE, new ArrayList<>());
        activeVehiclesInfo.put(VehicleType.CAR, new ArrayList<>());
        activeVehiclesInfo.put(VehicleType.AUTO_RICKSHAW, new ArrayList<>());
        activeVehiclesInfo.put(VehicleType.BIKE, new ArrayList<>());
    }
}
