import java.util.ArrayList;
import java.util.HashMap;


class Map {
    private static ArrayList<Location> Locations = new ArrayList<>();;
    private static HashMap<StationPoint, ArrayList<String>> locationsUnderBaseStations  = new HashMap<>();
    

    static void addToMap(Location location ){
        if(locationsUnderBaseStations.containsKey(location.getStationPoint())){
            Locations.add(location);
            locationsUnderBaseStations.get(location.getStationPoint()).add(location.getArea());
        }
        else{
            locationsUnderBaseStations.put(location.getStationPoint(), new ArrayList<>());
            locationsUnderBaseStations.get(location.getStationPoint()).add(location.getArea());
        }
    }

    static void getBaseLocations(){
        StationPoint.values();
    } 
    
    static void getLocationFromBaseLocation(StationPoint baseLocation){
        locationsUnderBaseStations.get(baseLocation);
    }
      
}

