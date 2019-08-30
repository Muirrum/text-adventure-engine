package xyz.devosmium.games.exceptions;

public class DeathException extends Exception {

    private static final long serialVersionUID = 1L;

    public DeathException() {
        super();
    }

    public DeathException(String message) {
        super(message);
    }

}