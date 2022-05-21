import java.util.ArrayList;

public class Passenger extends User{
    Location passengerHomeLocation;
    private Location currentLocation;//not necessary
    ArrayList <Trip> bookingHistory;

    Passenger(String fullName, int age, String userName, char[] password, Location passengerHomeLocation){
        super(fullName, age, userName, password);
        this.passengerHomeLocation = passengerHomeLocation;
        this.bookingHistory = new ArrayList<>();
    }

    public Location getPassengerHomeLocation(){
        return passengerHomeLocation;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public ArrayList<Trip> getBookingHistory() {
        return bookingHistory;
    }

}