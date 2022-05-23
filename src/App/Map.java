package App;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


public class Map {
    private static HashMap<String,Location> Locations = new HashMap<>();
    private static HashMap<StationPoint, ArrayList<Location>> locationsUnderBaseStations  = new HashMap<>();
    

    static void addToMap(Admin admin, Location location ){
        if(locationsUnderBaseStations.containsKey(location.getStationPoint())){
            Locations.put(location.getArea(), location);
            locationsUnderBaseStations.get(location.getStationPoint()).add(location);
        }
        else{
            locationsUnderBaseStations.put(location.getStationPoint(), new ArrayList<>());
            locationsUnderBaseStations.get(location.getStationPoint()).add(location);
        }
    }

    static void getBaseLocations(){
        StationPoint.values();
    } 
    
    static void getLocationFromBaseLocation(StationPoint baseLocation){
        locationsUnderBaseStations.get(baseLocation);
    }

    public static void viewBaseLocations(){
        int i =1;
        for(StationPoint stationPoint:StationPoint.values()){
            System.out.println(i++ +". "+stationPoint);
        }
    }

    public static void viewLocationFromBaseLocation(StationPoint baseLocation){
        int i = 1;
        System.out.println("------------------Areas of "+baseLocation+"------------------");
        for(Location location : locationsUnderBaseStations.get(baseLocation)){
            System.out.println(i+++". "+location.getArea());
        }

    }
    public static int getBaseLocationCount(){
        return locationsUnderBaseStations.keySet().size();
    }
    public static int getAreaCount(StationPoint baseStation){
        return locationsUnderBaseStations.get(baseStation).size();
    }

    public static Location getLocationFromOption(StationPoint baseStation, int index){
        return locationsUnderBaseStations.get(baseStation).get(index-1);
    }

    static double calculateDistance(Location fromLocation, Location toLocation){
        double x1Coordinate = fromLocation.getxCoordinate();
        double y1Coordinate = fromLocation.getyCoordinate();
        double x2Coordinate = toLocation.getxCoordinate();
        double y2Coordinate = toLocation.getyCoordinate();

        double distance = Math.sqrt((Math.pow((x2Coordinate - x1Coordinate),2))
                + (Math.pow((y2Coordinate - y1Coordinate),2))) * 100;

        return distance;

    }
    static StationPoint getNearestStationPoint(StationPoint fromStationPoint, Set<StationPoint> stationPointSet){
        double minDistance = Double.MAX_VALUE;
        StationPoint nearestStationPoint = fromStationPoint;
        for (StationPoint checkPoint: stationPointSet){
            Location source = getLocationFromOption(fromStationPoint,1);
            Location destination = getLocationFromOption(checkPoint, 1);
            double currentDistance =  calculateDistance(source, destination);

            if(minDistance > currentDistance){
                minDistance = currentDistance;
                nearestStationPoint = destination.getStationPoint();
            }

        }
        return nearestStationPoint;
    };
}

