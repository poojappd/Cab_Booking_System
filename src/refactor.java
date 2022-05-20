import java.time.LocalDateTime;
import java.util.ArrayList;

enum StationPoint {
    PALLAVARAM,
    TAMBARAM,
    CHROMEPET
}

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

enum VehicleType {
    CAR,
    AUTO_RICKSHAW,
    BIKE,
    NONE
}

enum CarType{
    PRIME,
    SEDAN,
    SUV

}

class CabSearchSystem{
    ArrayList<Vehicle> allNearbyVehicles;


}

class CabSystem{

}

class User{

    private String fullName;
    private int age;
    private String userName;
    private char[] password;

    User(String fullName, int age, String userName, char[] password){
        this.age = age;
        this.fullName = fullName;
        this.password = password;
        this.userName = userName;
    }

    public String getFullName(){
        return fullName;
    }
   
    public int getAge(){
        return age;
    }
    public String getUserName(){
        return userName;
    }

   
}

class Location{
    Location(int xCoordinate, int yCoordinate, StationPoint stationPoint){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.stationPoint = stationPoint;
    }
    private int xCoordinate;
    private int yCoordinate;
    private StationPoint stationPoint;

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public StationPoint getStationPoint() {
        return stationPoint;
    }
}
class Vehicle{
    private String vehicleId;
    private String vehicleName;
    private VehicleType vehicleType;
    private int mileage;
    private String ownerId;//set only once
    private String vehicleDriverId;
    private int fuelLevel;
    private String NumberPlate;
    private int maxOccupants;

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
        return NumberPlate;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    void setFuelLevel(){}

    public String getVehicleDriverId() {
        return vehicleDriverId;
    }
    public void setVehicleDriverId(String vehicleDriverId) {
        this.vehicleDriverId = vehicleDriverId;
    }
/*
    public String getVehicleId(){
    }
    public String getVehicleName();
    public String getOwnerId();
    public String getNumberPlate();
    public int getNumberOfWheels();
    public int getMileage();
    public int getFuelLevel();



    public String getVehicleDriverId() {
        return vehicleDriverId;
    }*/
}

class Car extends Vehicle{
    private CarType carType;
    private boolean airConditionerPresent;
    private boolean wifiPresent;
    private int numberOfWheels;//WHYYY???
    float addConvenienceFee();
    public CarType getCarType();
}
class Trip {
    private String PassengerName;
    private String driverName;
    private LocalDateTime cabBookedTime;
    private LocalDateTime cabReachedTime;
    private Location fromLocation;
    private Location toLocation;
    private CabBookingStatus cabBookingStatus;


    public String getPassengerName();
    public String getDriverName();
    public LocalDateTime getCabBookedTime();
    public LocalDateTime getCabReachedTime();
    public Location getFromLocation();
    public Location getToLocation();
    public CabBookingStatus getCabBookingStatus();
}
class FareCalculator{

}
class Bike extends Vehicle{
    private final int maxOccupants = 1;
    private final float timeDurationReductionRate = 0.15f;
    private final float BikeRate = 0.25f;

    public int getMaxOccupants() {
        return maxOccupants;
    }

    public float getTimeDurationReductionRate() {
        return timeDurationReductionRate;
    }

    public float getBikeRate() {
        return BikeRate;
    }
}
class AutoRickshaw extends Vehicle{

}



class RentalService{

}
class CabBookingSystemApp{
    User currentAppUser;

}