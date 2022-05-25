package App;

class FareCalculator{
    private static final double miniRatePerKm = 16.15;
    private static final double sedanRatePerKm = 18.33;
    private static final double suvRatePerKm = 20.76;
    private static final double autoRatePerKm =  AutoRickshaw.getAutoRickshawBaseFare();
    private static final double bikeRatePerKm = Bike.getBikeRatePerKm();

    private static final double miniBaseFare = 57;
    private static final double sedanBaseFare = 62.58;
    private static final double suvBaseFare = 65.7;
    private static final double autoBaseFare = AutoRickshaw.getAutoRatePerKm();
    private static final double bikeBaseFare = Bike.getBikeBaseFare();

    private static double calculateAutoFare(double km){
        return (autoBaseFare) + (autoRatePerKm * km);
    }

    private static double calculateMiniFare(double km){
        return (miniBaseFare) + (miniRatePerKm * km);
    }

    private static double calculateBikeFare(double km){
        return (bikeBaseFare) + (bikeRatePerKm * km);
    }

    private static double calculateSUVFare(double km){
        return (suvBaseFare) + (suvRatePerKm * km);
    }

    private static double calculateSEDANFare(double km){
        return (sedanBaseFare) + (sedanRatePerKm * km);
    }


    static double calculateFare(VehicleType vehicleType, double km, CarType carType){
        double calculatedFare = 0.0;

        switch (vehicleType) {
             case BIKE ->  calculatedFare = calculateBikeFare(km);
             case AUTO_RICKSHAW -> calculatedFare = calculateAutoFare(km);
             case CAR-> {
                switch (carType) {
                    case SEDAN -> {
                        calculatedFare = calculateSEDANFare(km);
                    }
                    case SUV -> {
                        calculatedFare = calculateSUVFare(km);
                    }
                    case MINI -> {
                        calculatedFare = calculateMiniFare(km);
                    }

                }

            }
        }

    return calculatedFare;
    }
}
