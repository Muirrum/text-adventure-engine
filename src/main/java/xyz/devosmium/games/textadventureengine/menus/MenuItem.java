package xyz.devosmium.games.textadventureengine.menus;

public class MenuItem {

  protected String command;
  protected String description;

  public MenuItem(String command, String description) {
    this.command = command;
    this.description = description;
  }

  public String getCommand() {
    return command;
  }

  public void setCommand(String command) {
    this.command = command;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCmdKey() {
    return getCommand().toLowerCase();
  }
}