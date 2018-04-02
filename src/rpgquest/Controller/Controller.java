package rpgquest.Controller;

import javafx.beans.property.StringProperty;
import rpgquest.Database.DBManager;
import rpgquest.Model.Location.Direction;
import rpgquest.Model.Model;
import rpgquest.Model.Player;
import rpgquest.View.ConsoleView;

public class Controller {

    private Model model;
    private DBManager dbm;
    private static Controller instance;
    private int playerID;
    private Controller() {

    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void Start() {
        dbm = DBManager.GetInstance();
    }

    public void ReceiveInput(int command) {
        switch (command) {
            case 1:
                model.ClarifyWithView();
                break;
        }
    }

    public void NotifyOfMove(Direction direction) {
        model.Move(direction);
    }

    public boolean DownloadPlayer(int id) {
        Player player;
        player = (dbm.RetrievePlayer(id));
        if (player == null) {
            return false;
        }

        model.setPlayer(player);
        return true;
    }

    public void NewPlayer() {
        String name = null;
        if (model.getView() instanceof ConsoleView) {
            ConsoleView cView = (ConsoleView) model.getView();
            name = cView.AskName();
        }
        else{
           name = "Aaron";
        }
        model.setPlayer(new Player(name));
        
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void setPlayerID(int id) {
       this.playerID = id;
    }
    
    public int getPlayerID(){
        return playerID;
    }
}
