package App;

import java.util.Scanner;

public class ValidatingTool {
    static Scanner input = new Scanner(System.in);

    public static boolean validatePassword(String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");

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
            System.out.println("Sorry kid, you're not allowed to enter into this application");
        }

        return false;
    }

    public static boolean validateNumberPlate(String numberPlate) {
        return numberPlate.matches("^[A-Za-z]{2}[0-9]{4}\\z");
    }

}

