package App;

public class Vehicle {
    private String vehicleId;
    private final String vehicleName;
    private final VehicleType vehicleType;
    private String vehicleDriverId;
    private int fuelLevel;
    private final String numberPlate;
    private final int maxOccupants;

    Vehicle(String vehicleName, VehicleType vehicleType, String numberPlate,  int maxOccupants) {
        this.vehicleName = vehicleName;
        this.vehicleType = vehicleType;
        this.numberPlate = numberPlate;
        this.maxOccupants = maxOccupants;

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


    public String getNumberPlate() {
        return numberPlate;
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

