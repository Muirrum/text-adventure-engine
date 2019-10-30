package xyz.devosmium.games.textadventureengine.commands;

import java.lang.reflect.Method;

import xyz.devosmium.games.textadventureengine.mobiles.Player;
import xyz.devosmium.games.textadventureengine.util.MessageQueue;

/**
 * Contains the commands required to interact with the game itself, like help
 * and exit
 * 
 * Commands are annotated with the @Command annotation.
 */
public class EngineCommandRepository {

  protected Player player;

  public EngineCommandRepository(Player player) {
    this.player = player;
  }

  @Command(command = "help", description = "Displays help for commands")
  public void command_help() {
    Method[] methods = EngineCommandRepository.class.getMethods();

    MessageQueue.add("");
    for (Method method : methods) {
      if (method.isAnnotationPresent(Command.class)) {
    	  Command anno = method.getAnnotation(Command.class);
          String command = anno.command();
          String description = anno.description();

          String message = command + ": " + description;
          MessageQueue.add(message);
      }
    }
  }
}