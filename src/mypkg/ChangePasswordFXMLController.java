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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ChangePasswordFXMLController implements Initializable {

    @FXML
    private TextField oldPassTF;
    @FXML
    private TextField newPassTF;
    @FXML
    private Label passchangeLabel;
    
    String type, name;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        File f = new File("CurrentLogin.txt");
        Scanner s = null;
        String str = "";
        try {
            s = new Scanner(f);
            while(s.hasNext()){
                str+= s.nextLine();
            }
            String[] st = str.split(",");
            name = st[1];
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ChangePasswordFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void passChangeAction(ActionEvent event) throws FileNotFoundException, IOException {
        String oldP = oldPassTF.getText();
        String newP = newPassTF.getText();
        
        
        ChangePassword cpc = new ChangePassword(oldP, newP);
        
        File f = null;
        Scanner s = null;
        
        f = new File("PersonLogin.txt");
        s = new Scanner(f);
        String string = "";
        while(s.hasNext()){
            String str = s.nextLine();
            String[] st = str.split(",");
            System.out.println(st[0]);
            System.out.println(st[1]);
            if(st[0].equals(name)){
                if(st[1].equals(oldP))
                    str=st[0]+","+newP;
                else{
                    passchangeLabel.setText("Wrong old password! Please try again!");
                    return;
                }
            }
            string+=str+"\n";
        }
        if(f.delete()){
            //
        }
        f.createNewFile();
        FileWriter fw = new FileWriter (f);
        fw.write(string);
        fw.close();
        passchangeLabel.setText("Password change successful!");
        oldPassTF.clear();
        newPassTF.clear();
    }
    
}
