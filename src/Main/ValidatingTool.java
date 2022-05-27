package Main;

import java.util.Scanner;

public class ValidatingTool {
    static Scanner input = new Scanner(System.in);

    public static boolean validatePassword(String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");

    }

    public static boolean validateUserAge(int age){
        return (age >= 18 && age <= 200);
    }

    public static boolean validateNumberPlate(String numberPlate) {
        return numberPlate.matches("^[A-Za-z]{2}[0-9]{4}\\z");
    }

}

