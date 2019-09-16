package xyz.devosmium.games.textadventureengine.exceptions;

/**
 * Thrown when the player dies.
 */
public class DeathException extends Exception {

  private static final long serialVersionUID = 1L;

  public DeathException() {
    super();
  }

  public DeathException(String message) {
    super(message);
  }

}