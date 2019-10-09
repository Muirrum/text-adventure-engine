package xyz.devosmium.games.textadventureengine.commands;

import xyz.devosmium.games.textadventureengine.mobiles.Player;
import xyz.devosmium.games.textadventureengine.util.MessageQueue;

import java.util.List;

@CommandAnnotation(command = "help", description = "Displays help for commands")
public class Help implements Command {
    @Override
    public void execute(Player player) {
        EngineCommandManager manager = new EngineCommandManager();
        List<CommandModel> commands = manager.getCommands();
        MessageQueue.add("Use one of this commands: ");
        for (CommandModel command : commands) {
            MessageQueue.add("Command : " + command.getCommand() + " - " + command.getDescription());
        }
    }
}
