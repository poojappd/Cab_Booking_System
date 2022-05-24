package App;

public class AutoRickshaw extends Vehicle{
    private static final double autoRatePerKm =  12.6;
    private static final double autoBaseFare = 26.25;

    private int waitingCharges;
    private float autoRickshawPriceRate = 0.12f;
    public AutoRickshaw(String vehicleName, String numberPlate){
        super(vehicleName, VehicleType.AUTO_RICKSHAW, numberPlate, 3, 3);
    }

    public static double getAutoRatePerKm() {
        return autoRatePerKm;
    }

    public static double getAutoBaseFare() {
        return autoBaseFare;
    }

    void putWaitingCharges(int minutes){

    }

    public float getAutoRickshawPriceRate() {
        return autoRickshawPriceRate;
    }
}
