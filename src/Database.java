import java.util.HashMap;

public class Database{
   private static HashMap<String, User> allUsers;
   private static HashMap <String, char[]> userCredentials;
   private static HashMap<String, Passenger> allPassengers;
   private static HashMap<String, Driver> allDrivers;//to show driver details for passengers
                        //driverId

    private void getUser(String userName){}
    public void verifyUser(String userName, char[] password){}
    
    private static void addUser(User user, char[] password ){
        allUsers.put(user.getUserName(), user);
        userCredentials.put(user.getUserName(), password);
    }

    public static void addUser(Passenger passenger, char[] password ){
        addUser(passenger, password);
        allPassengers.put(passenger.getUserName(), passenger);
    }

    public static void addUser(Driver driver, char[] password){
        addUser(driver, password);
        allDrivers.put(driver.getDriverId(), driver);

    }



}