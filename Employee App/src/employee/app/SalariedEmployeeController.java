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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SalariedEmployeeController implements Initializable {

    @FXML
    private Text Title;
    @FXML
    private Text name;
    @FXML
    private TextField namefiled;
    @FXML
    private TextField designationfield;
    @FXML
    private TextField idfield;
    @FXML
    private TextField salaryfield;
    @FXML
    private Text id;
    @FXML
    private Text designation;
    @FXML
    private Text salary;
    @FXML
    private Button CancelButton;
    @FXML
    private Button AddButton;
    @FXML
    private Button ClearButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void showSuccesAlert()
    {
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Information Added");
      alert.setHeaderText("Congratulation!!Infromation SuccesFully Submitted ");
      alert.showAndWait();
    }
    public void showErrorAlert()
    {
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Sorry");
      alert.setHeaderText("You Have To fill Up All Information Properly");
      alert.showAndWait();
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
    private void addButton(ActionEvent event)throws IOException {
        
               
        if(namefiled.getText().equals("") || designationfield.getText().equals("") || idfield.getText().equals("") || salaryfield.getText().equals(""))
    {
        showErrorAlert();
    }
        else{
            
        String name = namefiled.getText();
        String designation = designationfield.getText();
        String id = idfield.getText();
        double salary = Double.valueOf(salaryfield.getText());

        Connect c = new Connect();
        c.salaried(name, id, designation, salary);
        showSuccesAlert();
        
        }
    }

    @FXML
    private void clearButton(ActionEvent event) {
        namefiled.setText("");
        designationfield.setText("");
        idfield.setText("");
        salaryfield.setText("");
    }
}

