import java.time.LocalDateTime;
import java.util.ArrayList;

enum StationPoint {
    THAILAVARAM, 
    GUDUVANCHERY, 
    VANDALUR, 
    TAMBARAM, 
    SANITORIUM, 
    CHROMEPET, 
    PALLAVARAM, 
    PAMMAL,
    PERUNGALATHUR, 
    URAPPAKKAM,
    TIRUSULAM, 
    MEENAMBAKKAM, 
    ALANDUR, 
    GUINDY,
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
    SUV,
    MINI

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
    Location(float xCoordinate, float yCoordinate, StationPoint stationPoint, String area){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.stationPoint = stationPoint;
        this.area = area;
    }
    private float xCoordinate;
    private float yCoordinate;
    private StationPoint stationPoint;
    private String area;

    public float getxCoordinate() {
        return xCoordinate;
    }

    public float getyCoordinate() {
        return yCoordinate;
    }

    public StationPoint getStationPoint() {
        return stationPoint;
    }
    public String getArea(){
        return area;
    }
}
class Vehicle{
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

    Vehicle(String vehicleName, VehicleType vehicleType, String numberPlate, int numberOfSeats, int maxOccupants){
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
    private int numberOfSeats;

    Car(String vehicleName, String numberPlate, int numberOfSeats, int maxOccupants,
        boolean airConditionerPresent, CarType carType){
        super(vehicleName, VehicleType.CAR, numberPlate, numberOfSeats, numberOfSeats);
        this.airConditionerPresent = airConditionerPresent;
        this.carType = carType;


    }

    void setWifi(){
        this.wifiPresent = true;
    }
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
    private final int numberOfSeats = 1;
    private final float timeDurationReductionRate = 0.15f;
    private final float BikeRate = 0.25f;

    Bike(String vehicleName, String numberPlate){
        super(vehicleName, VehicleType.AUTO_RICKSHAW, numberPlate, 1, 1);
    }
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
    private final int maxOccupants = 3;
    private final int numberOfSeats = 3;
    private int waitingCharges;
    private float autoRickshawPriceRate = 0.12f;
    AutoRickshaw(String vehicleName, String numberPlate){
        super(vehicleName, VehicleType.AUTO_RICKSHAW, numberPlate, 3, 3);
    }

    void putWaitingCharges(int minutes){

    }

    public float getAutoRickshawPriceRate() {
        return autoRickshawPriceRate;
    }
}



class RentalService{

}
class CabBookingSystemApp{
    User currentAppUser;

}