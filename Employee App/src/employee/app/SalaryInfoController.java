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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SalaryInfoController implements Initializable {

    @FXML
    private TextField idfield;
    @FXML
    private Text id;
    @FXML
    private Button CancelButton;
    @FXML
    private Button InfoButton;
    @FXML
    private Text Title;
    @FXML
    private TextArea output;

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
      alert.setTitle("ID Not Found");
      alert.setHeaderText("No Employee Found At This ID!!");
      alert.setContentText("Enter Correct Id Number");
      alert.show();
    }
    public void succesAlert()
    {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Information Added");
      alert.setHeaderText("Infromation SuccesFully Submitted ");
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
    private void infoButton(ActionEvent event) {
        try {
        Connect c= new Connect();
        c.searchId=idfield.getText();
        String res=c.Salary();
        output.setText(res);
        succesAlert();
        idfield.setText("");
        } 
        catch (Exception e) 
        {
           warningAlert();
        }
        
        
    }
    
}
