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
public class EditProfileFXMLController implements Initializable {

    @FXML
    private TextField fNameTF;
    @FXML
    private TextField lNameTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField phoneTF;
    @FXML
    private Label savingLavel;

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
        else if(userType.equals("Supplier"))
            f = new File("Supplier.txt");
        try {
            s = new Scanner(f);
            while(s.hasNext()){
                String str = s.nextLine();
                String[] st = str.split("#");
                if(st[0].equals(username)){
                    fNameTF.setText(st[1]);
                    lNameTF.setText(st[2]);
                    emailTF.setText(st[3]);
                    phoneTF.setText(st[4]);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewProfileFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void SaveEditedAction(ActionEvent event) throws FileNotFoundException, IOException {
        String fname = fNameTF.getText();
        String lname = lNameTF.getText();
        String email = emailTF.getText();
        String phone = phoneTF.getText();
        
        EditedTempClass etc = new EditedTempClass(fname, lname, email, phone);
        
        File f = null;
        Scanner s = null;
        if(userType.equals("SiteManager"))
            f = new File("SiteManager.txt");
        if(userType.equals("Supplier"))
            f = new File("Supplier.txt");
        
        s = new Scanner(f);
        String string = "";
        while(s.hasNext()){
            String str = s.nextLine();
            String[] st = str.split("#");
            if(st[0].equals(username))
                str=st[0]+"#"+fname+"#"+lname+"#"+email+"#"+phone;
            string+=str+"\n";
        }
        if(f.delete()){
            //
        }
        f.createNewFile();
        FileWriter fw = new FileWriter (f);
        fw.write(string);
        fw.close();
        savingLavel.setText("Saved! Click 'View Profile' to check!");
        fNameTF.clear();
        lNameTF.clear();
        emailTF.clear();
        phoneTF.clear();
    }
    
}
