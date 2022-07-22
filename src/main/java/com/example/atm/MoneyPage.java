package com.example.atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MoneyPage implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void quickWithdrawal(ActionEvent event) {
        //New QuickWithdrawl scene
        try {
            Parent root = FXMLLoader.load(getClass().getResource("QuickWithdrawal.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.hide();
            stage.setTitle("QuickWithdrawal");
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Transfer Money scene
    public void transferMoneyPage(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("TransferMoney.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.hide();
            stage.setTitle("TransferMoney");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Other services scene
    public void otherServices(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("OtherServices.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.hide();
            stage.setTitle("OtherServices");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Closes application
    public void exit(ActionEvent event1) throws IOException {
        Exit exit = new Exit();
        exit.Exit();
    }
}
