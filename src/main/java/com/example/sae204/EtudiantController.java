package com.example.sae204;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class EtudiantController<detailProfil> {
    @FXML
    private Button tEleve1Button;
    @FXML
    private Button tEleve2Button;
    @FXML
    private Button tEleve3Button;
    @FXML
    private Button tEleve4Button;
    @FXML
    private Button tEleve5Button;
    @FXML
    private Button tEleve6Button;
    @FXML
    private Label detailProfil;

@FXML
    void ontEleve1ButtonClick(ActionEvent event){
       changeText(tEleve1Button);

    }
    @FXML
    void ontEleve2ButtonClick(ActionEvent event){
        changeText(tEleve2Button);

    }
    @FXML
    void ontEleve3ButtonClick(ActionEvent event){
        changeText(tEleve3Button);

    }
    @FXML
    void ontEleve4ButtonClick(ActionEvent event){
        changeText(tEleve4Button);
    }
    @FXML
    void ontEleve5ButtonClick(ActionEvent event){
        changeText(tEleve5Button);
    }
    @FXML
    void ontEleve6ButtonClick(ActionEvent event){
        changeText(tEleve6Button);
    }


    void changeText(Button textfrom ){
        detailProfil.setText(textfrom.getText());
    }
}
