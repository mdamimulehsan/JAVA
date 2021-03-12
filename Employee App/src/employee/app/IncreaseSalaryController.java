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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class IncreaseSalaryController implements Initializable {

    @FXML
    private TextField idfield;
    @FXML
    private TextField salaryfield;
    @FXML
    private Text id;
    @FXML
    private Text salary;
    @FXML
    private Button CancelButton;
    @FXML
    private Button IncreaseButton;
    @FXML
    private Label massage;
    @FXML
    private Text Title;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    public void warningAlert()
    {
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Updated Failed");
      alert.setHeaderText("Update Failed");
      alert.setContentText("Please Give The Correct Id Number and Amount fill Up");
      alert.show();
    }

    public void succesAlert()
    {
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Updated");
      alert.setHeaderText("Updated Succesfully");
      alert.setContentText("Infromation Submitted!!");
      alert.show();
    }

    @FXML
    private void cancelButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Stage stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void IncreaseButton(ActionEvent event) {
        String id = idfield.getText();
        String sal = salaryfield.getText();
        double salary = Double.parseDouble(sal);
        Connect c = new  Connect();
        c.searchId=id;
        c.amt=salary;
        c.updateSalary();
        String s = c.updateSalary();
        idfield.setText("");
        salaryfield.setText("");
        if("Yes".equals(s))
        {
            succesAlert();
        }
        else{
            
            warningAlert();
        }
        
    }
    
}
