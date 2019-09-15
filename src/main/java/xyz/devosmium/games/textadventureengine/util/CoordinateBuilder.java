package xyz.devosmium.games.textadventureengine.util;

public class CoordinateBuilder {

    private int x;
    private int y;
    private int z;

    public CoordinateBuilder(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Coordinate buildCoordinate() {
        return new Coordinate(x, y, z);
    }

}