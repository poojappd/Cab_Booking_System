package App;

import java.util.Arrays;
import java.util.HashMap;

public class Database{
   private static HashMap<String, User> allUsers = new HashMap<>();
   private static HashMap <String, char[]> userCredentials = new HashMap<>();
                   //driverId


    public static User verifyUser(String userName, char[] password){
        System.out.println(userName);
        System.out.println(password);
        char [] actualUserEncryptedPassword;
        char[] actualUserPassword;

        if(allUsers.containsKey(userName)) {
            actualUserEncryptedPassword = userCredentials.get(userName);
            actualUserPassword = CipherSystem.decrypt(actualUserEncryptedPassword);
            if (Arrays.equals(actualUserPassword, password)) {
                    return allUsers.get(userName);
                }
            }


        return null;
    }

    public static void addUser(User user, char[] password){
        allUsers.put(user.getUserName(), user);
        userCredentials.put(user.getUserName(), password);
    }



    public static boolean checkUserNameExists(String userName){

        return (userCredentials.keySet().contains(userName));
    }



}