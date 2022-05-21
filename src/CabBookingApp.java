public class CabBookingApp {//change name, common to all users

    static void createUser(){

        System.out.println("Enter your age");
        int age = UserInputGetter.getIntInput();
        boolean isOldEnough;
        isOldEnough = ValidatingTool.validateUserAge(age);
        if(isOldEnough) {
            System.out.println("Enter your full name");
            String fullName = UserInputGetter.getStringInput();
            System.out.println("Enter a new userName");
            String username = UserInputGetter.getStringInput();
            System.out.println("Enter a password");
            String password = UserInputGetter.getStringInput();
            char[] encryptedPassword = EncryptDecrypt.encrypt(ValidatingTool.validatePassword(password));
            //System.out.println(password);
            System.out.println("Choose your Home address area");
            int i =1;
            for(StationPoint stationPoint:StationPoint.values()){
                System.out.println(i++ +". "+stationPoint);
            }
            Location homeAddress = StationPoint.values()[UserInputGetter.getMenuChoiceInput(i-1)];
            
           

            Passenger newPassenger = new Passenger(fullName,age,username,encryptedPassword,homeAddress);
            Database.addUser(newPassenger, encryptedPassword);

            System.out.println("Account created successfuly! \n Please login to use the application!");
        }


    }
    static void createEmployee() {

        System.out.println("Enter your age");
        int age = UserInputGetter.getIntInput();
        boolean isOldEnough;
        isOldEnough = ValidatingTool.validateUserAge(age);
        if (isOldEnough) {
            System.out.println("Enter your full name");
            String fullName = UserInputGetter.getStringInput();
            System.out.println("Enter a new userName");
            String username = UserInputGetter.getStringInput();
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
            Driver newDriver = new Driver(fullName, age, username, encryptedPassword,
                    defaultStationPoint, rideCountPerDay);
            System.out.println("Do you have a vehicle for picking up customers?");
            System.out.println("1.Yes\n2.No\n");
            int hasVehicle = UserInputGetter.getMenuChoiceInput(2);
            System.out.println("""
                        Choose your suited vehicle type:\s
                        1. Car
                        2. Auto Rickshaw
                        3. Bike""");
            int chosenMenuOption = UserInputGetter.getMenuChoiceInput(3);

            if(hasVehicle == 1){
                System.out.println("Enter the details of your Vehicle:\n Vehicle Name: ");
                String vehicleName = UserInputGetter.getStringInput();
                System.out.println("Enter your vehicle's plate number\n" +
                        "Note: Plate number should contain 2 letters followed by 4 numbers\n" +
                        "eg. TN3453");
                String plateNumber = ValidatingTool.validateNumberPlate(UserInputGetter.getStringInput());
                switch (chosenMenuOption){
                    case 1 -> {
                        VehicleType driverVehicleType = VehicleType.CAR;
                        Car driverCar;
                    }
                    case 2 -> {
                        VehicleType driverVehicleType = VehicleType.AUTO_RICKSHAW;
                        AutoRickshaw driveAutoRickshaw;
                    }
                    case 3 -> {
                        VehicleType driverVehicleType = VehicleType.BIKE;
                        Bike driverBike;
                    }
                }
            }
            else{
                switch (chosenMenuOption){

                }
            }
            Database.addUser(newDriver, encryptedPassword);

            System.out.println("Account created successfuly! \n Please login to use the application!");


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
        int chosenMenuOption = UserInputGetter.getMenuChoiceInput(3);
        switch (chosenMenuOption){
            case 1 -> userLogin();
            case 2 -> employeeLogin();
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

    static initializer(){

    }
}
