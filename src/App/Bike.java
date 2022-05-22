package App;

public class Bike extends Vehicle{
    private final int maxOccupants = 1;
    private final int numberOfSeats = 1;
    private final float timeDurationReductionRate = 0.15f;
    private final float BikeRate = 0.25f;

    public Bike(String vehicleName, String numberPlate){
        super(vehicleName, VehicleType.BIKE, numberPlate, 1, 1);
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