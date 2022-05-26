package App;

public class UserInfo {

    private String fullName;
    private int age;
    private String username;
    private char[] encryptedPassword;



    public UserInfo(String fullName, int age, String username, char[] encryptedPassword){

        this.age = age;
        this.encryptedPassword = encryptedPassword;
        this.fullName = fullName;
        this.username = username;

    }

    public char[] getEncryptedPassword() {
        return encryptedPassword;
    }

    public int getAge() {
        return age;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

}
