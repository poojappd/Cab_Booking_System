package App;

import java.util.UUID;

public class IdGenerator {
    private static final String driverAppendString ="Cabby_drvr";
    private static long driverCode = 1;


    public static String generateDriverId(StationPoint stationPoint){
        String newDriverId = driverAppendString + stationPoint.toString().substring(0,4) + driverCode;
        driverCode++;
        return newDriverId;
    }

    public static int generateOtp(){
        int otp = -1;
        while (otp <= 999 || otp > 9999) {
            otp = (int) (Math.random() * 10000);
        }

        return otp;
    }

    static String generateBookingId(Booking booking){
        return UUID.randomUUID().toString();
    }
}

