package xyz.devosmium.games.textadventureengine.locations;

import java.util.ArrayList;

/**
 * AreaCollection
 *
 * The AreaCollection will be responsible for collecting and storing Areas of the game. AreaCollection is an optional
 * storage for Areas. Only 1 AreaCollection should be initialized in the Game world and be used as the primary storage
 * for retrieving Areas.
 *
 * @author Jessie Vela
 * @version 1.0
 * @since 15 OCT 2019
 */
public class AreaCollection {
    private ArrayList<Area> areaCollection;

    /**
     * AreaCollection constructor initializes the ArrayList that will hold the Area objects.
     */
    public AreaCollection() {
        areaCollection = new ArrayList<Area>();
    }

    /**
     * Adds an Area to the AreaCollection.
     *
     * @param area The Area object to be stored into the ArrayList
     */
    public void addAreaObject(Area area) {
        this.areaCollection.add(area);
    }

    /**
     * Searches the AreaCollection for an Area with the matching name. If found Area object matching the name is
     * returned, else null is returned signifying no Area matching name is present.
     *
     * returns null.
     * @param areaName The name of the Area to be searched for in the ArrayList.
     * @return Returns the Area Object if found. Else null to indicate it is not found.
     */
    public Area searchAreaByName(String areaName){
        for (Area name : areaCollection) {
            if(name.getAreaName() != null && name.getAreaName().equals(areaName))
                return name;
        }
        return null;
    }

    /**
     * Searches the AreaCollection for an Area with a matching ID. If found the Area object matching the ID is
     * returned, else null is returned. signifying no Area matching ID is present.
     *
     * @param areaNum The unique ID of the Area to be searched for in the ArrayList.
     * @return Returns the Area Object if found. Else null is returned to indicate it is not found.
     */
    public Area searchAreaByID(int areaNum){
        for (Area id : areaCollection) {
            if(id.getAreaID() == areaNum)
                return id;
        }
        return null;
    }
}
