package xyz.devosmium.games.textadventureengine.locations;

import java.util.ArrayList;


//Area Collection class will hold Areas in an ArrayList. Its primary function is to store and retrieve areas.
public class AreaCollection {
    private ArrayList<Area> areaCollection;

    public AreaCollection() {
        areaCollection = new ArrayList<Area>();
    }

    public void addAreaObject(Area area) {
        this.areaCollection.add(area);
    }

    public Area searchAreaByName(String areaName){
        for (Area name : areaCollection) {
            if(name.getAreaName() != null && name.getAreaName().equals(areaName))
                return name;
        }
        return null;
    }

    public Area searchAreaByID(int areaNum){
        for (Area id : areaCollection) {
            if(id.getAreaID() == areaNum)
                return id;
        }
        return null;
    }
}
