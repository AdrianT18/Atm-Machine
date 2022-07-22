package com.example.atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class DeleteAccount {
    @FXML
    TextField DeleteAccountText, DeleteName, DeletePin;

    public String account, name, pin;

    UserDB userDB = new UserDB();

    //Checking if the Account number, first name and pin exist
    public void checkAccountDetails(ActionEvent event) throws IOException, SQLException {
        account = new String(DeleteAccountText.getText());
        name = new String(DeleteName.getText());
        pin = new String(DeletePin.getText());

        // Returning values from DB
        int checkBalance = userDB.verifyBalance(account);
        boolean validateDetails = userDB.validateAccount(account, pin);

        //Alert boxes
        Alert alert = new Alert(Alert.AlertType.ERROR);
        Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);

        //Checking if the text fields are empty
        if (account.isEmpty() || name.isEmpty() || pin.isEmpty()) {
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please enter details in the provided space");
            alert.showAndWait();
        }
        //Validating account details
        else if (!(validateDetails)) {
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please make sure that you have entered the correct account details");
            alert.showAndWait();
        }
        //Checking if the balance is 0
        else if (checkBalance != 0) {
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please make sure that your balance is 0. You can send the money to a different account or withdraw it.");
            alert.showAndWait();
            DeleteAccountText.clear();
            DeleteName.clear();
            DeletePin.clear();
        } else {
            // If balance is 0 and details are correct it will delete the account
            try {
                userDB.deleteAccountDB(account);
            } catch (Exception e) {
                e.printStackTrace();
            }
            alertInfo.setTitle("Update Successful");
            alertInfo.setHeaderText(null);
            alertInfo.setContentText("Thank you. Your account has now been permanently deleted");
        }

//        //When OK button is pressed it will go to OtherServices screen
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

    //If they do it will show a message and delete the account permanently

    //Exit
    Exit exit = new Exit();

    public void exit() {
        exit.Exit();
    }

    //Back
    public void back(ActionEvent event) {
        exit.backButtonOther(event);
    }

}
