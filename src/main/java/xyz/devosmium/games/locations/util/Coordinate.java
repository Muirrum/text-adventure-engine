package xyz.devosmium.games.locations.util;


/**
 * Describes a point in 3D space
 */
public class Coordinate {
    public final int x;
    public final int y;
    public final int z;

    /**
     * Create a coordinate based on 3 defined integers
     * @param x the x coordinate
     * @param y the y coordinate
     * @param z the z coordinate
     */
    public Coordinate(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() { return x + "," + y + "," + z; }
}