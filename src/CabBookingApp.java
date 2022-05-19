
import java.util.Scanner;

public class CabBookingApp {
    static Scanner input;
    static int chosenMenuOption;

    static void getMenuChoiceInput(){

        while (true){
            input = new Scanner(System.in);
            try {
                chosenMenuOption = input.nextInt();
            }
            catch (Exception ie) {
                System.out.println("Please enter a valid option");
            }
        }
    }

    public static void viewWelcomeScreen(){
        System.out.println("""
                **********************************************************
                                  Cab Booking System
                **********************************************************
                Please Login / Signup to continue
                
                -1. Exit
                1.  Login
                2.  Signup

                Enter your option""");

    }
    public static void main(String[] args) {
        while (chosenMenuOption != -1) {

            viewWelcomeScreen();
            getMenuChoiceInput();
            if(chosenMenuOption == 1){
                System.out.println("1. Admin \n 2. User");
            }

        }
    }
}
