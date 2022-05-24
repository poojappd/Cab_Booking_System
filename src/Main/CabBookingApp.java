package Main;

import App.*;

import java.util.ArrayList;

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
                        int maxOccupants = UserInputGetter.getInputFromRange(4,6);
                        System.out.println("Does the air conditioner work in your car?\n1.Yes\n2.No");
                        int option = UserInputGetter.getMenuChoiceInput(2);
                        boolean airConditionerPresent;
                        airConditionerPresent = option == 1;
                        CarType carType;
                        if(maxOccupants ==3){
                            carType = CarType.MINI;
                        }
                        else if(maxOccupants == 4){
                            carType = CarType.SEDAN;
                        }
                        else {
                            carType = CarType.SUV;
                        }
                        Car driverCar = new Car(vehicleName, plateNumber, maxOccupants, airConditionerPresent,carType);
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

    static void passengerServices(Passenger passenger){
        boolean logout = false;
        while (!logout) {
            System.out.println("How may we help you?");
            System.out.println("""
                    1. Book cab
                    2. Schedule a cab ride
                    3. Rent a cab
                    4. Share a cab with others (Discount on Fare!)
                    5. View BookingHistory History
                    6. Logout of account
                    """);
            int chosenMenuOption = UserInputGetter.getMenuChoiceInput(6);
            switch (chosenMenuOption) {
                case 1 -> BookCab(passenger);
                case 5 -> viewBookingHistory(passenger);
                case 6 -> logout = true;
            }
        }
    }
    static void RentCab(Passenger passenger){
        System.out.println("Enter the number of hours for rental service\nValue ranges from 1 to 10");
        int preferredDuration = UserInputGetter.getMenuChoiceInput(10);
        RentalServiceProvider newRentalServiceProvider = new RentalServiceProvider(preferredDuration);
        System.out.println("1. Total package for for Mini: "+ newRentalServiceProvider.getMiniRentalPackagePerHour());
        System.out.println("2. Total package for Sedan: "+ newRentalServiceProvider.getSedanRentalPackagePerHour());
        System.out.println("3. Total package for SUV: "+ newRentalServiceProvider.getSuvRentalPackagePerHour());
        System.out.println("Choose your desired vehicle for rental service\nEnter 4 to cancel");
        int packageNumber = UserInputGetter.getMenuChoiceInput(4);
        switch (packageNumber){
            case 1 -> CabCentralHub.rentCab(CarType.MINI, preferredDuration);
            case 2 -> CabCentralHub.rentCab(CarType.SEDAN, preferredDuration);
            case 3 -> CabCentralHub.rentCab(CarType.SUV, preferredDuration);
        }


    }
    static void BookCab(Passenger passenger) {
        System.out.println("""
                Select your pickup area
                 1. From your home
                 2. Choose from other locations""");
        int chosenMenuOption = UserInputGetter.getMenuChoiceInput(2);
        Location passengerCurrentLocation;
        Location passengerDestinationLocation;

        if (chosenMenuOption == 1){
            passengerCurrentLocation = passenger.getHomeLocation();
        }
        else{
            System.out.println("Which base area are you in right now?");
            Map.viewBaseLocations();
            StationPoint passengerCurrentStation = StationPoint.values()[UserInputGetter.getMenuChoiceInput(Map.getBaseLocationCount()) - 1];
            System.out.println();
            Map.viewLocationFromBaseLocation(passengerCurrentStation);
            chosenMenuOption = UserInputGetter.getMenuChoiceInput(Map.getAreaCount(passengerCurrentStation));
            passengerCurrentLocation = Map.getLocationFromOption(passengerCurrentStation, chosenMenuOption);
        }
        System.out.println("""
                Select your dropping point
                 1. To your home
                 2. Choose from other locations""");
        chosenMenuOption = UserInputGetter.getMenuChoiceInput(2);

        if(chosenMenuOption == 1){
            passengerDestinationLocation = passenger.getHomeLocation();
        }
        else {

            System.out.println("Select your destination area");
            Map.viewBaseLocations();
            StationPoint passengerDestinationStation = StationPoint.values()[UserInputGetter.getMenuChoiceInput(Map.getBaseLocationCount()) - 1];
            Map.viewLocationFromBaseLocation(passengerDestinationStation);
            chosenMenuOption = UserInputGetter.getMenuChoiceInput(Map.getAreaCount(passengerDestinationStation));
            passengerDestinationLocation = Map.getLocationFromOption(passengerDestinationStation, chosenMenuOption);
        }

        System.out.println("Searching cabs...");
        ArrayList<Object> resultList =
                CabCentralHub.searchAvailableVehiclesFromLocation(passengerCurrentLocation, passengerDestinationLocation);
        int cancelOption = resultList.size();
        System.out.println("Choose a vehicle to book your ride\n" +
                "Enter " + cancelOption + " to cancel");
        chosenMenuOption = UserInputGetter.getMenuChoiceInput(cancelOption);

        if (chosenMenuOption != cancelOption) {

                VehicleInfo bookedVehicleInfo = (VehicleInfo) resultList.get(chosenMenuOption);
                String driverId = bookedVehicleInfo.getDriverId();
                StationPoint cabCentreStationPoint = (StationPoint) resultList.get(0);
                int tripOtp = IdGenerator.generateOtp();
                System.out.println("Book " + bookedVehicleInfo.getVehicleType() + " - " +
                        bookedVehicleInfo.getModel() + " for Rs." + bookedVehicleInfo.getFare() + " ?\n" +
                        "1. Book ride\n" +
                        "2. Cancel");
                int chosenOption = UserInputGetter.getMenuChoiceInput(2);

                if (chosenOption == 1) {

                    System.out.println("BookingHistory Confirmed! \n" +
                            "Please note this otp for verification " + tripOtp);

                    BookingHistory newBookingHistory = CabCentralHub.arrangeTrip(passenger.getUserName(), passenger.getFullName(),
                            passengerCurrentLocation, passengerDestinationLocation, tripOtp,
                            driverId, cabCentreStationPoint, bookedVehicleInfo);
                    passenger.addToBookingHistory(newBookingHistory);
                }
        }

    }


    static void viewBookingHistory(Passenger passenger){
        ArrayList<BookingHistory> bookingHistory = passenger.getBookingHistory();
        System.out.println("---------------------         BookingHistory History         ---------------------\n");
        for(BookingHistory bookings:bookingHistory){
            System.out.println("Booking time:     "+bookings.getCabBookedTime());
            System.out.println("BookingHistory Id:"+bookings.getBookingId());
            System.out.println("From :            "+bookings.getFromLocation().getStationPoint()+" - "+ bookings.getFromLocation().getArea()
                    +"\nTo :            "+bookings.getToLocation().getStationPoint()+" - "+ bookings.getToLocation().getArea());
            System.out.println(bookings.getCabBookingStatus());
            System.out.println("Driver name :     "+ bookings.getDriverName());
            System.out.println("Vehicle details:  "+bookings.getVehicleInfo().getVehicleType()+" " +bookings.getVehicleInfo().getModel());
            System.out.println("\n Total Fare: -----> "+bookings.getVehicleInfo().getFare());
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

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

    static void login(){
        System.out.println("Enter your username");
        String userName = UserInputGetter.getStringInput();
        System.out.println("And your password...");
        char [] password = UserInputGetter.getStringInput().toCharArray();
        User user = Database.verifyUser(userName, password);
        if(user == null){
            System.out.println("\nInvalid username or password!\nPlease re-enter your account credentials");
            login();
        }
        else {
            System.out.println("\n\nWelcome "+user.getFullName()+" !");

            if(user instanceof Passenger) {
                passengerServices((Passenger)(user));
            }
            else if(user instanceof Driver){
                //employeeServices(user);
            }

        }
    }


    public static void viewWelcomeScreen(){
        System.out.println("""
                **********************************************************
                                  Cab BookingHistory System
                **********************************************************
                Choose the following option to continue
                
                1.  New User
                2.  Existing User

                Enter your option""");

    }

    public static void main(String[] args) {
        initialize();
        int chosenMenuOption = 0;
        while (chosenMenuOption != -1) {
            viewWelcomeScreen();
            chosenMenuOption = UserInputGetter.getMenuChoiceInput(2);

            if(chosenMenuOption == 1){
                chooseAccountForNewUser();
            }
            else if(chosenMenuOption == 2)
                login();
        }
    }

    static void initialize(){
        Admin admin = Admin.instantiateOnce("Admin@123");
        assert admin != null;
        admin.createMap();
        admin.initializeCabCentralHub();
    }
}
