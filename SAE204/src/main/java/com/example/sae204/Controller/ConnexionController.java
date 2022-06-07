package com.example.sae204.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ConnexionController {
    @FXML
    private TextField IDTextField;

    @FXML
    private TextField PasswordTextField;

    @FXML
    private Button connexionButton;
    @FXML
    private Label loginMessageLabel;



    public void onConnexionButtonClick(ActionEvent event) {
    loginMessageLabel.setText("You try to login");

    }
}
