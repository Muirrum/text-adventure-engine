package xyz.devosmium.games.textadventureengine.commands;

public @interface EngineCommand {
  public final int n = 1;
  public final int s = -1;
  public final int w = 1;
  public final int e = -1;

  /**
   *  Create a coordinate based on North, South, West, East defined integers
   *
   *  @param x the x coordinate
   *  @param z the z coordinate
   */
  public NorthSouthWestEast(int x, int z) {
    this.w = x;
    this.e = x;
    this.n = z;
    this.s = z;
  }
}
