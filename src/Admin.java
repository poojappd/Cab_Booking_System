import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Admin {
    private static String adminPassword = "Admin@123";
    private static Admin onlyAdmin;
    private Admin(){}

    public static Admin instantiateOnce(String checkAdminPassword){
        if(checkAdminPassword.equals(checkAdminPassword)){
            if (onlyAdmin == null){
                onlyAdmin = new Admin();
            }
            return onlyAdmin;
        }
        return null;

    }
    void createMap(){
        String linesInCSV;
        String splitBy = ",";
        try {

            BufferedReader br = new BufferedReader(new FileReader("resources/MapData.csv"));
            while ((linesInCSV = br.readLine()) != null)
            {
                String[] CsvValues = linesInCSV.split(splitBy);
                //use comma as separator
                StationPoint stationPoint = StationPoint.valueOf(CsvValues[0].replaceAll("\\s", ""));
                String area = CsvValues[1];
                float xCoordinate = Float.parseFloat(CsvValues[2]);
                float yCoordinate = Float.parseFloat(CsvValues[3]);
                Location location = new Location(xCoordinate, yCoordinate, stationPoint, area);
                Map.addToMap(location);


            }

        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    void initializeCabCentralHub(){
        CabCentre cabCentre1 = new CabCentre(StationPoint.ALANDUR);
        Driver newDriver1 = new Driver("Perumal", 35, "peru","peru@35Cabs".toCharArray(), StationPoint.ALANDUR, 5, IdGenerator.generateDriverId(StationPoint.ALANDUR));
        Car vehicle1 = new Car("Maruti Swift", "tn4567", 4, 4, true,CarType.SEDAN);
        newDriver1.setDriveableVehicleType(VehicleType.CAR);
        newDriver1.setAssociatedVehicle(vehicle1);
        Driver newDriver2 = new Driver("Muthu", 30, "Muthu133","Muthu@30Cabs".toCharArray(), StationPoint.ALANDUR, 5, IdGenerator.generateDriverId(StationPoint.ALANDUR));
        AutoRickshaw vehicle2 = new AutoRickshaw("Bajaj-RE", "tn3444");
        newDriver2.setDriveableVehicleType(VehicleType.AUTO_RICKSHAW);
        newDriver2.setAssociatedVehicle(vehicle2);
        Driver newDriver3 = new Driver("Daniel", 28, "Dannyguy","theDanny@28Cabs".toCharArray(), StationPoint.ALANDUR, 9, IdGenerator.generateDriverId(StationPoint.ALANDUR));
        Bike vehicle3 = new Bike("Honda Splendor", "ap7623");
        newDriver3.setDriveableVehicleType(VehicleType.BIKE);
        newDriver3.setAssociatedVehicle(vehicle3);
        CabCentralHub.addCabCentre(this, cabCentre1, StationPoint.ALANDUR);

        CabCentre cabCentre2 = new CabCentre(StationPoint.TAMBARAM);
        Driver newDriver11 = new Driver("Kumar", 35, "kumar@35Cabs","Kumar#123".toCharArray(), StationPoint.TAMBARAM, 10, IdGenerator.generateDriverId(StationPoint.TAMBARAM));
        Car vehicle11 = new Car("Maruti Swift", "tn8765", 4, 4, true,CarType.SEDAN);
        newDriver11.setDriveableVehicleType(VehicleType.CAR);
        newDriver11.setAssociatedVehicle(vehicle11);
        Driver newDriver21 = new Driver("Sam Anderson", 40, "SamAndy@40Cabbz","Sammy#$56".toCharArray(), StationPoint.TAMBARAM, 7, IdGenerator.generateDriverId(StationPoint.TAMBARAM));
        AutoRickshaw vehicle21 = new AutoRickshaw("Bajaj-RE", "tn3445");
        newDriver21.setDriveableVehicleType(VehicleType.AUTO_RICKSHAW);
        newDriver21.setAssociatedVehicle(vehicle21);
        Driver newDriver31 = new Driver("Rocky Bhai", 26, "SalamRockyBhai","TheWorld->Rocky123".toCharArray(), StationPoint.ALANDUR, 30, IdGenerator.generateDriverId(StationPoint.TAMBARAM));
        Bike vehicle31 = new Bike("Yezdi Roadster", "kn7624");
        newDriver31.setDriveableVehicleType(VehicleType.BIKE);
        newDriver31.setAssociatedVehicle(vehicle31);
        CabCentralHub.addCabCentre(this, cabCentre1, StationPoint.TAMBARAM);

        CabCentre cabCentre3 = new CabCentre(StationPoint.GUDUVANCHERY);
        Driver newDriver13 = new Driver("Maddy", 25, "MaddyMaddy1254","Maddy$344".toCharArray(), StationPoint.GUDUVANCHERY, 8, IdGenerator.generateDriverId(StationPoint.GUDUVANCHERY));
        Car vehicle13 = new Car("Toyota Innova", "MP8796", 6, 6, true,CarType.SUV);
        newDriver13.setDriveableVehicleType(VehicleType.CAR);
        newDriver13.setAssociatedVehicle(vehicle13);
        Driver newDriver23 = new Driver("Rambo", 30, "RamboRomeo12","TheRambo&@35".toCharArray(), StationPoint.GUDUVANCHERY, 7, IdGenerator.generateDriverId(StationPoint.GUDUVANCHERY));
        AutoRickshaw vehicle23 = new AutoRickshaw("Bajaj-RE", "tn3467");
        newDriver23.setDriveableVehicleType(VehicleType.AUTO_RICKSHAW);
        newDriver23.setAssociatedVehicle(vehicle23);
        Driver newDriver33 = new Driver("Chad", 23, "chad654","Chad@23Cabs".toCharArray(), StationPoint.GUDUVANCHERY, 9, IdGenerator.generateDriverId(StationPoint.GUDUVANCHERY));
        Bike vehicle33 = new Bike("Honda Splendor", "tn9856");
        newDriver33.setDriveableVehicleType(VehicleType.BIKE);
        newDriver33.setAssociatedVehicle(vehicle33);

        CabCentralHub.addCabCentre(this, cabCentre1, StationPoint.GUDUVANCHERY);

    }

}
