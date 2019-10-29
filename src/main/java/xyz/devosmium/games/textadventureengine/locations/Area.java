package xyz.devosmium.games.textadventureengine.locations;

import java.util.ArrayList;

public class Area {

    private String name;

    private ArrayList<Location> locations;

    public Area(String name) {
        this.name = name;
        locations = new ArrayList<Location>();
    }

    public void registerLocation(Location location) {
        locations.add(location);
    }

    public ArrayList<Location> getLocationList() {
        return locations;
    }

    /**
     * Searchs the registered locations by name
     * @param name The name of the location (short string)
     * @return Location if it's been registered, or null
     */
    public Location getLocationByName(String name) {
        for (Location loc : locations) {
            if (loc.getShort().equals(name)) {
                return loc;
            } else {
                continue;
            }
        }
        return null;
    }

    
}