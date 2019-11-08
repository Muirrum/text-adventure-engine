package xyz.devosmium.games.textadventureengine.commands;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import xyz.devosmium.games.textadventureengine.mobiles.Player;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Command {


public interface Command {
    void execute(Player player);
}
