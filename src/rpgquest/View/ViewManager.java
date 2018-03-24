/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgquest.View;

import rpgquest.View.GUI.GUIView;

public class ViewManager<T extends IView> {
    private static IView instance;
    
    public void setInstance(T t){
        this.instance = t;
    }
    
    public ViewManager(T t){
        setInstance(t);
    }
    
    public static IView getInstance(){
        return instance;
    }
    
}
