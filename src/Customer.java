import java.util.ArrayList;

public class Customer extends User{
    String userAddress;
    private StationPoint currentStationPoint;
    ArrayList <Fare> bookingHistory;

    Customer(String fullName, int age, String userName, char[] password, String userAddress){
        super(fullName, age, userName, password);
        this.userAddress = userAddress;
        this.bookingHistory = new ArrayList<>();
    }

    public String getUserAddress(){
        return userAddress;
    }

    public StationPoint getCurrentStationPoint() {
        return currentStationPoint;
    }

    public ArrayList<Fare> getBookingHistory() {
        return bookingHistory;
    }

}