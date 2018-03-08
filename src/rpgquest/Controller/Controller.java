package rpgquest.Controller;

import rpgquest.Model.Location.Direction;
import rpgquest.Model.Model;

public class Controller {

    private Model model;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void Start() {
       
    }
    
    public void ReceiveInput(int command){
        switch(command){
            case 1:
                model.ClarifyWithView();
                break;
        }
    }
    
    public void NotifyOfMove(Direction direction){
        model.Move(direction);
    }
}
