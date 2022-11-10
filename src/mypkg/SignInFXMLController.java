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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.lang.model.element.Element;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SignInFXMLController implements Initializable {

    @FXML
    private TextField usernameTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private Label wrongLabel;
    @FXML
    private ComboBox<String> SignInAsCb;
    
    ObservableList<String> signInType = FXCollections.observableArrayList("Admin", "SiteManager", "Supplier");
    
    Person person = null;
    
    String username, password, userType;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        SignInAsCb.setValue("Admin");
        SignInAsCb.setItems(signInType);
    }    

    @FXML
    private void SignInBtnAction(ActionEvent event) throws FileNotFoundException, IOException {
        boolean checker = false;
        username = usernameTF.getText();
        password = passwordTF.getText();
        userType = SignInAsCb.getValue();
        person = new Person(username, password, userType);
        File f = new File("PersonLogin.txt");
        if(!f.exists()) f.createNewFile();
        Scanner s = new Scanner(f);
        while(s.hasNext()){
            String str = s.nextLine();
            String[] st = str.split(",");
            if(st[0].equals(username)){
                if(st[1].equals(password)){
                    checker = true;
                    break;
                }
            }
        }
        
        if(checker == false)
            wrongLabel.setText("Username or Password Incorrect!");
        else{
            File file = new File("CurrentLogin.txt");
            if(!file.exists()) file.createNewFile();
            
            FileWriter fw = new FileWriter(file);
            String string = userType+","+username+"\n";
            fw.write(string);
            fw.close();
            
            Parent pane = null;
            if(userType.equals("SiteManager"))
                pane = FXMLLoader.load(getClass().getResource("SiteManagerFXML.fxml"));
            else if(userType.equals("Supplier"))
                pane = FXMLLoader.load(getClass().getResource("SupplierFXML.fxml"));
            else
                pane = FXMLLoader.load(getClass().getResource("AdminFXML.fxml"));
        
            Scene scene = new Scene(pane);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
        
        usernameTF.clear();
        passwordTF.clear();
    }

    @FXML
    private void SignUpBtnAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("SignUpFXML.fxml"));
        
        Scene scene = new Scene(pane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    

    @FXML
    private void MouseEntered(MouseEvent event) {
        wrongLabel.setText("");
    }
    
    
}
