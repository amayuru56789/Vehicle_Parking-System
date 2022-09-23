package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class DriverFormController {

    public AnchorPane DriverFormContext;
    public JFXTextField txtName;
    public JFXTextField txtNic;
    public JFXTextField txtAddress;
    public JFXTextField txtLicen;
    public JFXTextField tctContact;

    public void DriverSaveOnAction(ActionEvent actionEvent) {
       // ArrayList<String> driver = new ArrayList<>();
        String driver = (txtName.getText());
       // driver.add(txtNic.getText());
       // driver.add(txtAddress.getText());
       // driver.add(txtLicen.getText());
        //driver.add(tctContact.getText());
        //System.out.println(driver);

    }

    public void backBtn(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) DriverFormContext.getScene().getWindow();
        window.setTitle("Log In");
        window.setScene(new Scene(load));
    }
}
