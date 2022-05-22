package App;

public class Location{
    Location(double xCoordinate, double yCoordinate, StationPoint stationPoint, String area){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.stationPoint = stationPoint;
        this.area = area;
    }
    private double xCoordinate;
    private double yCoordinate;
    private StationPoint stationPoint;
    private String area;

    public double getxCoordinate() {
        return xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public StationPoint getStationPoint() {
        return stationPoint;
    }
    public String getArea(){
        return area;
    }
}