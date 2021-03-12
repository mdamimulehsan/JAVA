/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class FXMLDocumentController implements Initializable {
    
   
    @FXML
    private Button Search;
    @FXML
    private Button AddEmployee;
    @FXML
    private Button EmployeeList;
    @FXML
    private Button IncreaseSalary;
    @FXML
    private Button SalaryInfo;
    @FXML
    private Text Title;

    @FXML
    private void searchEmployee(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Search.fxml"));
        
        Stage stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
       // System.out.println("Search has been succesful");
    }

    @FXML
    private void addaEmployee(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("EmployeeTypes.fxml"));
        Stage stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    
    }

    @FXML
    private void employeeList(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EmployeeList.fxml"));
        
        Stage stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void IncreaseSalary(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("IncreaseSalary.fxml"));
        
        Stage stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void salaryInfo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SalaryInfo.fxml"));
        
        Stage stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
}
