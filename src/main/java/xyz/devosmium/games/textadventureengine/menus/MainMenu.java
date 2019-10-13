package xyz.devosmium.games.textadventureengine.menus;

import xyz.devosmium.games.textadventureengine.locations.World;
import xyz.devosmium.games.textadventureengine.util.MessageQueue;

public class MainMenu extends BaseMenu implements Runnable {

  public MainMenu() {
    World world = new World();
    start();
  }

  public void run() {
    start();
  }

  public void start() {
    // Add items
    menuItems.add(new MenuItem("Start", "Start new game"));
    menuItems.add(new MenuItem("Load", "Loads an existing Game"));
    menuItems.add(new MenuItem("Exit", null));

    boolean continuing = true;
    do {
      MenuItem selectedItem = displayMenu(menuItems);
      continuing = testOption(selectedItem);
    } while (continuing);
    System.exit(0);
  }

  private static boolean testOption(MenuItem m) {
    String key = m.getCmdKey();
    switch (key) {
    case "start":
      new ClassMenu();
    case "load":
      MessageQueue.add("Cannot load. Please check back later.");
    case "exit":
      MessageQueue.add("Exiting...");
      return false;
    }
    return true;
  }
}