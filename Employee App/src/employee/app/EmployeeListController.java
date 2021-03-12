/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.app;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class EmployeeListController implements Initializable {

    @FXML
    private ListView<String> employeeslist;
    @FXML
    private Button showlist;
    @FXML
    private Button home;

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
      alert.setHeaderText("Sorry!!Not Matching With Any ID!!");
      alert.setContentText("No data found");
      alert.show();
    }    


    @FXML
    private void showList(ActionEvent event) {
      Connect c= new  Connect();
      ArrayList<Employee> employee= c.showres();
      employeeslist.getItems().clear();
        if (employee.size()==0) {
             warningAlert();    
        } 
        else {
        
      for(int i=0; i<employee.size();i++)
      {
          
          Employee emp= employee.get(i);
          String ob= emp.display();
          employeeslist.getItems().add(ob);

      }
        }
      
    }

    @FXML
    private void homeButton(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
    
}
