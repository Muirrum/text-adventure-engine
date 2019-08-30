package xyz.devosmium.games.locations.util;

public enum Direction {
  NORTH("To the north", 0, 1, 0), SOUTH("To the south", 0, -1, 0), EAST("To the east", 1, 0, 0),
  WEST("To the west", -1, 0, 0), DOWN("Down", 0, 0, -1), UP("Up", 0, 0, 1);

  private final String description;
  private final int dx;
  private final int dy;
  private final int dz;

  private Direction(String description, int dx, int dy, int dz) {
    this.description = description;
    this.dx = dx;
    this.dy = dy;
    this.dz = dz;
  }

  public String getDescription() {
    return description;
  }

  public int getDx() {
    return dx;
  }

  public int getDy() {
    return dy;
  }

  public int getDz() {
    return dz;
  }
}