package App;

public class User{

    private String fullName;
    private int age;
    private String userName;
    private char[] password;

    User(String fullName, int age, String userName, char[] password){
        this.age = age;
        this.fullName = fullName;
        this.password = password;
        this.userName = userName;
    }

    public String getFullName(){
        return fullName;
    }

    public int getAge(){
        return age;
    }
    public String getUserName(){
        return userName;
    }


}