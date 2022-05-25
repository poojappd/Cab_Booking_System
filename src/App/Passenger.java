package App;

import java.util.ArrayList;

public class Passenger extends User{
    private Location passengerHomeLocation;
    private ArrayList <BookingHistory> bookingHistory;

    public Passenger(String fullName, int age, String userName, char[] password, Location passengerHomeLocation){
        super(fullName, age, userName, password);
        this.passengerHomeLocation = passengerHomeLocation;
        this.bookingHistory = new ArrayList<>();
    }

    public Location getHomeLocation() {
        return passengerHomeLocation;
    }

    public void addToBookingHistory(BookingHistory bookingHistory){
        this.bookingHistory.add(bookingHistory);
    }
    public ArrayList<BookingHistory> getBookingHistory() {
        return new ArrayList<>(bookingHistory);    }

}