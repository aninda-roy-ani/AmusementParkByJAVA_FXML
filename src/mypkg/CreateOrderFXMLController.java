/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author User
 */
public class CreateOrderFXMLController implements Initializable {

    @FXML
    private ComboBox<String> supplierCB;
    @FXML
    private TextField prodIDTF;
    @FXML
    private TextField prodNameTF;
    @FXML
    private TextField noProdTF;
    @FXML
    private CheckBox addMoreProdChB;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Label orderConfirmLabel;
    
    String name;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        File f = new File("Supplier.txt");
        Scanner s = null;
        try {
            s = new Scanner(f);
            
            while(s.hasNext()){
                String str = s.nextLine();
                String[] st = str.split("#");
                //supplierCB.setValue(st[0]);
                supplierCB.getItems().add(st[0]);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CreateOrderFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        f = new File("CurrentLogin.txt");
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
    private void saveBtnAction(ActionEvent event) throws IOException {
        String suppID = supplierCB.getValue();
        String date = datePicker.getValue().toString();
        String prId = prodIDTF.getText();
        String prName = prodNameTF.getText();
        String prNum = noProdTF.getText();
        Product prod = new ProductAdd(prId, prName, prNum, date, suppID);
        
        File f = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        DataOutputStream dos = null;
        
        
        f = new File("Product.bin");
        if(f.exists()) fos = new FileOutputStream(f,true);
        else fos = new FileOutputStream(f);

        bos = new BufferedOutputStream(fos);
        dos = new DataOutputStream(bos);
        
        dos.writeUTF(suppID);
        dos.writeUTF(prId);
        dos.writeUTF(prName);
        dos.writeUTF(prNum);
        dos.writeUTF(date);
        dos.writeUTF(name);
        if(dos!=null) dos.close();
        if(!addMoreProdChB.isSelected()){
            orderConfirmLabel.setText("Order sent to the supplier. Thanks!");
            datePicker.setValue(null);
        }
        prodIDTF.clear();
        prodNameTF.clear();
        noProdTF.clear();
    }
    
    @FXML
    private void MouseEntered(MouseEvent event) {
        orderConfirmLabel.setText("");
    }
    
}
