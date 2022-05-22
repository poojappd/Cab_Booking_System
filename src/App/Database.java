package App;

import java.util.HashMap;

public class Database{
   private static HashMap<String, User> allUsers = new HashMap<>();
   private static HashMap <String, char[]> userCredentials = new HashMap<>();
   private static HashMap<String, Passenger> allPassengers = new HashMap<>();
   private static HashMap<String, Driver> allDrivers = new HashMap<>();//to show driver details for passengers
                        //driverId

    private void getUser(String userName){}
    public static User verifyUser(String userName, char[] password){
        if(userCredentials.get(userName) == null){
            System.out.println("No such users");
        }
        else {
            if(userCredentials.get(userName).equals(password)){
                return allUsers.get(userName);
            }
            else {
                System.out.println("Incorrect password");
            }
        }

        return null;
    }
    
    private static void addUser(char[] password, User user ){
        allUsers.put(user.getUserName(), user);
        userCredentials.put(user.getUserName(), password);
    }

    public static void addUser(Passenger passenger, char[] password ){
        addUser(password, passenger);
        allPassengers.put(passenger.getUserName(), passenger);
    }

    public static void addUser(Driver driver, char[] password){
        addUser(password, driver);
        allDrivers.put(driver.getDriverId(), driver);

    }
    public static boolean checkUserNameExists(String userName){

        return (userCredentials.keySet().contains(userName));
    }



}