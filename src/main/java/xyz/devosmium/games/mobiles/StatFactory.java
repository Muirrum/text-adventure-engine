package xyz.devosmium.games.mobiles;

import java.util.HashMap;
import java.util.Map;

public class StatFactory {

  private Map<String, Integer> stats = new HashMap<>();

  public Map<String, Integer> build() {
    return this.stats;
  }

  public void setStr(int str) {
    stats.put("str", str);
  }

  public void setDex(int dex) {
    stats.put("dex", dex);
  }

  public void setLuck(int luck) {
    stats.put("luck", luck);
  }

  public void setIntel(int intel) {
    stats.put("int", intel);
  }

  public void setWis(int wis) {
    stats.put("wis", wis);
  }
}