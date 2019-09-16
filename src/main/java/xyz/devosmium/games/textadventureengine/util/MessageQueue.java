package xyz.devosmium.games.textadventureengine.util;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handles output and input to console
 */
public class MessageQueue {
  private static Logger logger = LoggerFactory.getLogger(MessageQueue.class);

  /**
   * @param message The message to be displayed to the console
   */
  public static void add(String message) {
    // logger.debug("add(" + message + ")");
    System.out.println(message);
  }

  /**
   * Gets input from player
   * 
   * @return User input
   */
  public static String take() {
    String message = null;

    Scanner input = new Scanner(System.in);
    message = input.next();
    return message;
  }
}