package xyz.devosmium.games.textadventureengine.util;

/**
 * Builds a Coordinate type
 *
 * @see xyz.devosmium.games.textadventureengine.util.Coordinate
 */
public class CoordinateBuilder {

  private int x;
  private int y;
  private int z;

  public CoordinateBuilder(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public CoordinateBuilder() {

  }

  public Coordinate buildCoordinate() {
    return new Coordinate(x, y, z);
  }

  public Coordinate buildCoordinate(int x, int y, int z) {
    return new Coordinate (x, y, z);
  }

}
