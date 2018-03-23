package rpgquest.Model;

import rpgquest.Model.Location.Direction;
import rpgquest.View.ConsoleView;
import rpgquest.View.IView;

public class Model {

    private boolean playing = true;
    private Player player; // reference variable 
    private Map map;
    private IView view;
    
    private static Model instance;
    
    private Model() {
        map = new Map();
        map.InitCompass();
    }

    public void Start() {
        Location startLocation = (Location) map.getMapList().get(0);
        startLocation.enter(player);
    }

    public void Move(Direction direction) {
        if (getPlayer().getLocation().ReadCompass(direction) != null) {
            map.MoveCharacter(direction, getPlayer());
        }
        view.GetInput();
    }

    public IView getView() {
        return view;
    }

    public void setView(IView view) {
        this.view = view;
    }

    public void ClarifyWithView() {

        view.Update(getPlayer());
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * @return the instance
     */
    public static Model getInstance() {
        if(instance == null){
            instance = new Model();
        }
        return instance;
    }

}
