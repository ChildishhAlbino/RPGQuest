/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgquest;


class Location {
   
    public static enum Direction{North, East, South, West};
    public static enum Consequence{Nothing, Lose, Win};
    private java.util.Map<Location, Direction> compass;
    
    private Consequence consequence;
    private String name;
    
    public Location(String name){
        this(name, Consequence.Nothing);
        compass = new java.util.HashMap<>();
    }
    
    public Location(String name, Consequence consequence){
        this.name = name;
        this.consequence = consequence;
    }
    
    public void setLinks(Location location, Direction direction){
        compass.put(location, direction);
    }
}
