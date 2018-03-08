/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgquest.View;

import rpgquest.Controller.Controller;
import rpgquest.Model.Player;

public interface IView {

    void GetInput();

    void setController(Controller controller);

    void MoveWhere();

    void PrintLocations(Player player);

    Controller getController();

}
