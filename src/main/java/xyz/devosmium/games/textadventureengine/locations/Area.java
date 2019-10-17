package xyz.devosmium.games.textadventureengine.locations;

import java.util.ArrayList;

public class Area {

    private String areaName;
    private int areaID;
    private ArrayList<Location> areaLocations;

    public Area(String areaName, int areaID) {
        this.areaName = areaName;
        this.areaID = areaID;
        areaLocations = new ArrayList<Location>();
    }

    public int getAreaID() {
        return areaID;
    }

    public String getAreaName() {
        return areaName;
    }

    public void registerLocation(Location location) {
        areaLocations.add(location);
    }
}