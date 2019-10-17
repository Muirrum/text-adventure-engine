package xyz.devosmium.games.textadventureengine.locations;

import xyz.devosmium.games.textadventureengine.util.Coordinate;

import java.util.ArrayList;

public class World {

    private AreaCollection areas;
    private LocationFactory locations;

    //Initialize the World
    public World() {
        areas = new AreaCollection();
        locations = new LocationFactory();

        //Example Areas for proof of concept. Area is Optional
        areas.addAreaObject(new Area("Castle", 1));
        areas.addAreaObject(new Area("Throne Room", 2));
        areas.addAreaObject(new Area("Jail", 3));

        //Example locations being added to Areas for proof of concept
        Coordinate coord = new Coordinate(1,1,1);
        Coordinate coord1 = new Coordinate(1,2,1);

        //Adding a location to an area by ID
        locations.addLocation(coord, "Room 1", "Knight chamber in castle over looking town",
                areas.searchAreaByID(1));
        //Adding a location to an area by Name
        locations.addLocation(coord1, "Room 2", "Cafeteria where everyone eats",
                areas.searchAreaByName("Castle"));
    }

    public World(int maxX, int minX, int maxY, int minY, int maxZ, int minZ) {
        
    }

}