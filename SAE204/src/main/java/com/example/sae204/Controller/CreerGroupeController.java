package com.example.sae204.Controller;

import com.example.sae204.Modele.DAO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreerGroupeController extends Controller implements Initializable {
    private static String CurrentGroupeParent;
    private static String CurrentGroupe;
    public  static String Harpege;

    @FXML
    private Button AjouterEtudiantButton;
    @FXML
    private Label GroupeSelected;

    @FXML
    private TextField NomTextField;

    @FXML
    private Label ParentSelected;

    @FXML
    private Button ValiderButton;
    @FXML
    private Label adressemaillabel;
    @FXML
    private Label erreur;
    @FXML
    private ComboBox<String> listGroupe;
    @FXML
    private ComboBox<String> listGroupeEnfant;

    public void retour(ActionEvent event){
        GoToPage("SecretaireAcc.fxml", "Accueil");
    }


    public void onValiderButtonClick(ActionEvent event) {

        if (GroupeSelected.getText().equals("") && !NomTextField.getText().equals("")){
            erreur.setText("");
            System.out.println(ParentSelected.toString());

        }
        else if(!(GroupeSelected.getText().equals("") && ParentSelected.getText().equals("")&& NomTextField.getText().equals(""))){
            erreur.setText("");
            System.out.println(GroupeSelected);
        }
        else {
            erreur.setText("Nom du groupe ou groupe vide");
        }




    }

    public void onAjouterEtudiantButtonClick(ActionEvent event) {
        AjouterEtuController.Harpege = Harpege;
        GoToPage("AjouterEtu.fxml","Ajouter les étudiants au nouveau groupe");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String mail ="";
        try {
            mail = DAO.mail(Harpege);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        adressemaillabel.setText(mail);

        try {
            ChampGroupeParent();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    void ChampGroupeParent () throws SQLException, ClassNotFoundException {
        listGroupe.getItems().addAll(DAO.ListGrpParent());

        listGroupe.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                CurrentGroupeParent = listGroupe.getSelectionModel().getSelectedItem();

                listGroupeEnfant.getItems().clear();
                DAO.listGrpAffilGrpParents.clear();

                try {
                    listGroupeEnfant.getItems().addAll(DAO.ListGrpAffilGrpParent(CurrentGroupeParent));
                    listGroupeEnfant.getItems().add("VIDE");
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                listGroupeEnfant.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                        CurrentGroupe = listGroupeEnfant.getSelectionModel().getSelectedItem();
                    }
                });
            }
        });
    }
}
