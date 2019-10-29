package xyz.devosmium.games.textadventureengine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xyz.devosmium.games.textadventureengine.menus.MainMenu;

/**
 * Hello world!
 *
 */
public class App {
  private static Logger logger = LoggerFactory.getLogger(App.class);


  public static void main(String[] args) {
    logger.debug("Starting game");
    new MainMenu();
  }
}
