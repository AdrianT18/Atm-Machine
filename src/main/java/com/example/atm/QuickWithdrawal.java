package com.example.atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.SQLException;


public class QuickWithdrawal {

    @FXML
    Button ten, twenty, fifty, oneHundread, oneFifty, Other, Exit1;

    //Calling classes
    MainPageGui mainPage = new MainPageGui();
    QuickWithdrawlDataBase quickWithdrawlDataBase = new QuickWithdrawlDataBase();

    public Scene scene;

    //Alert boxes
    Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);

    //Error message. If the value is not what expected after potential withdrawal
    public void errorMessage() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Sorry your transaction has been declined");
        alert.showAndWait();
    }

    // Calling userDB method to return the balance
    // Subtracting the balance from 10 and seeing if the new value is greater than 0.
    public void subtractTen() throws SQLException {
        boolean withdrawTen = quickWithdrawlDataBase.withdraw10(mainPage.getVariable());
        if (withdrawTen) {
            alertInfo.setTitle("SUCCESSFUL");
            alertInfo.setHeaderText(null);
            alertInfo.setContentText("Transaction successful: £10 has been withdrawn from your account");
            alertInfo.showAndWait();
        } else {
            errorMessage();
        }
    }

    // Subtracting 20
    public void subtractTwenty() throws SQLException {
        boolean withdrawTwenty = quickWithdrawlDataBase.withdraw20(mainPage.getVariable());
        if (withdrawTwenty) {
            alertInfo.setTitle("SUCCESSFUL");
            alertInfo.setHeaderText(null);
            alertInfo.setContentText("Transaction successful: £20 has been withdrawn from your account");
            alertInfo.showAndWait();
        } else {
            errorMessage();
        }
    }

    //Subtracting 50
    public void subtractFifty() throws SQLException {
        boolean withdrawFifty = quickWithdrawlDataBase.withdraw50(mainPage.getVariable());
        if (withdrawFifty) {
            alertInfo.setTitle("SUCCESSFUL");
            alertInfo.setHeaderText(null);
            alertInfo.setContentText("Transaction successful: £50 has been withdrawn from your account");
            alertInfo.showAndWait();
        } else {
            errorMessage();
        }
    }

    //Subtracting 100
    public void subtractOneHundred() throws SQLException {
        boolean withdraw100 = quickWithdrawlDataBase.withdraw100(mainPage.getVariable());
        if (withdraw100) {
            alertInfo.setTitle("SUCCESSFUL");
            alertInfo.setHeaderText(null);
            alertInfo.setContentText("Transaction successful: £100 has been withdrawn from your account");
            alertInfo.showAndWait();
        } else {
            errorMessage();
        }
    }

    //Subtracting 150
    public void subtractOneFifty() throws SQLException {
        boolean withdraw150 = quickWithdrawlDataBase.withdraw150(mainPage.getVariable());
        if (withdraw150) {
            alertInfo.setTitle("SUCCESSFUL");
            alertInfo.setHeaderText(null);
            alertInfo.setContentText("Transaction successful: £150 has been withdrawn from your account");
            alertInfo.showAndWait();
        } else {
            errorMessage();
        }
    }

    //Subtracting other amount
    public void subtractOther() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("OtherAmount.fxml"));
            scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Other Amount");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Closes app
    Exit exit = new Exit();

    public void exit() {
        exit.Exit();
    }

    //Back
    public void back(ActionEvent event) {
        exit.backButton(event);
    }
}

