/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class MainFXMLController implements Initializable {

    @FXML
    private BorderPane mainBorderPane;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void EntryRuleBtnAction(ActionEvent event) throws IOException {
        
        Parent pane = FXMLLoader.load(getClass().getResource("EntryRuleFXML.fxml"));
        mainBorderPane.setCenter(pane);
    }

    @FXML
    private void ViewRideBtnAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("RidesFXML.fxml"));
        mainBorderPane.setCenter(pane);
    }

    @FXML
    private void ViewTourBtnAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("PackagesFXML.fxml"));
        mainBorderPane.setCenter(pane);
    }

    @FXML
    private void BookTicketBtnAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("BookTicketFXML.fxml"));
        
        Scene scene = new Scene(pane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void LocContBtnAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("ExtrasFXML.fxml"));
        mainBorderPane.setCenter(pane);
    }

    @FXML
    private void SignInBtnAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("SignInFXML.fxml"));
        mainBorderPane.setCenter(pane);
    }
    
}
