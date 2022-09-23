package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import javafx.util.Duration;
import model.Bus;
import model.Lorry;
import model.Van;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DashBoardFormController {

    public AnchorPane DashBoardContext;
    public JFXComboBox cmbVehicle;
    public JFXTextField txtType;
    public JFXComboBox cmbDriver;
    public Label lblDate;
    public Label lblTime;
    //public Label lblSlot;
    public Label lblSlotPort;
    public JFXButton btnParkId;
    public JFXButton btnDeliveryId;

    public void OpenLoginForm(ActionEvent actionEvent) throws IOException {

        URL resource = getClass().getResource("../view/LoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) DashBoardContext.getScene().getWindow();
        window.setScene(new Scene(load));

    }
    private void LocalTime() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            lblTime.setText(LocalDateTime.now().format(formatter));
        }),
                new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
    public void LocalDate() throws InterruptedException {
        SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        lblDate.setText(DateFormatter.format(date));
        Thread.sleep(1000);
    }
    public void initialize() throws InterruptedException {
        cmbSetValue();
        LocalTime();
        LocalDate();

        cmbDriver.getItems().add(driver);
        cmbDriver.setValue("Driver");

    }

    String[][] vehicle = {
            {"NA-3434", "Bus"},
            {"KA-4563", "Van"},
            {"58-3567", "Van"},
            {"GF-4358", "Van"},
            {"CCB-3568", "Van"},
            {"LM-6679", "Van"},
            {"QA-3369", "Van"},
            {"KB-3668", "Cargo Lorry"},
            {"JJ-9878", "Cargo Lorry"},
            {"GH-5772", "Cargo Lorry"},
            {"XY-4456", "Cargo Lorry"},
            {"YQ-3536", "Cargo Lorry"},
            {"CBB-3566", "Cargo Lorry"},
            {"QH-3444", "Cargo Lorry"}
    };


    Van v1 = new Van();
    Lorry c1 = new Lorry();
    Bus b1 = new Bus();

    public static String vehicleNumber;
    public static String vehicleType;

    String driver;

    private void setParking(){
        if(vehicleType.equals("Van")){
            lblSlotPort.setText(v1.parkingSlot(vehicleNumber,vehicleType));

            if (v1.parkingSlot(vehicleNumber,vehicleType).equals("Parked")){
                btnParkId.setDisable(true);
                btnDeliveryId.setDisable(false);
            }else {
                btnDeliveryId.setDisable(true);
                btnParkId.setDisable(false);
            }

        }else if (vehicleType.equals("Cargo Lorry")){
            lblSlotPort.setText(c1.parkingSlot(vehicleNumber,vehicleType));

            if(c1.parkingSlot(vehicleNumber,vehicleType).equals("Parked")){
                btnParkId.setDisable(true);
                btnDeliveryId.setDisable(false);
            }else {
                btnDeliveryId.setDisable(true);
                btnParkId.setDisable(false);
            }

        }else if (vehicleType.equals("Bus")){
            lblSlotPort.setText(b1.parkingSlot(vehicleNumber,vehicleType));

            if (b1.parkingSlot(vehicleNumber,vehicleType).equals("Parked")){
                btnParkId.setDisable(true);
                btnDeliveryId.setDisable(false);
            }else {
                btnDeliveryId.setDisable(true);
                btnParkId.setDisable(false);
            }
        }
    }

    public void btnParkVehicleOnAction(ActionEvent actionEvent) {
        if (vehicleType.equals("Van")){
            v1.parking(vehicleNumber,vehicleType);
        }else if(vehicleType.equals("Cargo Lorry")){
            c1.parking(vehicleNumber,vehicleType);
        }else if (vehicleType.equals("Bus")){
            b1.parking(vehicleNumber,vehicleType);
        }
    }

    public void cmbSelectOnAction(ActionEvent actionEvent) {
        for (int i=0; i< vehicle.length; i++){
            for (int j=0; j< vehicle[i].length;j++){
                if(vehicle [i] [0].equals(cmbVehicle.getValue())){
                    txtType.setText(vehicle [i] [1]);
                    break;
                }
                vehicleNumber = (String) cmbVehicle.getValue();
                vehicleType = txtType.getText();
                setParking();
                break;
            }
        }
    }
    public void cmbSetValue(){
        for (int i=0; i< vehicle.length; i++){
            cmbVehicle.getItems().addAll(vehicle[i] [0]);
        }
    }

    public void btnDeliveryOnAction(ActionEvent actionEvent) {
        v1.leaveParking(vehicleNumber,vehicleType);
        c1.leaveParking(vehicleNumber,vehicleType);
        b1.leaveParking(vehicleNumber,vehicleType);
    }

    public void cmbDriverOnAction(ActionEvent actionEvent) {


    }

}
