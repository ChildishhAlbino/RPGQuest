/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgquest;

import java.util.Scanner;

/**
 *
 * @author Connor
 */
public class Game {
    private boolean playing = true;
    private Player player;
    private Map map;
    
    public Game(){
        
        player = new Player();
        map = new Map();
        
        while(playing){
            System.out.println("Options: 1 = move");
            Scanner userInput = new Scanner(System.in);
            
           int command = userInput.nextInt();
           
           Move(command);
                   
        }
    }

    private void Move(int command) {
       
        System.out.println("Move where?");
        
    }
    
}

