package rpgquest.View;

import java.util.Scanner;
import rpgquest.Controller.Controller;
import rpgquest.Model.Location;
import rpgquest.Model.Player;

public class ConsoleView extends View {

    private Scanner userInput = new Scanner(System.in);

    @Override
    public void GetInput() {
        System.out.println("Options: 1 = move");
        int command = userInput.nextInt();
        controller.ReceiveInput(command);
    }

    @Override
    public void MoveWhere() {
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
            controller.NotifyOfMove(direction);
        } else {
            System.out.println("Wrong Input");
            GetInput();
        }
    }
    
    @Override
    public void PrintLocations(Player player) {

        for (int i = 0; i < Location.Direction.values().length; i++) {
            Location.Direction direction = Location.Direction.values()[i];
            Location currentLocation = player.getLocation().getCompass().get(direction);
            if (currentLocation != null) {
                String output = currentLocation.getName();
                System.out.println(direction.toString() + ": " + output);
            }
        }
    }

    public void CharacterCreation(Player player) {
        System.out.println("Please enter a name");
        String givenInput = this.userInput.nextLine();

        if (player.AuthorityCheck(10) == true) {
            player.setName((givenInput));
            player.SetPlayerCreated(true);
        }
    }
}
