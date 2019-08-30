package xyz.devosmium.games;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xyz.devosmium.games.menus.MainMenu;
import xyz.devosmium.games.util.MessageQueue;

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
