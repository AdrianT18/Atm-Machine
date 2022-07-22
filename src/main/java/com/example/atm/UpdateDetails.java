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

public class UpdateDetails {
    @FXML
    TextField VerifyAccount1, NewName, NewAddress;
    public String verifyAccount, newName, newAddress;

    //Db class
    UserDB userDB = new UserDB();

    //The method will verify if the account exists and if it does it will update the new name and address in the DB
    //If the account doesn't exist it will ask the user to double-check the information is correct.
    public void updateAccount(ActionEvent event) throws IOException {
        newName = new String(NewName.getText());
        newAddress = new String(NewAddress.getText());
        verifyAccount = new String(VerifyAccount1.getText());
        // making update a boolean to check if it returns true
        boolean update = userDB.updateAccount(newName, newAddress, verifyAccount);
        //Alert boxes
        Alert alert = new Alert(Alert.AlertType.ERROR);
        Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);

        if (verifyAccount.isEmpty() || newName.isEmpty() || newAddress.isEmpty()) {
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please make sure that you have entered your personal information");
            alert.showAndWait();
        } else if (!(update)) {
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please make sure that your account number is valid");
            alert.showAndWait();
        } else {
            alertInfo.setTitle("Update Successful ");
            alertInfo.setHeaderText(null);
            alertInfo.setContentText("Thank you. Your personal details have now been updated");
        }
        //When OK button is pressed it will go to OtherServices screen
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
