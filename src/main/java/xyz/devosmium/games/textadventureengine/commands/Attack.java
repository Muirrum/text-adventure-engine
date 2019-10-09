package xyz.devosmium.games.textadventureengine.commands;

import xyz.devosmium.games.textadventureengine.mobiles.Player;
import xyz.devosmium.games.textadventureengine.util.MessageQueue;

@CommandAnnotation(command = "attack", description = "Attack an enemy")
public class Attack implements Command {
    @Override
    public void execute(Player player) {
        MessageQueue.add("player attack...");
    }
}
