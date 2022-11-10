/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SignUpFXMLController implements Initializable {

    @FXML
    private RadioButton SiteManRB;
    @FXML
    private RadioButton SupplierRB;
    @FXML
    private TextField fNameTF;
    @FXML
    private TextField lNameTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField phoneTF;
    @FXML
    private TextField usernameTF;
    @FXML
    private TextField passwordTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ToggleGroup group = new ToggleGroup();
        SiteManRB.setToggleGroup(group);
        SupplierRB.setToggleGroup(group);
    }    

    @FXML
    private void SignUpDoneAction(ActionEvent event) throws IOException {
        String desig;
        String fname = fNameTF.getText();
        String lname = lNameTF.getText();
        String email = emailTF.getText();
        String phone = phoneTF.getText();
        String username = usernameTF.getText();
        String password = passwordTF.getText();
        
        
        
        boolean username_exists = false;
        File file = new File("Usernames.txt");
        if(!file.exists()) file.createNewFile();
        Scanner s = new Scanner(file);
        while(s.hasNext()){
            String str = s.nextLine();
            if(str.equals(username)){
                username_exists = true;
                break;
            }
        }
        if(!username_exists){
            if(SiteManRB.isSelected()){
                desig = "SiteManager";
                SiteManager siteManager = new SiteManager(fname, lname, email, phone, username, password, desig);
                File f = new File("SiteManager.txt");
                if(!f.exists()) f.createNewFile();
                FileWriter fw = new FileWriter(f, true);
                fw.write(username+"#"+fname+"#"+lname+"#"+email+"#"+phone+"\n");
                fw.close();
            }
            else if(SupplierRB.isSelected()){
                desig = "Supplier";
                Supplier supplier = new Supplier(fname, lname, email, phone, username, password, desig);
                File f = new File("Supplier.txt");
                if(!f.exists()) f.createNewFile();
                FileWriter fw = new FileWriter(f, true);
                fw.write(username+"#"+fname+"#"+lname+"#"+email+"#"+phone+"\n");
                fw.close();
            }
            File f = new File("PersonLogin.txt");
            if(!f.exists()) f.createNewFile();
            FileWriter fw = new FileWriter(f, true);
            fw.write(username+","+password+"\n");
            fw.close();
            
            File fu = new File("Usernames.txt");
            if(!fu.exists()) fu.createNewFile();
            fw = new FileWriter(fu, true);
            fw.write(username+"\n");
            fw.close();
        }
        
        fNameTF.clear();
        lNameTF.clear();
        emailTF.clear();
        phoneTF.clear();
        usernameTF.clear();
        passwordTF.clear();
        
    }

    
    
}
