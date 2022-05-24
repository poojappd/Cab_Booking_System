package App;

public class Car extends Vehicle{
    private final CarType carType;
    private boolean airConditionerPresent;
    private boolean wifiPresent;
    private int numberOfSeats;

    public Car(String vehicleName, String numberPlate, int maxOccupants,
        boolean airConditionerPresent, CarType carType){
        super(vehicleName, VehicleType.CAR, numberPlate, maxOccupants);
        this.airConditionerPresent = airConditionerPresent;
        this.carType = carType;


    }

    void setWifi(boolean wifiPresent){
        this.wifiPresent = wifiPresent;
    }
    float addConvenienceFee(){
        return 0;
    }

    public boolean isWifiPresent() {
        return wifiPresent;
    }

    public CarType getCarType(){
        return carType;
    }

    public void setAirConditioner(boolean airConditionerPresent) {
        this.airConditionerPresent = airConditionerPresent;
    }
}
