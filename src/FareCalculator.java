

class FareCalculator{
    private static final double miniRatePerKm = 16.15;
    private static final double sedanRatePerKm = 18.33;
    private static final double suvRatePerKm = 20.76;
    private static final double autoRatePerKm =  12.6;
    private static final double bikeRatePerKm = 3.4;

    private static final double miniBaseFare = 57;
    private static final double sedanBaseFare = 62.58;
    private static final double suvBaseFare = 65.7;
    private static final double autoBaseFare = 26.25;
    private static final double bikeBaseFare = 17;

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


    static double calculateFare(VehicleType vehicleType, String model, double km){
        double calculatedFare = 0.0;

        if(vehicleType == VehicleType.BIKE){
            calculatedFare = calculateBikeFare(km);
        }
        else if(vehicleType == VehicleType.AUTO_RICKSHAW){
            calculatedFare = calculateAutoFare(km);
        }
        else {
            switch (model){
                case "SEDAN" -> { calculatedFare = calculateSEDANFare(km);}
                case "SUV" -> { calculatedFare = calculateSUVFare(km);}
                case "MINI" -> { calculatedFare = calculateMiniFare(km);}

            }

        }
    return calculatedFare;
    }
}
