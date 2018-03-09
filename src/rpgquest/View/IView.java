/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgquest.View;

import rpgquest.Controller.Controller;

public interface IView {
    
    void GetInput();

    void setController(Controller controller);

    void MoveWhere();
    
    Controller getController();

}
