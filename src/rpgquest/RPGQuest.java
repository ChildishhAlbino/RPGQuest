package rpgquest;

import rpgquest.Controller.Controller;
import rpgquest.Model.Model;
import rpgquest.View.ConsoleView;
import rpgquest.View.IView;

public class RPGQuest {

    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller();
        IView view = new ConsoleView();

        model.setView(view);
        controller.setModel(model);
        view.setController(controller);

        view.GetInput();
    }

}
