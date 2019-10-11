package xyz.devosmium.games.textadventureengine.commands;

import org.apache.commons.lang3.StringUtils;
import org.reflections.Reflections;
import xyz.devosmium.games.textadventureengine.mobiles.Player;
import xyz.devosmium.games.textadventureengine.util.MessageQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class to manage the input from user and then return the respective command.
 * <p>
 * Commands are annotated with the @{@link CommandAnnotation} annotation.
 * <p>All commands should implements @{@link Command} interface</p>
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

    /**
     * From a command input from user, passed by into the constructor, check if the command exists.
     * When command is found return it executing the behavior of the class that implements the command interface.
     */
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

    /**
     * Find the commands and return them
     * @return command list
     */
    public List<CommandModel> getCommands() {
        findCommands();
        return commands;
    }

    /**
     * From all classes with have the @{@link CommandAnnotation}, get their
     * command, description and class, to create a list of {@link CommandModel}
     */
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
