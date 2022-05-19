public class Driver extends User{
    private String driverId;
    private int fareLimitPerDay;
    private boolean reachedFareLimit;
    private int currentFareCount;
    private VehicleType driveableVehicle;
    private Vehicle associatedVehicle;
    StationPoint defaultStationPoint;
    StationPoint currentStationPoint;

    public String getDriverId() {
        return driverId;
    }
    //in constructor
    public void setFareLimitPerDay(int fareLimitPerDay) {
        this.fareLimitPerDay = fareLimitPerDay;
    }

    public int getFareLimitPerDay() {
        return fareLimitPerDay;
    }

    public void setReachedFareLimit(boolean reachedFareLimit) {
        this.reachedFareLimit = reachedFareLimit;
    }

    public boolean hasReachedFareLimit() {
        return reachedFareLimit;
    }

    public void setCurrentFareCount(int currentFareCount) {
        this.currentFareCount = currentFareCount;
    }

    public int getCurrentFareCount() {
        return currentFareCount;
    }

    public VehicleType getDrivableVehicleType(){
        return driveableVehicle;
    }
    public void viewAssociatedVehicle(){
        System.out.println("Vehicle Owner: "+ associatedVehicle.getAssociatedDriver()+
                "\n"+  associatedVehicle.getVehicleName()+"\n" +
                associatedVehicle.getPlateNumber()   );
    }

    public void pickupCustomer(Location fromLocation, Location toLocation){

    }

}