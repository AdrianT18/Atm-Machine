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
    //FIX!! //FIX!! //FIX!! //FIX!! //FIX!! //FIX!!
    //FIX!! //FIX!! //FIX!! //FIX!! //FIX!! //FIX!! //FIX!! //FIX!! //FIX!! //FIX!!
    //FIX!! //FIX!! //FIX!! //FIX!! //FIX!! //FIX!!
    @FXML
    Button ten, twenty, fifty, oneHundread, oneFifty, Other, Exit1;
    //Calling classes
    UserDB userDB = new UserDB();
    int number = userDB.balance();

    public QuickWithdrawal() throws SQLException {
    }

    public Scene scene;
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
    public void moneyTen() {
        if ((number - 10) > 0) {
            alertInfo.setTitle("SUCCESSFUL");
            alertInfo.setHeaderText(null);
            alertInfo.setContentText("Transaction successful: £10 has been withdrawn from your account");
            alertInfo.showAndWait();
        } else {
            errorMessage();
        }
    }

    // Subtracting 20
    public void moneyTwenty() {
        if ((number - 20) > 0) {
            alertInfo.setTitle("SUCCESSFUL");
            alertInfo.setHeaderText(null);
            alertInfo.setContentText("Transaction successful: £20 has been withdrawn from your account");
            alertInfo.showAndWait();
        } else {
            errorMessage();
        }
    }

    //Subtracting 50
    public void moneyFifty() {
        if ((number - 50) > 0) {
            alertInfo.setTitle("SUCCESSFUL");
            alertInfo.setHeaderText(null);
            alertInfo.setContentText("Transaction successful: £50 has been withdrawn from your account");
            alertInfo.showAndWait();
        } else {
            errorMessage();
        }
    }

    //Subtracting 100
    public void moneyOneHundred() {
        if ((number - 100) > 0) {
            alertInfo.setTitle("SUCCESSFUL");
            alertInfo.setHeaderText(null);
            alertInfo.setContentText("Transaction successful: £100 has been withdrawn from your account");
            alertInfo.showAndWait();
        } else {
            errorMessage();
        }
    }

    //Subtracting 150
    public void moneyOneFifty() {
        if ((number - 150) > 0) {
            alertInfo.setTitle("SUCCESSFUL");
            alertInfo.setHeaderText(null);
            alertInfo.setContentText("Transaction successful: £150 has been withdrawn from your account");
            alertInfo.showAndWait();
        } else {
            errorMessage();
        }
    }

    //Subtracting other amount
    public void other() {
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

    Exit exit = new Exit();

    public void exit() {
        exit.Exit();
    }

    //Back
    public void back(ActionEvent event) {
        exit.backButton(event);
    }
}

