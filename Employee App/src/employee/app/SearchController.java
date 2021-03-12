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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SearchController implements Initializable {

    @FXML
    private ListView<String> searchlist;

    @FXML
    private Button home;

    @FXML
    private TextField idField;

    @FXML
    private Button search;

    @FXML
    void goHome(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Stage stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();

    }
    public void errorAlert()
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("Please fill Up All Information Properly");
      alert.showAndWait();
    }

    @FXML
    void searchButton(ActionEvent event) {
         if(idField.getText().equals(""))
    {
        
        errorAlert();
    }
        
        try{
        
        String id = idField.getText();
         
        Connect c = new Connect();
        c.searchId=id;
        String searchOut = c.searchID();
        searchlist.getItems().addAll(searchOut);
        idField.setText("");
         }
        catch (Exception e) {
         warningAlert();
            
        }
    }
    

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
      alert.setTitle("Employee Not Found");
      alert.setHeaderText("Sorry!!Not Matching With Any ID!!");
      alert.setContentText("Enter Correct ID");
      alert.show();
    }    

  


 
    
}
