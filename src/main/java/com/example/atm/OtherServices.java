package com.example.atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.SQLException;

public class OtherServices {

    @FXML
    Button ChangePin, Report, UpdateDetails, DeleteAccount, Exit3, Back3;

    public OtherServices() throws SQLException {
    }

    //Change pin scene
    public void ChangePin(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ChangePin.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.hide();
            stage.setTitle("Change Pin");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Report card scene
    public void reportCard(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ReportCard.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.hide();
            stage.setTitle("Report card");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Update details scene
    public void updateDetails(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("UpdateDetails.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.hide();
            stage.setTitle("Update Details");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Delete Details scene
    public void deleteDetails(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("DeleteAccount.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.hide();
            stage.setTitle("Update Details");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Exit
    Exit exit = new Exit();

    public void exit() {
        exit.Exit();
    }

    //Back
    public void back(ActionEvent event) {
        exit.backButton(event);
    }
}
