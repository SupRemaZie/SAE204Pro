package com.example.sae204.Controller;

public class MdpController {

    public void onSubmitButtonClick(){
        Controller.GoToPage("MotDePasseOubliee2.fxml","Confirmation de l'envoi");
    }
    public void retour(){
        Controller.GoToPage("ConnexionPage.fxml","Page de Connexion");
    }
}
