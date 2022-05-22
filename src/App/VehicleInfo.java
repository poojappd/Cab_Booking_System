package App;

enum ActiveStatus{
    ACTIVE,
    ENGAGED
}
public class VehicleInfo {
    private String driverId;
    private String vehicleId;
    private VehicleType vehicleType;
    private String model;
    private int maxOccupants;
    ActiveStatus activeStatus;

    public VehicleInfo(String driverId, String vehicleId, VehicleType vehicleType, String model, int maxOccupants){
        this.driverId = driverId;
        this.vehicleType = vehicleType;
        this.vehicleId = vehicleId;
        this.activeStatus = ActiveStatus.ACTIVE;
        this.model = model;
        this.maxOccupants = maxOccupants;
    }
    public ActiveStatus getActiveStatus(){
        return activeStatus;
    }

    public void setActiveStatus(ActiveStatus activeStatus) {
        this.activeStatus = activeStatus;
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

    public int getMaxOccupants() {
        return maxOccupants;
    }

    public String getVehicleId() {
        return vehicleId;
    }
}
