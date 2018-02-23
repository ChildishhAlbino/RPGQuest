/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgquest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author Connor
 */
public class Game {

    private boolean playing = true;
    private Player player; // reference variable 
    private Map map;

    private Scanner userInput = new Scanner(System.in);

    public Game() {

        player = new Player();
        map = new Map();
        while (player.GetPlayerCreated() == false) {
            CharacterCreation();
        }
        map.InitCompass();
        Location startLocation = (Location)map.getMapList().get(0);
        startLocation.enter(player);
        while (playing) {
            System.out.println("Options: 1 = move");

            int command = userInput.nextInt();
            Move();
        }
    }

    private void Move() {

        System.out.println("Move where? 1 = North, 2 = East...");
        int option = userInput.nextInt();
        Location.Direction direction;
        switch (option) {
            case 1:
                direction = Location.Direction.North;
                break;
            case 2:
                direction = Location.Direction.East;
                break;
            case 3:
                direction = Location.Direction.South;
                break;
            case 4:
                direction = Location.Direction.West;
                break;
            default:
                System.out.println("That's not a valid direction");
                direction = null;
        }
        if (direction != null) {
            if(map.MoveCharacter(direction, player)){
                System.out.println("Player moved");
                System.out.println(player.getLocation());
            }
            
        }
    }

    public void CharacterCreation() {
        System.out.println("Please enter a name");
        String userInput = this.userInput.nextLine();

        if (player.AuthorityCheck(10) == true) {
            player.setName((userInput));
            player.SetPlayerCreated(true);
        }
    }

    public void SaveMap(Map map) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("default.map");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(map);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Serialization failed. " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("");
        } catch (Exception ex) {
            System.out.println("Some other error. " + ex.getMessage());
        }
    }

    public void LoadMap() {
        try {
            FileInputStream fileInputStream = new FileInputStream("default.map");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            map = (Map)objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Serialization failed. " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Input Output error. " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Couldn't find class " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Some other error. " + ex.getMessage());
        }
    }
}
