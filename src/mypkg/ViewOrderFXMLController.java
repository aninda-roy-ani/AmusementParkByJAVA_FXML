/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ViewOrderFXMLController implements Initializable {

    @FXML
    private TableView<Product> prodTable;
    @FXML
    private TableColumn<Product, String> prodID;
    @FXML
    private TableColumn<Product, String> prodName;
    @FXML
    private TableColumn<Product, String> prodNum;
    
    ObservableList<Product> products = FXCollections.observableArrayList();

    String name, issueDate, orderer;
    @FXML
    private Label ordererLabel;
    @FXML
    private Label orderDateLabel;
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
        
        
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;
        
        try{
        f = new File("Product.bin");
        fis = new FileInputStream(f);
        bis = new BufferedInputStream(fis);
        dis = new DataInputStream(bis);
        
        String string = "";
        while(true){
            String st1 =dis.readUTF();
            String st2 =dis.readUTF();
            String st3 =dis.readUTF();
            String st4 =dis.readUTF();
            String st5 =dis.readUTF();
            String st6 =dis.readUTF();
            if(st1.equals(name)){
                Product p = new Product(st2, st3, st4);
                products.add(p);
                orderer = st6;
                issueDate = st5;
            }
        }
        }catch(IOException e){
            
        }finally{
            try{
                
                if(dis!=null) dis.close();
            }catch(IOException e){
                
            }
        }
        
        ordererLabel.setText(orderer);
        orderDateLabel.setText(issueDate);
        
        prodID.setCellValueFactory(new PropertyValueFactory<Product,String>("prodID"));
        prodName.setCellValueFactory(new PropertyValueFactory<Product,String>("prodName"));
        prodNum.setCellValueFactory(new PropertyValueFactory<Product,String>("noProd"));
        
        prodTable.setItems(products);
    }    
    
}
