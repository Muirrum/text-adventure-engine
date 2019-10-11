package xyz.devosmium.games.textadventureengine.items;

import java.util.ArrayList;

public class Inventory {
    
    private ArrayList<Item> contents;
    public ArrayList<Item> getContents() { return contents; }
    public void addItem(Item item) { contents.add(item); }

    public Inventory() {
        contents = new ArrayList<Item>();
    }   

}