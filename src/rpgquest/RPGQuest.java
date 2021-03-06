package rpgquest;

import rpgquest.Controller.Controller;
import rpgquest.Database.DBManager;
import rpgquest.Model.Model;
import rpgquest.View.ConsoleView;
import rpgquest.View.GUI.GUIView;
import rpgquest.View.*;

public class RPGQuest {

    public static void main(String[] args) {
        ViewManager<GUIView> vm = new ViewManager<>(new GUIView());
        
        Model model = Model.getInstance();
        Controller controller = Controller.getInstance();
        IView view = ViewManager.getInstance();
        
        DBManager dbm = DBManager.GetInstance();
        
        model.setView(view);
        controller.setModel(model);
        view.setController(controller);
        
        controller.Start();
        dbm.QueryDB();

        if (view instanceof GUIView) {
            GUIView guiView = (GUIView) view;
            guiView.InitGUI();
        } else {
            ConsoleView cView = (ConsoleView) view;
            cView.AskToRestore();
            model.Start();
        }

        view.GetInput();
    }

}
