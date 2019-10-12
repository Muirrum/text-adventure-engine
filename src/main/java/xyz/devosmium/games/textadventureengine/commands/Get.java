package xyz.devosmium.games.textadventureengine.commands;

import xyz.devosmium.games.textadventureengine.locations.Location;
import xyz.devosmium.games.textadventureengine.mobiles.Player;

@CommandAnnotation(command = "get", description = "Gets an item from the current room")
public class Get implements Command {

    @Override
    public void execute(Player player) {
        Location loc = player.getLocation();
    }
}