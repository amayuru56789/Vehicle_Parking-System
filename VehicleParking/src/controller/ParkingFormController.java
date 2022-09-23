package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Vehicle;
import view.tm.Table;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class ParkingFormController {

    public AnchorPane ParkingContext;
    public TableColumn colNo;
    public TableColumn colType;
    public TableColumn colSlot;
    public TableColumn colTime;
    public TableView tblPark;
    public JFXButton btnLogOut;
    public TableView tblDelivery;
    public JFXComboBox cmbId;


    public void BackToLogin(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/LoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) ParkingContext.getScene().getWindow();
        window.setTitle("Log In");
        window.setScene(new Scene(load));
    }

    public void openVehicleFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/VehicleForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) ParkingContext.getScene().getWindow();
        window.setTitle(" Add Vehicle");
        window.setScene(new Scene(load));
    }

    public void DriverFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DriverForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) ParkingContext.getScene().getWindow();
        window.setTitle(" Add Driver");
        window.setScene(new Scene(load));
    }
    public void initialize(){
        cmbId.getItems().addAll("In Parking","On Delivery");
        cmbId.setValue("In Parking");
    }

    public void cmbOnAction(ActionEvent actionEvent) {
        if(cmbId.getValue().equals("On Delivery")){
            btnLogOut.setVisible(false);
            tblPark.setVisible(false);
            tblDelivery.setVisible(true);
        }else {
            btnLogOut.setVisible(true);
            tblDelivery.setVisible(false);
            tblPark.setVisible(true);
        }
    }
    public void loadVehicles(){
        ObservableList<Table> tmObservable = FXCollections.observableArrayList();
        //tblPark.setItems();
    }
}
