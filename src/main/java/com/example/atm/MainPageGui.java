package com.example.atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageGui {
    @FXML
    public TextField number;
    @FXML
    public TextField pin;
    @FXML
    Button Next;
    boolean loop = false;
    public String loginAccountNumber;

    //Checking if the input matches the DB
    //Using MySql
    //I call userDB. That's where the query is made to select the details from the Account Number and Pin
    public void check(ActionEvent event) throws IOException {
        loginAccountNumber = new String(number.getText());
        String accountPin = new String(pin.getText());
        //check if txtField is empty
        if (loginAccountNumber.equals("") || accountPin.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please make sure that you have entered your details");
            alert.showAndWait();
        }
        //call DB method
        else {
            // sets a boolean to see if the return value is true
            UserDB userDB = new UserDB();
            boolean accountLogin = userDB.validateAccount(loginAccountNumber, accountPin);

            do {
                loop = false;
                //if login != /  match DB
                if (!(accountLogin)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Please make sure that your Account exists");
                    alert.showAndWait();
                    number.setText("");
                    pin.setText("");
                    loop = true;
                    break;
                } else {
                    //New scene
                    Parent root = FXMLLoader.load(getClass().getResource("MoneyPage.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.hide();
                    stage.setTitle("MoneyPage");
                    stage.setScene(scene);
                    stage.show();
                }
            }
            while (loop);
        }
    }

    //clear the info
    public void clear() {
        number.clear();
        pin.clear();
    }

    //Closes the application
    Exit exit = new Exit();

    public void exit() {
        exit.Exit();
    }

    //Register new account

}
