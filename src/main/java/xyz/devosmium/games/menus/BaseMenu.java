package xyz.devosmium.games.menus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xyz.devosmium.games.util.MessageQueue;

public class BaseMenu {

    protected List<MenuItem> menuItems = new ArrayList<>();
    protected Map<String, MenuItem> commandMap = new HashMap<String, MenuItem>();

    public MenuItem displayMenu(List<MenuItem> menuList) {
        int i = 1;
        for (MenuItem menuItem : menuList) {
            commandMap.put(String.valueOf(i), menuItem);
            commandMap.put(menuItem.getCmdKey(), menuItem);
            i++;
        }
        // Find user input to return
        return getSelection(menuList);
    }

    // Get user input from the message queue
    protected MenuItem getSelection(List<MenuItem> m) {
        this.printMenuItems(m);
        String command = MessageQueue.take();
        if (commandMap.containsKey(command.toLowerCase())) {
            return commandMap.get(command.toLowerCase());
        } else {
            MessageQueue.add("I don't know what '" + command + "' means.");
            return this.displayMenu(m);
        }
    }

    private void printMenuItems(List<MenuItem> m) {
        int i = 1;
        for (MenuItem item : m) {
            if (item.getDescription() != null) {
                MessageQueue.add("[" + i + "]" + item.getCommand() + " - " + item.getDescription());
            } else {
                MessageQueue.add("[" + i + "]" + item.getCommand());
            }
            i++;
        }
    }
}