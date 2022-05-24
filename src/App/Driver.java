package App;

import java.time.Duration;
import java.time.LocalDateTime;

public class Driver extends User{
    private final String driverId;
    private final int rideLimitPerDay;
    private boolean reachedRideLimit;
    private int currentRideCount;
    private VehicleType driveableVehicleType;//why do we need this wen we cN ssign vehicle directlu
    private Vehicle associatedVehicle;
    private StationPoint defaultStationPoint;
    private StationPoint currentStationPoint;
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


    public int getRideLimitPerDay() {
        return rideLimitPerDay;
    }

    //public void setReachedFareLimit() this.reachedRideLimit = true;}

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

                if(associatedVehicle.getVehicleType() == VehicleType.AUTO_RICKSHAW){

                    System.out.println("Ask driver to pause vehicle nearby(waiting charges applied)\n 1.Yes\n 2.No");
                    int stopValue = UserInputGetter.getMenuChoiceInput(2);
                    if(stopValue == 1){

                        LocalDateTime waitingStartTime = LocalDateTime.now();
                        System.out.println("Waiting... Press 1 at any point to resume ride");
                        int resumeValue = UserInputGetter.getMenuChoiceInput(1);
                        LocalDateTime waitingEndTime = LocalDateTime.now();
                        Duration timeDuration = Duration.between(waitingStartTime, waitingEndTime);
                        float waitingCharges = AutoRickshaw.putWaitingCharges((int) timeDuration.getSeconds());
                        System.out.println("Waiting charges: Rs. "+waitingCharges);

                    }
                }
                else if(associatedVehicle.getVehicleType() == VehicleType.BIKE){
                    float speed = Bike.getBikeSpeedPerKmInMinutes();
                    System.out.println("Reached in "+Map.calculateDistance(fromLocation, toLocation) * speed +"minutes");
                }

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