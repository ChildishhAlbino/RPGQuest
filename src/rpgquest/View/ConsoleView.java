package rpgquest.View;

import java.util.Scanner;
import rpgquest.Controller.Controller;
import rpgquest.Model.Location;
import rpgquest.Model.Player;

public class ConsoleView implements IView {

    private Scanner userInput = new Scanner(System.in);
    private Controller controller;

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

    public void PrintLocations(Location location) {

        for (int i = 0; i < Location.Direction.values().length; i++) {
            Location.Direction direction = Location.Direction.values()[i];
            Location currentLocation = location.ReadCompass(direction);
            if (currentLocation != null) {
                String output = currentLocation.getName();
                System.out.println(direction.toString() + ": " + output);
            }
        }
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
    public void Update(Player player) {
        System.out.println(controller.getModel().getPlayer().GetName());
        PrintLocations(player.getLocation());
        MoveWhere();
    }

    public void AskToRestore() {
        boolean asking = true;
        while (asking) {
            System.out.println("Do you want to restore from a previous session? ");
            String input = userInput.next();

            if ("yes".equals(input.toLowerCase())) {
                controller.DownloadPlayer();
                asking = false;
            } else if ("no".equals(input.toLowerCase())) {
                controller.NewPlayer();
                asking = false;
            } else {
                input = "";
            }
        }
    }

    public String AskName() {
        return userInput.next();
    }

}
