package App;

import java.time.LocalDateTime;
import java.util.ArrayList;

enum CabBookingStatus{
    SUCCESS,
    CANCELLED
}

enum CabServiceType{
    RENTAL,
    CARPOOL,
    CAB_BOOKING,
    SCHEDULE_BOOKING

}



class CabSearchSystem{
    ArrayList<Vehicle> allNearbyVehicles;


}

class CabSystem{

}


class Vehicle {
    private String vehicleId;
    private String vehicleName;
    private VehicleType vehicleType;
    private int mileage;
    private String ownerId;
    private String vehicleDriverId;
    private int fuelLevel;
    private int numberOfSeats;
    private String numberPlate;
    private int maxOccupants;

    Vehicle(String vehicleName, VehicleType vehicleType, String numberPlate, int numberOfSeats, int maxOccupants) {
        this.vehicleName = vehicleName;
        this.vehicleType = vehicleType;
        this.numberPlate = numberPlate;
        this.maxOccupants = maxOccupants;
        this.numberOfSeats = numberOfSeats;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getMileage() {
        return mileage;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    void setFuelLevel() {
    }

    public String getVehicleDriverId() {
        return vehicleDriverId;
    }

    public void setVehicleDriverId(String vehicleDriverId) {
        this.vehicleDriverId = vehicleDriverId;
    }
    public int getMaxOccupants(){
        return maxOccupants;
    }

}

class Trip {
    private String PassengerName;
    private String driverName;
    private LocalDateTime cabBookedTime;
    private LocalDateTime cabReachedTime;
    private Location fromLocation;
    private Location toLocation;
    private CabBookingStatus cabBookingStatus;


    /*public String getPassengerName(){}
    public String getDriverName();
    public LocalDateTime getCabBookedTime();
    public LocalDateTime getCabReachedTime();
    public Location getFromLocation();
    public Location getToLocation();
    public CabBookingStatus getCabBookingStatus(); */
}






class RentalService{

}
class CabBookingSystemApp{
    User currentAppUser;

}