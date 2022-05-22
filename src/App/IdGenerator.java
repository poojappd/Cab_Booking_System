package App;

import java.util.HashSet;
import java.util.Set;

public class IdGenerator {
    private static final Set<String> driverIds = new HashSet<>();
    private static final String driverAppendString ="drvr";
    private static int driverCode = 1;

    public static String generateDriverId(StationPoint stationPoint){
        String newDriverId = driverAppendString + stationPoint.toString().substring(0,4) + driverCode;
        driverCode++;
        return newDriverId;
    }
}

