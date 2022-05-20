public class Driver extends User{
    private String driverId;
    private int rideLimitPerDay;
    private boolean reachedRideLimit;
    private int currentRideCount;
    private VehicleType driveableVehicleType;//why do we need this wen we cN ssign vehicle directlu
    private Vehicle associatedVehicle;
    StationPoint defaultStationPoint;
    StationPoint currentStationPoint;

    Driver(String fullName, int age, String userName, char[] password,
           StationPoint defaultStationPoint, int rideLimitPerDay){
        super(fullName, age, userName, password);
        this.rideLimitPerDay = rideLimitPerDay;
        this.defaultStationPoint = defaultStationPoint;

    }

    public void setDriveableVehicleType(VehicleType driveableVehicleType) {
        this.driveableVehicleType = driveableVehicleType;
    }

    public void setAssociatedVehicle(Vehicle associatedVehicle) {
        this.associatedVehicle = associatedVehicle;
    }

    public String getDriverId() {
        return driverId;
    }
    //in constructor

    public int getRideLimitPerDay() {
        return rideLimitPerDay;
    }

    //public void setReachedFareLimit(boolean reachedRideLimit) this.reachedRideLimit = reachedRideLimit;}

    public boolean hasReachedFareLimit() {
        return reachedRideLimit;
    }

    public void raiseRideCount() {//check return type for bool
        if(currentRideCount < rideLimitPerDay){
            currentRideCount++;
        }
        else{
            reachedRideLimit = true;
        }
    }

    public int getCurrentFareCount() {
        return currentRideCount;
    }

    public VehicleType getDrivableVehicleType(){
        return driveableVehicleType;
    }
    public void viewAssociatedVehicle(){
        System.out.println("Vehicle Owner: "+ getFullName()+
                "\n"+  associatedVehicle.getVehicleName()+"\n" +
                associatedVehicle.getNumberPlate()   );
    }

    public void pickupCustomer(Location fromLocation, Location toLocation){

    }

}