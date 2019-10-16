package xyz.devosmium.games.textadventureengine;

import xyz.devosmium.games.textadventureengine.exceptions.DeathException;
import xyz.devosmium.games.textadventureengine.locations.World;
import xyz.devosmium.games.textadventureengine.menus.MainMenu;
import xyz.devosmium.games.textadventureengine.mobiles.Player;
import xyz.devosmium.games.textadventureengine.util.MessageQueue;
import xyz.devosmium.games.textadventureengine.util.PlayerType;

public class Game {

  Player player = null;

  String intro = "You blink your eyes open, and stand up.";

  public Game(Player player, PlayerType type) {
    World world = new World();

    this.player = player;
    try {
      switch (type) {
      case NEW:
        MessageQueue.add(intro);
        gamePrompt(player, true);
        break;
      case RETURNING:
        MessageQueue.add("How did you get here?");
        gamePrompt(player, false);
        break;
      default:
        MessageQueue.add("Invalid type.");
        throw new Exception("Invalid player type");
      }
    }catch (DeathException de){
      System.out.println(de.getMessage());
      new MainMenu();
    }catch (Exception e) {
      System.exit(-1);
    }
  }

  protected void gamePrompt(Player player, boolean newPlayer) throws DeathException{
    boolean contPrompt = true;
    if (newPlayer) {
      MessageQueue.add("Welcome, " + player.getName() + ". Have fun!");
    } else {
      MessageQueue.add("How'd you get here?");
    }

    do {

      String health = MessageQueue.take();
      //player.getHealth()
      if( Integer.parseInt(health) <= 0) {
          throw new DeathException("Death");
      }
    } while (contPrompt);

  }
}