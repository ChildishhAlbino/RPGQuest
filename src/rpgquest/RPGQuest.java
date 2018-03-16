package rpgquest;

import static javafx.application.Application.launch;
import rpgquest.Controller.Controller;
import rpgquest.Model.Model;
import rpgquest.View.ConsoleView;
import rpgquest.View.GUI.GUIView;
import rpgquest.View.IView;

public class RPGQuest {

    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller();
        IView view = new GUIView();

        model.setView(view);
        controller.setModel(model);
        view.setController(controller);
        
        if(view instanceof GUIView){
            GUIView guiView = (GUIView)view;
            guiView.InitGUI();
        }
        view.GetInput();
    }

}
