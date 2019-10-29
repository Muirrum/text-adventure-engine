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
    @Ignore
    public void buildLocationTest() {
        LocationFactory test = new LocationFactory();
        CoordinateBuilder cBuilder = new CoordinateBuilder();

        Coordinate realCoord = cBuilder.buildCoordinate(1, 1, 1);

        test.buildLocation(cBuilder.buildCoordinate(1, 1, 1), "Test", "Testing Room", new Area("test"));

        Location testLoc = test.getLocations().get(0);

        assertEquals(realCoord.x, testLoc.getCoordinate().x);

        assertEquals("Test", testLoc.getShort());

        assertEquals("Testing Room", testLoc.getLong());
    }
}