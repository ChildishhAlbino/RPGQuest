package rpgquest.Model;

import rpgquest.Model.Location.Direction;
import rpgquest.View.IView;
import rpgquest.View.View;

public class Model {

    private boolean playing = true;
    private Player player; // reference variable 
    private Map map;
    private View view;

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
    public View getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(View view) {
        this.view = view;
    }

    public void ClarifyWithView() {
        view.PrintLocations(player);
        view.MoveWhere();
    }
}
