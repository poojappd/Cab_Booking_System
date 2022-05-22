package App;

import java.util.ArrayList;

public class Passenger extends User{
    private Location passengerHomeLocation;
    private Location currentLocation;//not necessary
    private ArrayList <Trip> bookingHistory;

    public Passenger(String fullName, int age, String userName, char[] password, Location passengerHomeLocation){
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

    //ArrayList<Trip> getBookingHistory() {return bookingHistory;    }

}