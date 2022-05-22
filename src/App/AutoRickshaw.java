package App;

public class AutoRickshaw extends Vehicle{
    private final int maxOccupants = 3;
    private final int numberOfSeats = 3;
    private int waitingCharges;
    private float autoRickshawPriceRate = 0.12f;
    public AutoRickshaw(String vehicleName, String numberPlate){
        super(vehicleName, VehicleType.AUTO_RICKSHAW, numberPlate, 3, 3);
    }

    void putWaitingCharges(int minutes){

    }

    public float getAutoRickshawPriceRate() {
        return autoRickshawPriceRate;
    }
}
