package rpgquest;

import rpgquest.Controller.Controller;
import rpgquest.Database.DBManager;
import rpgquest.Model.Model;
import rpgquest.View.ConsoleView;
import rpgquest.View.GUI.GUIView;
import rpgquest.View.IView;

public class RPGQuest {

    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller();
        IView view = new ConsoleView();
        DBManager dbm = new DBManager();

        model.setView(view);
        controller.setModel(model);
        view.setController(controller);
        dbm.QueryDB();

        controller.Start();
        if (view instanceof GUIView) {
            GUIView guiView = (GUIView) view;
            guiView.InitGUI();
        } else {
            ConsoleView cView = (ConsoleView) view;
            cView.AskToRestore();
        }

        model.Start();
        view.GetInput();
    }

}
