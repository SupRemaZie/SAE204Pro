package com.example.sae204.Controller;

import com.example.sae204.Modele.DAO.DAO;
import com.example.sae204.Modele.DAO.DAOGroupe;
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
    public static String CurrentGroupeParent;
    private static String CurrentGroupe;
    public static String Harpege;


    @FXML
    public TextField NomTextField;

    public static String groupeParent;

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

    public void retour(ActionEvent event) {

        listGroupe.getSelectionModel().select("AUCUN");


        GoToPage("SecretaireAcc.fxml", "Accueil");
    }


    public void onValiderButtonClick(ActionEvent event) {



            if (verif() == 1) {
                erreur.setText("Veuillez entrez un Nom de groupe ou un groupe parent");
            }


             if (verif() == 0) {
                erreur.setText("");
                groupeParent = String.valueOf(listGroupe.getValue());
                PopUpValiderController.nomGroupe = NomTextField.getText();
                PopUpValiderController.nomGroupeParent = groupeParent;
                AjouterEtuController.NouveauGroupe1 = NomTextField.getText();
                GoToPage("PopUpValider.fxml", "Verification Saisis");
            } else if(verif()==2) {
                erreur.setText("");
                groupeParent = String.valueOf(listGroupeEnfant.getValue());
                PopUpValiderController.nomGroupe = NomTextField.getText();
                PopUpValiderController.nomGroupeParent = groupeParent;
                PopUpValiderController.Harpege = Harpege;
                AjouterEtuController.NouveauGroupe1 = NomTextField.getText();
                GoToPage("PopUpValider.fxml", "Verification Saisis");
            }




    }
    public int verif(){

        if(!(NomTextField.getText().equals(""))&&!(listGroupe.getValue()==null|| listGroupe.getValue().equals("AUCUN"))&&(listGroupeEnfant.getValue()==null|| listGroupeEnfant.getValue().equals("AUCUN"))){
            System.out.println(" colonne de gauche");
            return 0;

        }
        else if(!(NomTextField.getText().equals(""))&&!(listGroupe.getValue()==null|| listGroupe.getValue().equals("AUCUN"))&&!(listGroupeEnfant.getValue()==null|| listGroupeEnfant.getValue().equals("AUCUN"))){
            System.out.println("colonne de droite ");
            return 2;
        }


            return 1;
    }

    public void onAjouterEtudiantButtonClick(ActionEvent event) {
        String groupeParent="";

        if (verif() == 1) {
            erreur.setText("Nom textfield ou groupe non selectionné");
        }

        else if (verif() == 0) {
            erreur.setText("");
            groupeParent = String.valueOf(listGroupe.getValue());
            AjouterEtuController.CurrentGroupeParent1 = groupeParent;
            AjouterEtuController.NouveauGroupe1 = NomTextField.getText();
            AjouterEtuController.Harpege = Harpege;
            GoToPage("AjouterEtu.fxml", "Ajouter les étudiants au nouveau groupe");
        }
        else if (verif()==2){
            erreur.setText("");
            groupeParent = String.valueOf(listGroupeEnfant.getValue());
            AjouterEtuController.CurrentGroupeParent1 = groupeParent;
            AjouterEtuController.NouveauGroupe1 = NomTextField.getText();
            AjouterEtuController.Harpege = Harpege;
            GoToPage("AjouterEtu.fxml", "Ajouter les étudiants au nouveau groupe");
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        NomTextField.setText(AjouterEtuController.NouveauGroupe1); // sauvegarde du nom
        listGroupe.getSelectionModel().select(CurrentGroupeParent); // sauvegarde du groupe





        String mail = "";
        try {
            mail = DAO.mail(Harpege);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        adressemaillabel.setText(mail);
        listGroupeEnfant.getItems().clear();
        DAO.listGrpAffilGrpParents.clear();
        try {
            listGroupeEnfant.getItems().addAll(DAOGroupe.ListGrpAffilGrpParent(CurrentGroupeParent));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        listGroupeEnfant.getItems().add("AUCUN");
        try {
            ChampGroupeParent();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    void ChampGroupeParent() throws SQLException, ClassNotFoundException {
        listGroupe.getItems().addAll(DAOGroupe.ListGrpParent());

        listGroupe.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

                    CurrentGroupeParent = listGroupe.getSelectionModel().getSelectedItem();
                    System.out.println("Parent "+CurrentGroupeParent);



                listGroupeEnfant.getItems().clear();
                DAO.listGrpAffilGrpParents.clear();

                try {
                    listGroupeEnfant.getItems().addAll(DAOGroupe.ListGrpAffilGrpParent(CurrentGroupeParent));

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                listGroupeEnfant.getItems().add("AUCUN");


            }
        });
    }
}