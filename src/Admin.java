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

            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\pooja\\Downloads\\MapData.csv"));
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
    void createCabCentre(){

    }

}
