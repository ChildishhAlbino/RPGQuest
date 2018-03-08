package rpgquest;

import rpgquest.Controller.Controller;
import rpgquest.Model.Model;
import rpgquest.View.ConsoleView;
import rpgquest.View.View;
public class RPGQuest {
    
    private static Model model;
    
    public static void main(String[] args) {
        // TODO code application logic here
        Model model = new Model();
        Controller controller = new Controller();
        View view = new ConsoleView();
        
        model.setView(view);
        controller.setModel(model);
        view.setController(controller);
        
        view.GetInput();
        
    }

    
  
    
}
