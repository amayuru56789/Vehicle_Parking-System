package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginFormController {

    public AnchorPane LoginFormContext;
    public JFXTextField uName;
    public JFXPasswordField pName;

    public void OpenParkingForm(ActionEvent actionEvent) throws IOException {

        URL resource = getClass().getResource("../view/ParkingForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) LoginFormContext.getScene().getWindow();
        window.setTitle("Parking System");
        if(uName.getText().equalsIgnoreCase("amayuru5678")&&pName.getText().equalsIgnoreCase("123")) {
            window.setScene(new Scene(load));
        }else {
            new Alert(Alert.AlertType.WARNING,"Invalid User name or password", ButtonType.CLOSE).show();
            System.out.println("User name or password incorrect");
        }
    }
}
