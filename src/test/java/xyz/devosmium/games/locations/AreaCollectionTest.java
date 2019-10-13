package xyz.devosmium.games.locations;

import xyz.devosmium.games.textadventureengine.locations.AreaCollection;
import xyz.devosmium.games.textadventureengine.locations.Area;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AreaCollectionTest extends AreaCollection {

    private AreaCollection areas;

    public AreaCollectionTest(){
        //Create a
        areas = new AreaCollection();

        Area testArea1 = new Area("Test Area", 123);
        Area testArea2 = new Area("Test Area with ID", 90011);

        areas.addAreaObject(testArea1);
        areas.addAreaObject(testArea2);

        //Create a location
    }

    @Test
    public void searchAreaName(){
        assertEquals("Test Area", areas.searchAreaByName("Test Area").getAreaName());
    }
    @Test
    public void searchAreaID(){
        assertEquals(90011, areas.searchAreaByID(90011).getAreaID());
    }

    @Test
    public void getLocationInArea(){

    }
}
