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
public class EntryRuleFXMLController implements Initializable {

    @FXML
    private Label entryRuleLabel;
    
    String entryRule = "";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        File file = new File("EntryRule.txt");
        Scanner s;
        try {
            s = new Scanner(file);
            while(s.hasNextLine()){
            entryRule+=s.nextLine()+"\n";
            }
        //System.out.println(entryRule);
            entryRuleLabel.setText(entryRule);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EntryRuleFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

   
}
