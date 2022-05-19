import java.util.ArrayList;
import java.util.HashMap;

public class CabCentre {
    private StationPoint locatedStationPoint;
    private HashMap<VehicleType, Vehicle> availableVehicles;
    private HashMap<String, Driver> availableDrivers;
    private HashMap<VehicleType, ArrayList<Vehicle>> vehiclesWithNoDriverAssigned;
    private HashMap<VehicleType, ArrayList<Driver>> driverWithNoVehicleAssigned;


    CabCentre(StationPoint locatedStationPoint){
        this.locatedStationPoint = locatedStationPoint;
        setCabCentre();
    }

    void addVehicleWithDriver(Vehicle newVehicle, Driver newDriver){
        //pre assigned driver with vehicle shud only be passed
        newVehicle.setVehicleDriverId(newDriver.getDriverId());
        availableVehicles.put(newVehicle.getVehicleType(), newVehicle);
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

    void setCabCentre(){

        availableVehicles.put(VehicleType.CAR, new ArrayList<>());
        availableVehicles.put(VehicleType.AUTO_RICKSHAW, new ArrayList<>());
        availableVehicles.put(VehicleType.BIKE, new ArrayList<>());
        vehiclesWithNoDriverAssigned.put(VehicleType.CAR, new ArrayList<>());
        vehiclesWithNoDriverAssigned.put(VehicleType.AUTO_RICKSHAW, new ArrayList<>());
        vehiclesWithNoDriverAssigned.put(VehicleType.BIKE, new ArrayList<>());
        driverWithNoVehicleAssigned.put(VehicleType.CAR,new ArrayList<>());
        driverWithNoVehicleAssigned.put(VehicleType.AUTO_RICKSHAW, new ArrayList<>());
        driverWithNoVehicleAssigned.put(VehicleType.BIKE, new ArrayList<>());
    }
}
