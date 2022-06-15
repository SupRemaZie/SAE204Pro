package com.example.sae204.Controller;

import com.example.sae204.Modele.DAO.DAO;
import com.example.sae204.Modele.DAO.DAOGroupe;
import com.example.sae204.Modele.Etudiant;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ModifierGroupeController extends Controller implements Initializable {
    public static String ancienNom;

    @FXML
    private Button AjouterEtudiant;

    @FXML
    private ListView<Etudiant> CurrentGroupeListV;

    @FXML
    private Label GroupeLabel;

    @FXML
    private ListView<Etudiant> NewGroupeListV;

    @FXML
    private TextField NomDeGrpTextField;

    @FXML
    private Button RemoveALLButton;

    @FXML
    private Button RemoveButton;

    @FXML
    private Button ValiderButton;

    @FXML
    private Label adressemaillabel;

    @FXML
    private Button retour;

    @FXML
    void onAjouterEtudiantClick(ActionEvent event) {
        Etudiant etuSelect = CurrentGroupeListV.getSelectionModel().getSelectedItem();
        NewGroupeListV.getItems().addAll(etuSelect);
    }

    @FXML
    void onRemoveALLButtonClick(ActionEvent event) {
        NewGroupeListV.getItems().clear();
    }

    @FXML
    void onRemoveButtonClick(ActionEvent event) {
        Etudiant etuSelect = NewGroupeListV.getSelectionModel().getSelectedItem();
        NewGroupeListV.getItems().remove(etuSelect);
    }

    @FXML
    void onValiderButtonClick(ActionEvent event) {
       if(!NomDeGrpTextField.getText().equals("")) {
           GoToPage("SecretaireAcc.fxml","Accueil Secretaire");
       }

    }

    public void retour(ActionEvent event){
        GoToPage("SecretaireAcc.fxml","Acceuil Secrétaire");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ancienNom=SecretaireAccController.GroupeSupprimer;
        NomDeGrpTextField.setText(SecretaireAccController.GroupeSupprimer);
        System.out.println("Supprimer secrétaire "+ SecretaireAccController.GroupeSupprimer);

        try {

            GroupeLabel.setText(DAOGroupe.getGroupeParent(NomDeGrpTextField.getText()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            NewGroupeListV.getItems().setAll(chercherEtuGroupePromo(NomDeGrpTextField.getText()));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String mail = "";
        try {
            mail = DAO.mail(ConnexionController.Harpege);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        adressemaillabel.setText(mail);
        try {
            CurrentGroupeListV.getItems().setAll(chercherEtuGroupePromo(GroupeLabel.getText()));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}

