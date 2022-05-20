import java.util.Scanner;

public class Validation {
    static Scanner input = new Scanner(System.in);
    public static String validatePassword(String password) {
        boolean passwordIsNotValid = true;
        while (passwordIsNotValid) {
            if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
                System.out.println("Please enter a valid password!");
                password = input.nextLine();
            }
            else{
                passwordIsNotValid = false;
                System.out.println("Great! Your password is set.");

            }
        }
        return password;

    }

    public static boolean validateUserAge(int age){
        if(age>=18){
            if(age<=200){
                return true;
            }
            else {
                System.out.println("Looks like you're too old!");
            }
        }
        else{
            System.out.println("Sorry kid, you're not allowed to use this application");
        }

        return false;
    }

}

