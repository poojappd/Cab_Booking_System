import java.util.ArrayList;
import java.util.HashMap;


class Map {
    private static HashMap<String,Location> Locations = new HashMap<>();
    private static HashMap<StationPoint, ArrayList<Location>> locationsUnderBaseStations  = new HashMap<>();
    

    static void addToMap(Location location ){
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

    static void viewBaseLocations(){
        int i =1;
        for(StationPoint stationPoint:StationPoint.values()){
            System.out.println(i++ +". "+stationPoint);
        }
    }

    static void viewLocationFromBaseLocation(StationPoint baseLocation){
        int i = 1;
        System.out.println("------------------Areas of "+baseLocation+"------------------");
        for(Location location : locationsUnderBaseStations.get(baseLocation)){
            System.out.println(i+++". "+location.getArea());
        }

    }
    static int getBaseLocationCount(){
        return locationsUnderBaseStations.keySet().size();
    }
    static int getAreaCount(StationPoint baseStation){
        return locationsUnderBaseStations.get(baseStation).size();
    }

    static Location getLocationFromOption(StationPoint baseStation, int index){
        return locationsUnderBaseStations.get(baseStation).get(index);
    }
}

