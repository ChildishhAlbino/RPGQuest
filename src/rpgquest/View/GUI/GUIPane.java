/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgquest.View.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 *
 * @author Connor
 */
public class GUIPane extends AnchorPane {

    private int i = 0;

    @FXML
    private void initialize() {
    }

    @FXML
    private Text actiontarget;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        i++;
        if (i == 1) {
            actiontarget.setText("Sign in button pressed");
        } else {

        }
    }

}
