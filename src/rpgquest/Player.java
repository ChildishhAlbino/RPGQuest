/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgquest;

class Player {

    private String name;
    private boolean playerCreated = false;

    public Player() {

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

    public void setPlayerCreated(int authorityLevel, boolean value) {
        if (authorityLevel > 3) {
            this.playerCreated = value;
        } else {
            System.out.println("You do not have the authority level to do this.");
        }
    }
}
