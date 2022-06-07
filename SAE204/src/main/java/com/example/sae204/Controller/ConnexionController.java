package com.example.sae204.Controller;

import com.example.sae204.EtudiantAPK;
import com.example.sae204.Modele.MyJDBC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;


public class ConnexionController {
    @FXML
    private TextField IDTextField;

    @FXML
    private TextField PasswordTextField;

    @FXML
    private Button connexionButton;
    @FXML
    private Label loginMessageLabel;



    public void onConnexionButtonClick(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {

         String EnterId=IDTextField.getText();
       String EnterPwd=PasswordTextField.getText();
        System.out.println(EnterId +"/"+ EnterPwd);
       if (EnterId=="") {
           loginMessageLabel.setText("Veuillez entrez un Identifiant");
       }
       if (EnterPwd==""){
           loginMessageLabel.setText("Veuillez entez un mot de passe ");
       }
        if(EnterId=="" && EnterPwd=="") {
           loginMessageLabel.setText("Veuillez entrez un identifiant et mot de passe ");
       }
        //System.out.println(" j'ai reussi les test !!!!!!!");

        EtudiantAPK.myjdbc.connect("root","");


        String query1="SELECT MDP_etu FROM ETUDIANT WHERE Num_etu='" + EnterId + "';" ;

        String result1= EtudiantAPK.myjdbc.executeReadQuery(query1);

        System.out.println(result1);
        if(EnterPwd==result1){
            GoToPage("EtudiantView.fxml");
        }
        loginMessageLabel.setText("Identifiant ou mot de passe invalide");
    }

    private void GoToPage(String s) throws IOException {
        Stage windows = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(EtudiantAPK.class.getResource(s));
        Scene scene = new Scene(fxmlLoader.load());
        windows.setScene(scene);
    }

}
