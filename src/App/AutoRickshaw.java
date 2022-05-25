package App;

public class AutoRickshaw extends Vehicle{
    private static final double autoRatePerKm =  12.6;
    private static final double autoBaseFare = 26.25;
    private static final float waitingChargeRate = 0.73f;


    public AutoRickshaw(String vehicleName, String numberPlate){
        super(vehicleName, VehicleType.AUTO_RICKSHAW, numberPlate, 3);
    }


    static float addWaitingCharges(int minutes){
        return (waitingChargeRate *(minutes * 3));
    }

    static double getAutoRickshawBaseFare() {
        return autoBaseFare;
    }

    static double getAutoRatePerKm() {
        return autoRatePerKm;
    }
}
