/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ViewProfileFXMLController implements Initializable {

    @FXML
    private Label fNameLabel;
    @FXML
    private Label lNameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label phoneLabel;

    String userType, username;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        File f = new File("CurrentLogin.txt");
        
        Scanner s = null; 
        try {
            s = new Scanner(f);
            String str = "";
            while(s.hasNext()){
                str+=s.nextLine();
            }
            String[] st = str.split(",");
            userType = st[0];
            username = st[1];
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewProfileFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(userType.equals("SiteManager"))
            f = new File("SiteManager.txt");
        if(userType.equals("Supplier"))
            f = new File("Supplier.txt");
        try {
            s = new Scanner(f);
            while(s.hasNext()){
                String str = s.nextLine();
                String[] st = str.split("#");
                if(st[0].equals(username)){
                    fNameLabel.setText(st[1]);
                    lNameLabel.setText(st[2]);
                    emailLabel.setText(st[3]);
                    phoneLabel.setText(st[4]);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewProfileFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    
    
    
}
