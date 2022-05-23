package App;

import java.util.ArrayList;

public class Passenger extends User{
    private Location passengerHomeLocation;
    private ArrayList <Booking> bookingHistory;

    public Passenger(String fullName, int age, String userName, char[] password, Location passengerHomeLocation){
        super(fullName, age, userName, password);
        this.passengerHomeLocation = passengerHomeLocation;
        this.bookingHistory = new ArrayList<>();
    }

    public Location getPassengerHomeLocation(){
        return passengerHomeLocation;
    }

    public Location getHomeLocation() {
        return passengerHomeLocation;
    }

    public void addToBookingHistory(Booking booking){
        this.bookingHistory.add(booking);
    }
    public ArrayList<Booking> getBookingHistory() {
        return new ArrayList<>(bookingHistory);    }

}