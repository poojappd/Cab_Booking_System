package App;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Admin {
    private static final String adminPassword = "Admin@123";
    private static Admin singleAdminInstance;
    private Admin(){}

    public static Admin instantiateOnce(String checkAdminPassword){
        if(checkAdminPassword.equals(adminPassword)){
            if (singleAdminInstance == null){
                singleAdminInstance = new Admin();
            }
            return singleAdminInstance;
        }
        return null;

    }
    private void createMap(){
        String linesInCSV;
        String toRemove = ",";
        try {

            BufferedReader br = new BufferedReader(new FileReader("resources/MapData.csv"));
            while ((linesInCSV = br.readLine()) != null)
            {
                String[] CsvValues = linesInCSV.split(toRemove);
                StationPoint stationPoint = StationPoint.valueOf(CsvValues[0].replaceAll("\\s", ""));
                String area = CsvValues[1];
                double xCoordinate = Double.parseDouble(CsvValues[2]);
                double yCoordinate = Double.parseDouble(CsvValues[3]);
                Location location = new Location(xCoordinate, yCoordinate, stationPoint, area);
                Map.addToMap(this, location);


            }

        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    private void initializeCabCentralHub(){
        CabCentre cabCentre1 = new CabCentre(StationPoint.ALANDUR);
        Driver newDriver1 = new Driver("Perumal", 35, "peru","peru@35Cabs".toCharArray(), StationPoint.ALANDUR, 5, IdGenerator.generateDriverId(StationPoint.ALANDUR));
        Car vehicle1 = new Car("Maruti Swift", "tn4567", 4, true,CarType.SEDAN);
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
        cabCentre1.addVehicleWithDriver(vehicle1, newDriver1);
        cabCentre1.addVehicleWithDriver(vehicle2,newDriver2);
        cabCentre1.addVehicleWithDriver(vehicle3, newDriver3);
        CabCentralHub.addCabCentre(this, cabCentre1, StationPoint.ALANDUR);

        CabCentre cabCentre2 = new CabCentre(StationPoint.TAMBARAM);
        Driver newDriver11 = new Driver("Kumar", 35, "kumar@35Cabs","Kumar#123".toCharArray(), StationPoint.TAMBARAM, 10, IdGenerator.generateDriverId(StationPoint.TAMBARAM));
        Car vehicle11 = new Car("Maruti Swift", "tn8765",  4, true,CarType.SEDAN);
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
        cabCentre2.addVehicleWithDriver(vehicle11, newDriver11);
        cabCentre2.addVehicleWithDriver(vehicle21, newDriver21);
        cabCentre2.addVehicleWithDriver(vehicle31, newDriver31);
        CabCentralHub.addCabCentre(this, cabCentre2, StationPoint.TAMBARAM);

        CabCentre cabCentre3 = new CabCentre(StationPoint.GUDUVANCHERY);
        Driver newDriver12 = new Driver("Maddy", 25, "MaddyMaddy1254","Maddy$344".toCharArray(), StationPoint.GUDUVANCHERY, 8, IdGenerator.generateDriverId(StationPoint.GUDUVANCHERY));
        Car vehicle12 = new Car("Toyota Innova", "MP8796",  6, true,CarType.SUV);
        newDriver12.setDriveableVehicleType(VehicleType.CAR);
        newDriver12.setAssociatedVehicle(vehicle12);
        Driver newDriver22 = new Driver("Rambo", 30, "RamboRomeo12","TheRambo&@35".toCharArray(), StationPoint.GUDUVANCHERY, 7, IdGenerator.generateDriverId(StationPoint.GUDUVANCHERY));
        AutoRickshaw vehicle22 = new AutoRickshaw("Bajaj-RE", "tn3467");
        newDriver22.setDriveableVehicleType(VehicleType.AUTO_RICKSHAW);
        newDriver22.setAssociatedVehicle(vehicle22);
        Driver newDriver32 = new Driver("Chad", 23, "chad654","Chad@23Cabs".toCharArray(), StationPoint.GUDUVANCHERY, 9, IdGenerator.generateDriverId(StationPoint.GUDUVANCHERY));
        Bike vehicle32 = new Bike("Honda Splendor", "tn9856");
        newDriver32.setDriveableVehicleType(VehicleType.BIKE);
        newDriver32.setAssociatedVehicle(vehicle32);
        cabCentre3.addVehicleWithDriver(vehicle12, newDriver12);
        cabCentre3.addVehicleWithDriver(vehicle22, newDriver22);
        cabCentre3.addVehicleWithDriver(vehicle32, newDriver32);
        CabCentralHub.addCabCentre(this, cabCentre3, StationPoint.GUDUVANCHERY);

    }

    public void initializeSystem(){
        createMap();
        initializeCabCentralHub();
    }

}
