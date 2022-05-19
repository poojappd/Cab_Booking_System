
import java.util.Scanner;

public class CabBookingApp {//change name, common to all users
    private static Scanner input;
    private static String userStringInput;

    static void createUser(){
        System.out.println("Enter a new userName");
        String name = input.nextLine();



    }
    static void createEmployee(){}
    static void chooseAccountForNewUser(){

        System.out.println("Choose your Account type\n" +
                "1. User \n" +
                "2. Employee\n ");
        int chosenMenuOption = getMenuChoiceInput(2);
        switch (chosenMenuOption){
            case 1 -> createUser();
            case 2 -> createEmployee();
        }
    }

    static void chooseAccountForExistingUser(){
        System.out.println("Choose your Account type\n" +
                "1. User \n" +
                "2. Admin \n" +
                "3. Employee\n ");
        getMenuChoiceInput(3);
    }

    static int getMenuChoiceInput(int choiceLimit){
        int chosenMenuOption = 0;
        boolean noError = false;

        do{
            input = new Scanner(System.in);
            try {
                chosenMenuOption = input.nextInt();
                noError = true;
            }
            catch (Exception ie) {
                System.out.println("Please enter a valid option");
            }
        }while (!noError || chosenMenuOption<0 || chosenMenuOption>choiceLimit );
        return chosenMenuOption;
    }


    public static void viewWelcomeScreen(){
        System.out.println("""
                **********************************************************
                                  Cab Booking System
                **********************************************************
                Choose the following option to continue
                
                1.  New User
                2.  Existing User

                Enter your option""");

    }

    public static void main(String[] args) {
        int chosenMenuOption = 0;
        while (chosenMenuOption != -1) {

            viewWelcomeScreen();
            chosenMenuOption = getMenuChoiceInput(2);

            if(chosenMenuOption == 1){
                chooseAccountForNewUser();
            }
            else if(chosenMenuOption == 2)
                chooseAccountForExistingUser();
        }
    }
}
