package rpgquest.View.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import rpgquest.Controller.Controller;
import rpgquest.Database.DBManager;
import rpgquest.Model.Model;

public class GUIPane extends AnchorPane {

    private Controller controller;

    @FXML
    private void initialize() {
        controller = Controller.getInstance();
    }
    @FXML
    private TextField loginBox;
    @FXML
    private Text actiontarget;
    @FXML
    private PasswordField pWordBox;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("Logging in. Please wait");
        System.out.println(loginBox.getText());
        if (!"".equals(loginBox.getText()) && !"".equals(pWordBox.getText())) {

            DBManager dbm = DBManager.GetInstance();
            int playerID = dbm.AttemptToLogon(loginBox.getText(), pWordBox.getText());
            if (playerID == -1) {
                actiontarget.setText("Incorrect Login");

            } else {
                controller.setPlayerID(playerID);
                controller.DownloadPlayer(playerID);
                actiontarget.setText("Logged in as: " + controller.getModel().getPlayer().GetName());
            }
        } else {
            actiontarget.setText("Please enter login data");
        }

    }

    @FXML
    protected void handleSignUpButtonAction(ActionEvent event) {
        if (!"".equals(loginBox.getText()) && !"".equals(pWordBox.getText())) {

            DBManager dbm = DBManager.GetInstance();
            int playerID = dbm.AttemptToLogon(loginBox.getText(), pWordBox.getText());
            if (playerID != -1) {
                actiontarget.setText("User already found. Please enter new details.");
            } else {
                Model model = Model.getInstance();
                controller.NewPlayer();
                dbm.AddPlayer(model.getPlayer());
                playerID = dbm.GetPlayerIDByName(model.getPlayer().GetName());
                if(playerID != -1){
                    dbm.AddUser(loginBox.getText(), pWordBox.getText(), playerID);
                    return;
                }
                else{
                    System.out.println("Error: Could not find player.");
                }
            }
        } else {
            actiontarget.setText("Please enter login data");
        }
    }
    
   
}
