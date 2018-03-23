package rpgquest.Controller;

import rpgquest.Database.DBManager;
import rpgquest.Model.Location.Direction;
import rpgquest.Model.Model;
import rpgquest.Model.Player;
import rpgquest.View.ConsoleView;

public class Controller {

    private Model model;
    private DBManager dbm;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void Start() {
        dbm = new DBManager();
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

    public boolean DownloadPlayer() {
        Player player;
        player = (dbm.RetrievePlayer(3));
        if (player == null) {
            return false;
        }
        
        model.setPlayer(player);
        return true;
    }

    public void NewPlayer() {
        if (model.getView() instanceof ConsoleView) {
            ConsoleView cView = (ConsoleView) model.getView();
            model.setPlayer(new Player(cView.AskName()));
        }
    }
}
