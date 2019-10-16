package xyz.devosmium.games.locations;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import xyz.devosmium.games.textadventureengine.locations.Area;
import xyz.devosmium.games.textadventureengine.locations.Location;
import xyz.devosmium.games.textadventureengine.locations.LocationFactory;
import xyz.devosmium.games.textadventureengine.util.Coordinate;
import xyz.devosmium.games.textadventureengine.util.CoordinateBuilder;

public class LocationFactoryTest extends LocationFactory {

    @Test
    public void buildLocationTest() {
        LocationFactory test = new LocationFactory();
        Coordinate realCoord = new Coordinate(1, 1, 1);
        Location testLoc;

        testLoc = test.buildLocation(realCoord, "Test", "Testing Room");

        assertEquals(realCoord.x, testLoc.getCoordinate().x);

        assertEquals("Test", testLoc.getShort());

        assertEquals("Testing Room", testLoc.getLong());
    }
}