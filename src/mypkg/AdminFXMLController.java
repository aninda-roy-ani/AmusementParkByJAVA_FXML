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
public class AdminFXMLController implements Initializable {

    @FXML
    private BorderPane adminBorderPane;
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
    private void EditEntryRuleBtnAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("EntryRulesEditorFXML.fxml"));
        adminBorderPane.setCenter(pane);
    }

    @FXML
    private void ViewRideBtnAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("RidesEditorFXML.fxml"));
        adminBorderPane.setCenter(pane);
    }

    @FXML
    private void ViewTourBtnAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("ToursEditorFXML.fxml"));
        adminBorderPane.setCenter(pane);
    }

    @FXML
    private void LocContBtnAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("LocContEditorFXML.fxml"));
        adminBorderPane.setCenter(pane);
    }

    @FXML
    private void SignOutBtnAction(ActionEvent event) {
        Stage stage = (Stage) signOutButton.getScene().getWindow();  
        stage.close();
    }
    
}
