package xyz.devosmium.games.textadventureengine.locations;

import java.util.ArrayList;

import xyz.devosmium.games.textadventureengine.mobiles.Mobile;
import xyz.devosmium.games.textadventureengine.util.Coordinate;

public class LocationFactory {

    private ArrayList<Location> locations;
    
    public LocationFactory() {
        locations = new ArrayList<Location>();
    }

    public Location buildLocation(Coordinate coordinates, String shortString, String longString, ArrayList<Mobile> mobiles) {
        Location newLoc = new Location(coordinates, shortString, longString, mobiles);

        locations.add(newLoc);
        return newLoc;
    }

    public Location buildLocation(Coordinate coordinates, String shortString, String longString) {
        Location newLoc = new Location(coordinates, shortString, longString);

        locations.add(newLoc);

        return newLoc;
    }
}