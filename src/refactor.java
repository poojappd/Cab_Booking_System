import jdk.javadoc.doclet.Taglet;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
enum StationPoint {
    PALLAVARAM,
    TAMBARAM,
    CHROMEPET,
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

    private String firstName;
    private String lastName;
    private int age;
    private String userId;
    private char[] password;


    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getAge(){
        return age;
    }
    public String getUserId(){
        return userId;
    }

    class Customer extends User{
        String userAddress;
        private StationPoint currentStationPoint;
        ArrayList <Fare> bookingHistory;

        public String getUserAddress(){
            return userAddress;
        }

        public StationPoint getCurrentStationPoint() {
            return currentStationPoint;
        }

        ArrayList<Fare> getBookingHistory() {
            return bookingHistory;
        }

    }
}

class Database{
    HashMap<String, User> allUsers;
    HashMap <String, char[]> userCredentials;

    private void getUser(String userName){}
    public void verifyUser(String userName, char[] password){}



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
    private int numberOfWheels;
    private String ownerId;//set only once
    private String vehicleDriverId;
    private int fuelLevel;
    private String plateNumber;
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

    public String getPlateNumber() {
        return plateNumber;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    int setFuelLevel(){}

    /*
    public String getVehicleId(){
    }
    public String getVehicleName();
    public String getOwnerId();
    public String getPlateNumber();
    public int getNumberOfWheels();
    public int getMileage();
    public int getFuelLevel();

    public void setVehicleDriverId(String vehicleDriverId) {
        this.vehicleDriverId = vehicleDriverId;
    }

    public String getVehicleDriverId() {
        return vehicleDriverId;
    }*/
}

class Car extends Vehicle{
    private CarType carType;
    private boolean airConditionerPresent;
    private boolean wifiPresent;

    float addConvenienceFee();
    public CarType getCarType();
}
class Fare{
    private String CustomerName;
    private String driverName;
    private LocalDateTime cabBookedTime;
    private LocalDateTime cabReachedTime;
    private Location fromLocation;
    private Location toLocation;
    private CabBookingStatus cabBookingStatus;


    public String getCustomerName();
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