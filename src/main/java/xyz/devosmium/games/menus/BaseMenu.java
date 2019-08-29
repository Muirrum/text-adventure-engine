package xyz.devosmium.games.menus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        
    }
}