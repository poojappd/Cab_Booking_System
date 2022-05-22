package App;

import java.util.Scanner;

public class ValidatingTool {
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
            System.out.println("Sorry kid, you're not allowed to enter into this application");
        }

        return false;
    }

    public static String validateNumberPlate(String numberPlate){
        boolean isNumberPlateValid = false;
        while (!isNumberPlateValid) {
            if (!numberPlate.matches("^[A-Za-z]{2}[0-9]{4}\\z")) {
                System.out.println("Your Number plate is not valid! Please try again");
                numberPlate = input.nextLine();
            }
            else{
                isNumberPlateValid = true;
                System.out.println("Vehicle numberplate validation is successfull");
            }
        }
        return numberPlate;
    }

}

