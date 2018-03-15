package rpgquest.Model;

import rpgquest.Model.Location.Direction;
import rpgquest.View.ConsoleView;
import rpgquest.View.IView;

public class Model {

    private boolean playing = true;
    private Player player; // reference variable 
    private Map map;
    private IView view;

    public Model() {
        player = new Player();
        map = new Map();
        map.InitCompass();
        Location startLocation = (Location) map.getMapList().get(0);
        startLocation.enter(player);
    }

    public void Move(Direction direction) {
        if (player.getLocation().ReadCompass(direction) != null) {
            map.MoveCharacter(direction, player);
        }
        view.GetInput();
    }

    /**
     * @return the view
     */
    public IView getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(IView view) {
        this.view = view;
    }

    public void ClarifyWithView() {
        if (view instanceof ConsoleView) {
            ConsoleView cView = (ConsoleView) view;
            cView.PrintLocations(player);
            cView.MoveWhere();
        }

    }
}
