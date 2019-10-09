package xyz.devosmium.games.textadventureengine.items;

/**
 * Defines an item in the world
 */
public class Item {
    
    private String name;
    public String getName() { return name; }

    private String description;
    public String getDesc() { return description; }

    private int value;
    public int getValue() { return value; }
    public void setValue(int newValue) {
        value = newValue;
    }

    private int damage;
    public int getDamage() { return damage; }

    private int defense;
    public int getDefense() { return defense; }


/**
 * Creates a new item
 * @param name The name of the item
 * @param description The "look" text for the item
 * @param value The value, in currency, of the item
 * @param damage The damage the item deals
 * @param defense The amount of protection the item provides
 */
    public Item(String name, String description, int value, int damage, int defense) {
        this.name = name;
        this.description = description;
        this.value = value;
        this.damage = damage;
        this.defense = defense;
    }



}