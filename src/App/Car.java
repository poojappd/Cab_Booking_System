package App;

public class Car extends Vehicle{
    private final CarType carType;
    private boolean wifiPresent;
    private int numberOfSeats;

    public Car(String vehicleName, String numberPlate, int maxOccupants,
               boolean wifiPresent, CarType carType){
        super(vehicleName, VehicleType.CAR, numberPlate, maxOccupants);
        this.wifiPresent = wifiPresent;
        this.carType = carType;

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

}
