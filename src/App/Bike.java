package App;

public class Bike extends Vehicle{
    private  static final int maxOccupants = 1;
    private static final int numberOfSeats = 1;
    private static final float bikeSpeedPerKmInMinutes = 2.6f;
    private static final double bikeRatePerKm = 3.4;
    private static final double bikeBaseFare = 17;

    public Bike(String vehicleName, String numberPlate){
        super(vehicleName, VehicleType.BIKE, numberPlate, maxOccupants);
    }

    static double getBikeRatePerKm() {
        return bikeRatePerKm;
    }

    static double getBikeBaseFare() {
        return bikeBaseFare;
    }

    static float getBikeSpeedPerKmInMinutes() {
        return bikeSpeedPerKmInMinutes;
    }
}