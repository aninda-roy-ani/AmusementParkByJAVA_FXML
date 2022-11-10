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
public class RidesFXMLController implements Initializable {

    @FXML
    private Label ridesLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        File file = new File("RidesView.txt");
        Scanner s;
        String rides = "";
        try {
            s = new Scanner(file);
            while(s.hasNextLine()){
            rides+=s.nextLine()+"\n";
            }
        //System.out.println(entryRule);
            ridesLabel.setText(rides);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EntryRuleFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
