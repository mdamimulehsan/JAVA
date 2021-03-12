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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class HourlyEmployeeController implements Initializable {

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
    private Button AddButton;
    @FXML
    private TextField hourlyratefield;
    @FXML
    private TextField hourworkedfield;
    @FXML
    private Text id;
    @FXML
    private Text designation;
    @FXML
    private Button HomeButton;
    @FXML
    private Text hourlyrate;
    @FXML
    private Text hourworked;
    @FXML
    private Button ClearButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void showSuccesAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Added");
        alert.setHeaderText("Congratulation!!Infromation SuccesFully Submitted ");
        alert.showAndWait();
    }

    public void showErrorAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Sorry");
        alert.setHeaderText("You Have To fill Up All Information Properly");
        alert.showAndWait();
    }

    @FXML
    private void homeButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void addButton(ActionEvent event) throws IOException {

        if (namefiled.getText().equals("") || designationfield.getText().equals("") || idfield.getText().equals("") || hourlyratefield.getText().equals("") || hourworkedfield.getText().equals("")) {

            showErrorAlert();
        } else {

            String name = namefiled.getText();
            String id = idfield.getText();
            String des = designationfield.getText();
            String hourwork = hourworkedfield.getText();
            String hourRate = hourlyratefield.getText();
            int hw = Integer.parseInt(hourwork);
            double hr = Double.parseDouble(hourRate);
            namefiled.setText("");
            idfield.setText("");
            designationfield.setText("");
            hourworkedfield.setText("");
            hourlyratefield.setText("");

            showSuccesAlert();
            Connect c = new Connect();
            c.hourly(name, id, des, hr, hw);

        }

    }

    @FXML
    private void clearButton(ActionEvent event) {
        namefiled.setText("");
        designationfield.setText("");
        idfield.setText("");
        hourworkedfield.setText("");
        hourlyratefield.setText("");
    }
}
