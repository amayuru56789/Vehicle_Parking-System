package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import model.Vehicle;

public class VehicleFormController {

    public AnchorPane VehicleContext;
    public JFXTextField txtNo;
    public ComboBox cmbType;
    public JFXTextField txtWeight;
    public JFXTextField txtPassenger;

    public void AddVehicleOnAction(ActionEvent actionEvent) {
      //Vehicle v1=new Vehicle(txtNo.getText(),cmbType.getItems(),txtWeight.getText(),txtPassenger.getText());

    }
}
