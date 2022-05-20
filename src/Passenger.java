import java.util.ArrayList;

public class Passenger extends User{
    StationPoint passengerAddress;
    private StationPoint currentStationPoint;
    ArrayList <Trip> bookingHistory;

    Passenger(String fullName, int age, String userName, char[] password, StationPoint passengerAddress){
        super(fullName, age, userName, password);
        this.passengerAddress = passengerAddress;
        this.bookingHistory = new ArrayList<>();
    }

    public StationPoint getPassengerAddress(){
        return passengerAddress;
    }

    public StationPoint getCurrentStationPoint() {
        return currentStationPoint;
    }

    public ArrayList<Trip> getBookingHistory() {
        return bookingHistory;
    }

}