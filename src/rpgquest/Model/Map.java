/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgquest.Model;

import rpgquest.Model.Player;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Connor
 */
public class Map implements Serializable{

    private List<Location> locations;
    private Location Start = new Location("Start");
    private Location Mountain = new Location("Mountain");
    private Location Canyon = new Location("Canyon", Location.Consequence.Lose);
    private Location Ravine = new Location("Ravine", Location.Consequence.Lose);
    private Location Slope = new Location("Slope", Location.Consequence.Win);
    private Location Kiosk = new Location("Kiosk");

    public Map() {
        locations = new ArrayList<>();
        locations.add(Start);
        locations.add(Mountain);
        locations.add(Canyon);
        locations.add(Ravine);
        locations.add(Slope);
        locations.add(Kiosk);
    }

    public void InitCompass() {
        Start.setLinks((Mountain), Location.Direction.East);
        Mountain.setLinks(Canyon, Location.Direction.North);
        Mountain.setLinks(Ravine, Location.Direction.South);
        Mountain.setLinks(Slope, Location.Direction.East);
        Mountain.setLinks(Start, Location.Direction.West);
        Canyon.setLinks(Mountain, Location.Direction.South);
        Ravine.setLinks(Mountain, Location.Direction.North);
        Slope.setLinks(Kiosk, Location.Direction.South);
        Kiosk.setLinks(Start, Location.Direction.West);
    }
    
    public List getMapList(){
        return locations;
    }
    
    

    public boolean MoveCharacter(Location.Direction direction, Player character) {
         // TODO: locate / identify character
         // look at current location
         Location currentLocation = character.getLocation();
         // check to see if we can move in the selected direction from said location
         Location destination = currentLocation.ReadCompass(direction);
         // if so, move,
         if(destination != null){
             System.out.println(destination.getName());
             currentLocation.exit(character);
             destination.enter(character);
             return true;
         }
         else{
             return false;
         }
         // else, do nothing (error)
    }
}
