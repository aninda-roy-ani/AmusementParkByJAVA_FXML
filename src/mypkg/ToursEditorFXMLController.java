/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ToursEditorFXMLController implements Initializable {

    @FXML
    private TextArea txtEditor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        File f = new File("TourPackages.txt");
        Scanner s = null;
        String str = "";
        try {
            s = new Scanner(f);
            while(s.hasNext()){
                str+= s.nextLine()+"\n";
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EntryRulesEditorFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtEditor.setText(str);
    }    

    @FXML
    private void saveTextBtnAction(ActionEvent event) throws IOException {
        String str = txtEditor.getText();
        StringClass string = new StringClass(str);
        
        File f = new File("TourPackages.txt");
        if(f.delete()){
            //
        }
        FileWriter fw = new FileWriter(f);
        fw.write(string.getString());
        fw.close();
        txtEditor.clear();
    }
    
}
