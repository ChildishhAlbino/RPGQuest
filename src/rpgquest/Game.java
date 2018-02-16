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

    private Scanner userInput = new Scanner(System.in);

    public Game() {

        player = new Player();
        map = new Map();

        
        // player.setName("Collette");
        while (player.GetPlayerCreated() == false) {
            CharacterCreation();
        }
        player.setName("Cyrus");
        while (playing) {
            System.out.println("Options: 1 = move");

            int command = userInput.nextInt();

            Move(command);

        }
    }

    private void Move(int command) {

        System.out.println("Move where?");

    }

    public void CharacterCreation() {
        System.out.println("Please enter a name");
        String userInput = this.userInput.nextLine();
        
        player.setPlayerCreated(3, true);
        player.setName((userInput));
    }
}
