package Main;

import App.*;

public class CabBookingApp {//change name, common to all users

    private static String createUserName(){
        boolean userNameExists = true;
        String username = "";
        while (userNameExists) {
            System.out.println("Enter a new userName");
            username = UserInputGetter.getStringInput();
            userNameExists = Database.checkUserNameExists(username);
            if(userNameExists){
                System.out.println("Username already exists! please enter a new username");
            }
        }
        return username;
    }
    static void createPassengerAccount(){

        System.out.println("Enter your age");
        int age = UserInputGetter.getIntInput();
        boolean isOldEnough;
        isOldEnough = ValidatingTool.validateUserAge(age);
        if(isOldEnough) {
            System.out.println("Enter your full name");
            String fullName = UserInputGetter.getStringInput();
            String username = createUserName();
            System.out.println("Enter a password");
            String password = UserInputGetter.getStringInput();
            char[] encryptedPassword = EncryptDecrypt.encrypt(ValidatingTool.validatePassword(password));
            //System.out.println(password);
            System.out.println("Choose your Home address base location");
            Map.viewBaseLocations();
            StationPoint homeStation = StationPoint.values()[UserInputGetter.getMenuChoiceInput(Map.getBaseLocationCount()) - 1];
            Map.viewLocationFromBaseLocation(homeStation);
            System.out.println("Now pick your locality");
            int choice = UserInputGetter.getMenuChoiceInput(Map.getAreaCount(homeStation));
            Location homeLocation = Map.getLocationFromOption(homeStation, choice);

            Passenger newPassenger = new Passenger(fullName,age,username,encryptedPassword, homeLocation);
            Database.addUser(newPassenger, encryptedPassword);
            System.out.println("Account created successfuly! \n Please login to use the application!");
        }


    }
    static void createEmployeeAccount() {

        System.out.println("Enter your age");
        int age = UserInputGetter.getIntInput();
        boolean isOldEnough;
        isOldEnough = ValidatingTool.validateUserAge(age);
        if (isOldEnough) {
            System.out.println("Enter your full name");
            String fullName = UserInputGetter.getStringInput();
            System.out.println("Enter a new userName");
            String username = createUserName();
            System.out.println("Enter a password");
            String password = UserInputGetter.getStringInput();
            char[] encryptedPassword = EncryptDecrypt.encrypt(ValidatingTool.validatePassword(password));
            System.out.println("In which of these areas would you like to work at?\n");
            int i = 1;
            for (StationPoint stationPoint : StationPoint.values()) {
                System.out.println(i++ + ". " + stationPoint);
            }

            System.out.println("Enter the option: ");
            StationPoint defaultStationPoint  = StationPoint.values()[UserInputGetter.getMenuChoiceInput(i-1)];
            System.out.println("How many rides can you take in a single day?");
            System.out.println("Enter a value between 5 to 30: ");
            int rideCountPerDay = UserInputGetter.getInputFromRange(5, 30);
            String driverId = IdGenerator.generateDriverId(defaultStationPoint);
            Driver newDriver = new Driver(fullName, age, username, encryptedPassword,
                    defaultStationPoint, rideCountPerDay, driverId);
            System.out.println("Do you have a vehicle for picking up customers?");
            System.out.println("1.Yes\n2.No\n");
            int hasVehicle = UserInputGetter.getMenuChoiceInput(2);
            System.out.println("""
                        Choose your suited vehicle type:\s
                        1. Car
                        2. Auto Rickshaw
                        3. Bike""");
            int vehicleTypeOption = UserInputGetter.getMenuChoiceInput(3);

            if(hasVehicle == 1){
                System.out.println("Enter the details of your Vehicle:\n Vehicle Name: ");
                String vehicleName = UserInputGetter.getStringInput();
                System.out.println("Enter your vehicle's plate number\n" +
                        "Note: Plate number should contain 2 letters followed by 4 numbers\n" +
                        "eg. TN3453");
                String plateNumber = ValidatingTool.validateNumberPlate(UserInputGetter.getStringInput());
                switch (vehicleTypeOption){
                    case 1 -> {
                        VehicleType driverVehicleType = VehicleType.CAR;
                        System.out.println("Enter the number of seats in your car\nNote: valid values are from 3 to 6" +
                                "excluding driver seat");
                        int numberOfSeats = UserInputGetter.getInputFromRange(4,6);
                        System.out.println("Does the air conditioner work in your car?\n1.Yes\n2.No");
                        int option = UserInputGetter.getMenuChoiceInput(2);
                        boolean airConditionerPresent;
                        airConditionerPresent = option == 1;
                        CarType carType;
                        if(numberOfSeats ==3){
                            carType = CarType.MINI;
                        }
                        else if(numberOfSeats == 4){
                            carType = CarType.SEDAN;
                        }
                        else {
                            carType = CarType.SUV;
                        }
                        Car driverCar = new Car(vehicleName, plateNumber, numberOfSeats, numberOfSeats, airConditionerPresent,carType);
                        driverCar.setVehicleDriverId(driverId);
                        newDriver.setAssociatedVehicle(driverCar);


                    }
                    case 2 -> {
                        VehicleType driverVehicleType = VehicleType.AUTO_RICKSHAW;
                        AutoRickshaw driveAutoRickshaw = new AutoRickshaw(vehicleName, plateNumber);
                        driveAutoRickshaw.setVehicleDriverId(driverId);
                    }
                    case 3 -> {
                        VehicleType driverVehicleType = VehicleType.BIKE;
                        Bike newBike = new Bike(vehicleName, plateNumber);
                        newDriver.setAssociatedVehicle(newBike);
                    }
                }
            }
            else{
                switch (vehicleTypeOption){

                }
            }
            Database.addUser(newDriver, encryptedPassword);

            System.out.println("Account created successfuly! \n Please login to use the application!");


        }
    }

    static void passengerLogin(){
        System.out.println("Enter your username");
        String userName = UserInputGetter.getStringInput();
        char [] password = UserInputGetter.getStringInput().toCharArray();
        User user = Database.verifyUser(userName, password);
        if(user == null){
            System.out.println("Incorrect password! Please re-enter your account credentials");
            passengerLogin();
        }
        else {
            System.out.println("Welcome "+userName+" !");
        }
    }
    static void chooseAccountForNewUser(){

        System.out.println("""
                Choose your Account type
                1. User
                2. Employee
                """);
        int chosenMenuOption = UserInputGetter.getMenuChoiceInput(2);
        switch (chosenMenuOption){
            case 1 -> createPassengerAccount();
            case 2 -> createEmployeeAccount();
        }
    }

    static void chooseAccountForExistingUser(){
        System.out.println("""
                Choose your Account type
                1. User\s
                2. Admin\s
                3. Employee
                \s""");
        int chosenMenuOption = UserInputGetter.getMenuChoiceInput(3);
        switch (chosenMenuOption){
            case 1 -> passengerLogin();
            //case 2 -> employeeLogin();
        }
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
        initializer();
        int chosenMenuOption = 0;
        while (chosenMenuOption != -1) {
            viewWelcomeScreen();
            chosenMenuOption = UserInputGetter.getMenuChoiceInput(2);

            if(chosenMenuOption == 1){
                chooseAccountForNewUser();
            }
            else if(chosenMenuOption == 2)
                chooseAccountForExistingUser();
        }
    }

    static void initializer(){
        Admin admin = Admin.instantiateOnce("Admin@123");
        admin.createMap();
        admin.initializeCabCentralHub();
    }
}
