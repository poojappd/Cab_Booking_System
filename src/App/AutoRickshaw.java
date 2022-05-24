package App;

public class AutoRickshaw extends Vehicle{
    private static final double autoRatePerKm =  12.6;
    private static final double autoBaseFare = 26.25;
    private static final float waitingChargeRate = 0.73f;


    private int waitingCharges;
    private float autoRickshawPriceRate = 0.12f;
    public AutoRickshaw(String vehicleName, String numberPlate){
        super(vehicleName, VehicleType.AUTO_RICKSHAW, numberPlate, 3);
    }


    static float putWaitingCharges(int minutes){
        return (waitingChargeRate *(minutes * 3));
    }

    static double getAutoRickshawBaseFare() {
        return autoRatePerKm;
    }

    static double getAutoRatePerKm() {
        return autoRatePerKm;
    }
}
