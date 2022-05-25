package App;

enum AvailabilityStatus {
    AVAILABLE,
    ENGAGED
}
public class VehicleInfo {
    private String driverId;
    private String driverName;
    private String vehicleId;
    private VehicleType vehicleType;
    private String model;
    private CarType carType;
    private int maxOccupants;
    private double fare;
    private AvailabilityStatus availabilityStatus;

    VehicleInfo(String driverId, String vehicleId, VehicleType vehicleType, String model, int maxOccupants, String driverName, CarType carType){
        this.driverId = driverId;
        this.vehicleType = vehicleType;
        this.vehicleId = vehicleId;
        this.availabilityStatus = AvailabilityStatus.AVAILABLE;
        this.model = model;
        this.maxOccupants = maxOccupants;
        this.driverName = driverName;
        this.carType = carType;
    }
    AvailabilityStatus getActiveStatus(){
        return availabilityStatus;
    }

    void setActiveStatus(AvailabilityStatus availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
    public String getModel(){
        return model;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getDriverId() {
        return driverId;
    }

    int getMaxOccupants() {
        return maxOccupants;
    }

    String getVehicleId() {
        return vehicleId;
    }
    void setFare(double fare){
        this.fare = fare;
    }

    public double getFare() {
        return fare;
    }

    public String getDriverName() {
        return driverName;
    }

    CarType getCarType() {
        return carType;
    }
}
