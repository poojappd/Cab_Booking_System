package App;

public class Driver extends User{
    private String driverId;
    private int rideLimitPerDay;
    private boolean reachedRideLimit;
    private int currentRideCount;
    private VehicleType driveableVehicleType;//why do we need this wen we cN ssign vehicle directlu
    private Vehicle associatedVehicle;
    StationPoint defaultStationPoint;
    StationPoint currentStationPoint;
    private boolean isActive;

    public Driver(String fullName, int age, String userName, char[] password,
           StationPoint defaultStationPoint, int rideLimitPerDay, String driverId){
        super(fullName, age, userName, password);
        this.rideLimitPerDay = rideLimitPerDay;
        this.defaultStationPoint = defaultStationPoint;
        this.driverId = driverId;

    }

    public void setDriveableVehicleType(VehicleType driveableVehicleType) {
        this.driveableVehicleType = driveableVehicleType;
    }

    public StationPoint getDefaultStationPoint() {
        return defaultStationPoint;
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

    public void pickupCustomer(Location fromLocation, Location toLocation, int tripOtp, String bookingId){
        try{
            System.out.println("\nDriver will be arriving at your location in");
            for (int i = 5; i >=1; i--) {
                System.out.println(i+" minutes...");
                Thread.sleep(2000);
            }
            System.out.println("Driver has arrived at your location, please enter the otp: ");
            int passengerOtp = UserInputGetter.getIntInput();
            boolean otpMatched = (tripOtp == passengerOtp);
            String otpMatchedMessage = "Otp verified! Enjoy your ride";
            String otpNotMatchedMessage = "Sorry, your otp didn't match!";
            if(!otpMatched){
                int tries = 3;
                for (int i = 3; i >= 1; i--) {
                    String tryWord = (i==1?" try":" tries");
                    System.out.println("Invalid otp!!!\n" +
                            "Re-enter your otp - "+i+tryWord+"  left");
                    passengerOtp = UserInputGetter.getIntInput();
                    if(passengerOtp == tripOtp){
                        otpMatched = true;
                        break;
                    }
                }
            }
            if(otpMatched){
                System.out.println(otpMatchedMessage);
                CabCentralHub.updateDriverStatus(this, ActiveStatus.ENGAGED);
                CabCentralHub.setBookingStatus(this, bookingId, CabBookingStatus.SUCCESS);
            }
            else {
                System.out.println(otpNotMatchedMessage);
                CabCentralHub.setBookingStatus(this, bookingId, CabBookingStatus.CANCELLED);
                throw new InterruptedException();
            }

        }
        catch (InterruptedException ie){
            System.out.println("Ride cancelled !!");
            CabCentralHub.setBookingStatus(this, bookingId, CabBookingStatus.CANCELLED);
        }
        System.out.println("");
    }

    void setActiveStatus(CabCentralHub centralHub, boolean isActive){
        this.isActive = isActive;
    }
    boolean getActiveStatus(){
        return isActive;
    }
}