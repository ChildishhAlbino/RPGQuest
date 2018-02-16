/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgquest;

/**
 *
 * @author Connor
 */
class Player {
    
    private String name;
    
    public Player(){
        
        
    }
    
    public void setName(String name){
        if(name == null){
            this.name = name;
        }
        else{
            System.out.println("Lols. I already have a name. My name is " + name);
        }    
    }
   
    public String GetName(){
        return this.name;
    }
}
