package xyz.devosmium.games.textadventureengine.mobiles;

import java.util.Map;
import xyz.devosmium.games.textadventureengine.items.Inventory;
import xyz.devosmium.games.textadventureengine.locations.Area;
import xyz.devosmium.games.textadventureengine.locations.Location;
import xyz.devosmium.games.textadventureengine.locations.LocationFactory;
import xyz.devosmium.games.textadventureengine.util.CoordinateBuilder;

/**
 * Special class for Players. Contains some special things for leveling
 */
public class Player extends Mobile {

  public Inventory inventory;
  private Player(int maxHealth, int health, String name, int level, Map<String, Integer> stats, int gold) {
    super(maxHealth, health, name, level, stats, gold, new LocationFactory().buildLocation(new CoordinateBuilder(0, 0, 0).buildCoordinate(), "Start", "Starting room", new Area("Default")));

    inventory = new Inventory();

  }

  private static Player player;

  public static Player getInstance() {
    if (player == null) {

      player = new Player(15, 15, "player", 1, buildInitialStatBlock(), 0);
    }

    return player;
  }

  private static Map<String, Integer> buildInitialStatBlock() {
    StatFactory factory = new StatFactory();

    factory.setDex(5);
    factory.setIntel(5);
    factory.setLuck(5);
    factory.setStr(5);
    factory.setWis(5);

    return factory.build();
  }
}