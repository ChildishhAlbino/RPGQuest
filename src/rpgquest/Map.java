/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgquest;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Connor
 */
class Map {
    private List<Location> locations;
    private Location Start = new Location("Start");
    private Location Mountain = new Location("Start");
    private Location Canyon = new Location("Start", Location.Consequence.Lose);
    private Location Ravine = new Location("Start", Location.Consequence.Lose);
    private Location Slope = new Location("Start", Location.Consequence.Win);
    private Location Kiosk = new Location("Start");
        
    public Map(){
        locations = new ArrayList<>();
        locations.add(Start);
        locations.add(Mountain);
        locations.add(Canyon);
        locations.add(Ravine);
        locations.add(Slope);
        locations.add(Kiosk);
        
    }
    
    public void InitCompass(){
       Start.setLinks((Mountain), Location.Direction.East);
       Mountain.setLinks(Canyon, Location.Direction.North);
       Mountain.setLinks(Ravine, Location.Direction.South);
       Mountain.setLinks(Slope, Location.Direction.East);
       Mountain.setLinks(Start, Location.Direction.West);
       Slope.setLinks(Kiosk, Location.Direction.South);
       Kiosk.setLinks(Start, Location.Direction.East);
    }
}
