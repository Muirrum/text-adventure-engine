package xyz.devosmium.games.textadventureengine.mobiles;

import java.util.Map;

/**
 * Represents a mobile entity - something that can move around on its own. These
 * entities often have health, names, levels, inventories, and stats. They can
 * interact with the world around them.
 */
public class Mobile {

  // Declare all variables
  private int maxHealth;
  private int health;

  private String name;

  private int level;

  // Stats
  protected Map<String, Integer> stats;

  private int gold;

  public Mobile(int maxHealth, int health, String name, int level, Map<String, Integer> stats, int gold) {
    this.maxHealth = maxHealth;
    this.health = health;

    this.name = name;

    this.level = level;

    this.stats = stats;

    this.gold = gold;
  }

  public int getHealth() {
    return health;
  }

  public void modHealth(int mod) {
    health += mod;
  }

  public int getGold() {
    return gold;
  }

  public void modGold(int mod) {
    gold += mod;
  }

  public String getName() {
    return name;
  }

  public int getLevel() {
    return level;
  }

  public void modLevel(int mod) {
    level += mod;
  }

  public int getStat(Stats stat) {
    switch (stat) {
    case STRENGTH:
      return stats.get("str") == null ? 0 : stats.get("str");
    case DEXTERITY:
      return stats.get("dex") == null ? 0 : stats.get("dex");
    case INTELLIGENCE:
      return stats.get("int") == null ? 0 : stats.get("int");
    case LUCK:
      return stats.get("luck") == null ? 0 : stats.get("luck");
    case WISDOM:
      return stats.get("wis") == null ? 0 : stats.get("wis");
    default:
      return 0;
    }
  }

}