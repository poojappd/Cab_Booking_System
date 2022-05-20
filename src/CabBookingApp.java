
import java.util.Scanner;

public class CabBookingApp {//change name, common to all users
    private static Scanner input;
    private static String userStringInput;
    private static boolean noAppReload = true;

    static void createUser(){

        System.out.println("Enter your age");
        int age = input.nextInt();
        input.nextLine();
        noAppReload = Validation.validateUserAge(age);
        if(noAppReload) {
            System.out.println("Enter your full name");
            String fullName = input.nextLine();
            System.out.println("Enter a new userName");
            String name = input.nextLine();
            System.out.println("Enter a password");
            String password = input.nextLine();
            char[] encryptedPassword = EncryptDecrypt.encrypt(Validation.validatePassword(password));
            //System.out.println(password);
            System.out.println("Choose your Home address area");
            int i =1;
            for(StationPoint stationPoint:StationPoint.values()){
                System.out.println(i++ +". "+stationPoint);
            }
            StationPoint homeAddress = StationPoint.NA;
            switch (getMenuChoiceInput(3)){
                case 1-> homeAddress = StationPoint.CHROMEPET;
                case 2-> homeAddress = StationPoint.PALLAVARAM;
                case 3-> homeAddress = StationPoint.TAMBARAM;
            };//3 for now, increase later
            Passenger newPassenger = new Passenger(fullName,age,name,encryptedPassword,homeAddress);
            UserApplicationScreen userScreen = new UserApplicationScreen(newPassenger);
            userScreen.
        }

    }
    static void createEmployee(){}
    static void chooseAccountForNewUser(){

        System.out.println("""
                Choose your Account type
                1. User
                2. Employee
                """);
        int chosenMenuOption = getMenuChoiceInput(2);
        switch (chosenMenuOption){
            case 1 -> createUser();
            case 2 -> createEmployee();
        }
    }

    static void chooseAccountForExistingUser(){
        System.out.println("""
                Choose your Account type
                1. User\s
                2. Admin\s
                3. Employee
                \s""");
        getMenuChoiceInput(3);
    }

    static int getMenuChoiceInput(int choiceLimit){
        int chosenMenuOption = 0;
        boolean noError = false;

        do{
            input = new Scanner(System.in);
            try {
                chosenMenuOption = input.nextInt();
                if(chosenMenuOption<0 || chosenMenuOption>choiceLimit)
                {throw new Exception();}
                noError = true;
            }
            catch (Exception ie) {
                System.out.println("Please enter a valid option");
            }

        }while (!noError);
        input.nextLine();
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
        while (chosenMenuOption != -1 && noAppReload == false) {
            noAppReload = true;
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
