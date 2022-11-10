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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class BookTicketFXMLController implements Initializable {


    ObservableList<String> rides = FXCollections.observableArrayList("Pendulum Ride", "Roller Coaster", "Merry-Go-Round", "Dark Ride", "Magic Coaster", "Water Ride");

    ObservableList<String> packages = FXCollections.observableArrayList("Single", "Couple", "Family");
    @FXML
    private ComboBox<String> rideCB;
    @FXML
    private DatePicker date;
    @FXML
    private TextField nameId;
    @FXML
    private TextField phoneNo;
    @FXML
    private ComboBox<String> packageCB;
    @FXML
    private Label ticketLabel;
    @FXML
    private TextField noTickets;
   
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //rideCB.setValue("Pendulum Ride");
        rideCB.setItems(rides);
        
        packageCB.setValue("Single");
        packageCB.setItems(packages);
    }    

    @FXML
    private void SubmitBtnAction(ActionEvent event) {
        
        String selectedRide = rideCB.getValue();
        String selectedDate = date.getValue().toString();
        String name = nameId.getText();
        String phone = phoneNo.getText();
        String selectedPackage = packageCB.getValue();
        String packageNum = noTickets.getText();
        
        int bookNo = (int)(Math.random() * 1000000000)+1000000000;
        
        BookedTicket bt = new BookedTicket(selectedRide, selectedDate, name, phone, selectedPackage, packageNum, bookNo);
        
        ticketLabel.setText("Keep the BOOKING NUMBER to buy your tickets from the entrance : " + bookNo);
        File f = null;
        FileWriter fw = null;
        try{
            f = new File("TicketDoc.txt");
            fw = new FileWriter(f,true);
            String str =  selectedRide + "#" + selectedDate + "#" + name + "#" + phone
                    + "#"+ selectedPackage + "#" + packageNum + "#" + bookNo + "\n";
            System.out.println(str);
            fw.write(str);
        }catch(IOException e){
                
        }finally{
            try{
                if(fw!= null) fw.close();
            }catch(IOException e){
                
            }
        }
        rideCB.setValue(null);
        date.setValue(null);
        nameId.clear();
        phoneNo.clear();
        packageCB.setValue(null);
        noTickets.clear();
    }
    
    @FXML
    private void MouseEntered(MouseEvent event) {
        ticketLabel.setText("");
    }
}
