package xyz.devosmium.games;

import xyz.devosmium.games.mobiles.Player;
import xyz.devosmium.games.util.MessageQueue;
import xyz.devosmium.games.util.PlayerType;

public class Game {

  Player player = null;

  String intro = "You blink your eyes open, and stand up.";

  public Game(Player player, PlayerType type) {
    this.player = player;
    try {
      switch (type) {
      case NEW:
        MessageQueue.add(intro);
      case RETURNING:
        MessageQueue.add("How did you get here?");
      default:
        MessageQueue.add("Invalid type.");
        throw new Exception("Invalid player type");
      }
    } catch (Exception e) {
      System.exit(-1);
    }
  }

  protected void gamePrompt(Player player) {
    boolean contPrompt = true;

  }
}