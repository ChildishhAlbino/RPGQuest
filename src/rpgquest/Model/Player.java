/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgquest.Model;

import rpgquest.View.ConsoleView;

public class Player {

    private String name;
    private boolean playerCreated = false;
    private Location location;

    public Player(String name) {
        setName(name);
    }
   
    public void setName(String name) {
        if (this.name == null) {
            this.name = name;
        } else {
            System.out.println("Lols. I already have a name. My name is " + this.name);
        }
    }

    public String GetName() {
        return this.name;
    }

    public boolean GetPlayerCreated() {
        return playerCreated;
    }
    
    public void SetPlayerCreated(boolean value){
        this.playerCreated = value;
    }

    public Location getLocation() {
           return this.location;
    }
    
    public void setLocation(Location location){
        this.location = location;
    }
}
