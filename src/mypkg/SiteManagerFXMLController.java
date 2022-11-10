/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SiteManagerFXMLController implements Initializable {

    @FXML
    private BorderPane siteManagerBP;
    @FXML
    private Button signOutButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ViewProfileAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("ViewProfileFXML.fxml"));
        siteManagerBP.setCenter(pane);
    }

    @FXML
    private void EditProfileAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("EditProfileFXML.fxml"));
        siteManagerBP.setCenter(pane);
    }

    @FXML
    private void ChangePasswordAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("ChangePasswordFXML.fxml"));
        siteManagerBP.setCenter(pane);
    }

    @FXML
    private void CreateOrderAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("CreateOrderFXML.fxml"));
        siteManagerBP.setCenter(pane);
    }
    
    @FXML
    private void signOutBtnAction(ActionEvent event){
        Stage stage = (Stage) signOutButton.getScene().getWindow();  
        stage.close();
    }
    
}
