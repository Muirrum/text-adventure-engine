package xyz.devosmium.games.textadventureengine.locations;

import java.util.ArrayList;

import xyz.devosmium.games.textadventureengine.mobiles.Mobile;
import xyz.devosmium.games.textadventureengine.util.Coordinate;

/**
 * Represents a defined location in the world. Built by a LocationFactory
 */
public class Location {

  private Coordinate coordinates;

  /**
   * @return The Coordinate object representing this Location's position in space
   */
  public Coordinate getCoordinate() {
    return coordinates;
  }

  private String shortString;

  /**
   * @return The short name of the location
   */
  public String getShort() {
    return shortString;
  }

  /**
   * Sets the name of the location
   *
   * @param shortString The new name of the location
   */
  public void setShort(String shortString) {
    this.shortString = shortString;
  }

  private String longString;

  /**
   * @return The long description of the location
   */
  public String getLong() {
    return longString;
  }

  /**
   * @param longString The new long description of the location
   */
  public void setLong(String longString) {
    this.longString = longString;
  }

  private ArrayList<Mobile> mobiles;

  public ArrayList<Mobile> getMobiles() {
    return mobiles;
  }

  /**
   * @param mobiles An ArrayList of Mobile Entities
   * @see Location(Coordinate, String, String)
   */
  public Location(Coordinate coordinates, String shortString, String longString, ArrayList<Mobile> mobiles) {

    this.coordinates = coordinates;
    this.shortString = shortString;
    this.longString = longString;
    this.mobiles = mobiles;
  }

  /**
   * @param coordinates The coordinates
   * @param shortString Name
   * @param longString Long description
   */
  public Location(Coordinate coordinates, String shortString, String longString) {

    this.coordinates = coordinates;
    this.shortString = shortString;
    this.longString = longString;
  }

  /**
   * Creates a default room in the center of the map. Not recommended
   *
   * @deprecated
   */
  public Location() {
    
    this.coordinates = new Coordinate(0, 0, 0);
    this.shortString = "Development Room";
    this.longString = "A room for developers";
  }

}
