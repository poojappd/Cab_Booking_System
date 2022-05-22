import java.util.ArrayList;
import java.util.HashMap;

class CabCentre {
    private StationPoint locatedStationPoint;
    private HashMap<VehicleType, ArrayList<Vehicle>> allAvailableVehicles;
    private HashMap<String, Driver> availableDrivers;
    private
    private HashMap<VehicleType, ArrayList<Vehicle>> vehiclesWithNoDriverAssigned;
    private HashMap<VehicleType, ArrayList<Driver>> driverWithNoVehicleAssigned;



    CabCentre(StationPoint locatedStationPoint){
        this.locatedStationPoint = locatedStationPoint;
        setCabCentre();
    }

    void addVehicleWithDriver(Vehicle newVehicle, Driver newDriver){
        //pre assigned driver with vehicle shud only be passed
        newVehicle.setVehicleDriverId(newDriver.getDriverId());
        allAvailableVehicles.get(newVehicle.getVehicleType()).add(newVehicle);
        availableDrivers.put(newDriver.getDriverId(), newDriver);

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

    void getAvailableVehicles(CabCentralHub centralHub){
        ArrayList<Vehicle> activeVehicles = new ArrayList<>();
        for(Driver driver:availableDrivers.values()){
            if(driver.getActiveStatus()){
                activeDrivers.add(driver);
            }
        }
    }
    void arrangeTrip(){

    }
    private void setCabCentre(){

        allAvailableVehicles.put(VehicleType.CAR, new ArrayList<>());
        allAvailableVehicles.put(VehicleType.AUTO_RICKSHAW, new ArrayList<>());
        allAvailableVehicles.put(VehicleType.BIKE, new ArrayList<>());
        vehiclesWithNoDriverAssigned.put(VehicleType.CAR, new ArrayList<>());
        vehiclesWithNoDriverAssigned.put(VehicleType.AUTO_RICKSHAW, new ArrayList<>());
        vehiclesWithNoDriverAssigned.put(VehicleType.BIKE, new ArrayList<>());
        driverWithNoVehicleAssigned.put(VehicleType.CAR,new ArrayList<>());
        driverWithNoVehicleAssigned.put(VehicleType.AUTO_RICKSHAW, new ArrayList<>());
        driverWithNoVehicleAssigned.put(VehicleType.BIKE, new ArrayList<>());
    }
}
