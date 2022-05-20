import java.util.HashMap;

public class Database{
   private HashMap<String, User> allUsers;
   private HashMap <String, char[]> userCredentials;

    private void getUser(String userName){}
    public void verifyUser(String userName, char[] password){}
    
    public void addUser(User user, char[] password ){
        allUsers.put(user.getUserName(), user);
        
        userCredentials.put(user.getUserName(), password);


    }



}