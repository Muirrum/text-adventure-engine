package xyz.devosmium.games.locations;

import org.junit.Ignore;
import xyz.devosmium.games.textadventureengine.locations.AreaCollection;
import xyz.devosmium.games.textadventureengine.locations.Area;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The AreaCollectionTest confirms the collection is able to be created, stored, and retrieved.
 */
public class AreaCollectionTest extends AreaCollection {

    private AreaCollection areas;

    /**
     * Initialize test case with dummy data.
     */
    public AreaCollectionTest(){
        areas = new AreaCollection();

        Area testArea1 = new Area("Test Area", 123);
        Area testArea2 = new Area("Test Area with ID", 90011);

        areas.addAreaObject(testArea1);
        areas.addAreaObject(testArea2);
    }

    /**
     * Test Case: An Area should be able to be located by name if it exists in AreaCollection
     * Test Case: null should be returned if Area is not found by name in AreaCollection
     */
    @Test
    public void searchAreaName(){
        assertEquals("Test Area", areas.searchAreaByName("Test Area").getAreaName());
        assertEquals(null, areas.searchAreaByName("Test Area Not Found"));
    }

    /**
     * Test Case: An Area should be able to be located by ID if it exists in AreaCollection
     * Test Case: null should be returned if Area is not found by ID in AreaCollection
     */
    @Test
    public void searchAreaID(){
        assertEquals(90011, areas.searchAreaByID(90011).getAreaID());
        assertEquals(null, areas.searchAreaByID(11111));

    }
}
