package xyz.devosmium.games.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import xyz.devosmium.games.textadventureengine.util.Coordinate;
import xyz.devosmium.games.textadventureengine.util.CoordinateBuilder;

public class CoordinateBuilderTest {

    @Test
    public void coordinateBuildTester() {
        Coordinate coordinate = new CoordinateBuilder().buildCoordinate(1, 1, 1);
        assertEquals(1, coordinate.x);
        assertEquals(1, coordinate.y);
        assertEquals(1, coordinate.z);
    }
}