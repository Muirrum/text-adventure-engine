package xyz.devosmium.games.textadventureengine.commands;

import org.apache.commons.lang3.StringUtils;
import org.reflections.Reflections;
import xyz.devosmium.games.textadventureengine.mobiles.Player;
import xyz.devosmium.games.textadventureengine.util.MessageQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Contains the commands required to interact with the game itself, like help
 * and exit
 * <p>
 * Commands are annotated with the @Command annotation.
 */
public class EngineCommandManager {

    protected Player player;
    private String commandInput;
    private final static String PACKAGE_PATH = "xyz.devosmium.games.textadventureengine";
    private List<CommandModel> commands = new ArrayList<>();

    public EngineCommandManager() {

    }

    public EngineCommandManager(Player player, String command) {
        this.player = player;
        this.commandInput = command.trim().toLowerCase();
    }


    public void executeCommand() {
        try {
            findCommands();
            List<CommandModel> commandFound = commands.stream().filter(f -> commandInput.equals(f.getCommand())).collect(Collectors.toList());
            if (commandFound.isEmpty()) {
                MessageQueue.add("The command " + commandInput + " was not found");
            } else {
                Class<?> clazz = Class.forName(commandFound.get(0).getaClass().getName());
                Command command = (Command) clazz.newInstance();
                command.execute(player);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Failed to get command ", e);
        }
    }

    public List<CommandModel> getCommands() {
        findCommands();
        return commands;
    }

    private void findCommands() {
        Reflections reflections = new Reflections(PACKAGE_PATH);
        for (Class<?> clz : reflections.getTypesAnnotatedWith(CommandAnnotation.class)) {
            CommandAnnotation annotation = clz.getDeclaredAnnotation(CommandAnnotation.class);
            String command = annotation.command();
            String description = annotation.description();
            boolean hasValues = !StringUtils.isBlank(command) && !StringUtils.isBlank(description);
            if (hasValues) {
                CommandModel commandModel = new CommandModel();
                commandModel.setCommand(command);
                commandModel.setDescription(description);
                commandModel.setaClass(clz);
                commands.add(commandModel);
            }
        }
    }
}
