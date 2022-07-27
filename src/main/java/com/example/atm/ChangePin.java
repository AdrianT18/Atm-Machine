package com.example.atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ChangePin {
    @FXML
    Button SubmitPin, BackPin, ClearPin, ExitPin;
    @FXML
    TextField Account1, CurrentPin, NewPin1, NewPin2;

    UserDB userDB = new UserDB();
    MainPageGui mainPage = new MainPageGui();
    public String accountNumber;
    public String pin;
    public String newPin;
    public String confirmNewPin;

    //Updating pin
    //First checking if account exists
    //Updating pin in DB
    public void updatePin(ActionEvent event) throws SQLException, IOException {
        //gets the string from text field
        pin = new String(CurrentPin.getText());
        newPin = new String(NewPin1.getText());
        confirmNewPin = new String(NewPin2.getText());

        //Alert box
        Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);

        //Boolean to check if the query in userDB returns true
        boolean accountConfirm = userDB.validateAccount(mainPage.getVariable(), pin);
        boolean pinUpdate = userDB.updatePin(newPin, mainPage.getVariable());

        //if the boolean returns false error message will show
        if (!(accountConfirm)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please make sure that your account number and pin are valid");
        }
        //else if the new pin doesn't match confirm pin an error message will appear to make sure the entered pin is the same
        else if (!(pinUpdate) && newPin.equals(pin)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please make sure that the pin entered is the same");
            alert.showAndWait();
        }
        // if there is no errors a successful message will show and when the OK button is pressed
        // the ChangePin screen will change and go back to OtherServices
        else {
            alertInfo.setTitle("Successful");
            alertInfo.setHeaderText(null);
            alertInfo.setContentText("Your new pin has been updated");

        }
        if (alertInfo.showAndWait().get() == ButtonType.OK) {
            Parent root = FXMLLoader.load(getClass().getResource("OtherServices.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.hide();
            stage.setTitle("TransferMoney");
            stage.setScene(scene);
            stage.show();
        }
    }

    //Clear the text fields
    public void clear() {
        Account1.clear();
        CurrentPin.clear();
        NewPin1.clear();
        NewPin2.clear();
    }

    //Closes the application
    Exit exit = new Exit();

    public void exit() {
        exit.Exit();
    }

    //Go back to the menu
    public void back(ActionEvent event) {
        exit.backButtonOther(event);
    }
}
