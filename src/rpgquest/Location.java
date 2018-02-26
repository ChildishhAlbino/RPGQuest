/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgquest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Location implements Serializable {

    public static enum Direction {
        North, East, South, West
    };
    private transient List<Player> players;

    public static enum Consequence {
        Nothing, Lose, Win
    };

    private java.util.Map<Direction, Location> compass;
    private Consequence consequence;
    private String name;

    public Location(String name) {
        this(name, Consequence.Nothing);
    }

    public Location(String name, Consequence consequence) {
        this.consequence = consequence;
        this.name = name;
        compass = new java.util.HashMap<>();
        players = new ArrayList<>();
    }

    public void setLinks(Location location, Direction direction) {
        if (location == null) {
            System.out.println("Location null");
        }
        if (direction == null) {
            System.out.println("direction null");
        }
        compass.put(direction, location);
    }

    public void enter(Player player) {
        player.setLocation((this));
        this.players.add(player);
    }

    public void exit(Player player) {
        this.players.remove(player);
    }

    public Location ReadCompass(Direction direction) {
        return compass.get(direction);
    }
    
    public String getName(){
        return this.name;
    }
    
    public java.util.Map<Direction, Location> getCompass(){
        return compass;
    }
}
