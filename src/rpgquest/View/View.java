/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgquest.View;

import rpgquest.Controller.Controller;
import rpgquest.Model.Player;

/**
 *
 * @author conno
 */
public abstract class View implements IView {

    public Controller controller;

    @Override
    public void GetInput() {
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Controller getController() {
        return controller;
    }

    @Override
    public void MoveWhere() {

    }

    public void PrintLocations(Player player){
        
    }
    
}
