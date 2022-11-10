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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author User
 */
public class PackagesFXMLController implements Initializable {

    @FXML
    private Label packageLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        File file = new File("TourPackages.txt");
        Scanner s;
        String tours = "";
        try {
            s = new Scanner(file);
            while(s.hasNextLine()){
            tours+=s.nextLine()+"\n";
            }
        //System.out.println(entryRule);
            packageLabel.setText(tours);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EntryRuleFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
