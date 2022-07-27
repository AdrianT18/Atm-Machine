package com.example.atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class TransferMoney {
    @FXML
    TextField TransferAccount, TransferAmount;
    @FXML
    Button TransferExit, TransferBack, TransferSubmit;
    UserDB userDB = new UserDB();
    MainPageGui mainPage = new MainPageGui();

    //I'm getting the text from account number to select the account from DB
    //Then im getting the chosen amount they want to send to the next account

    public void transferMoney() throws SQLException {
        String accountNumber = new String(TransferAccount.getText());
        String amount = new String(TransferAmount.getText());

        boolean amountUpdate = userDB.transferMoney(amount, accountNumber);
        boolean subtractBalance = userDB.userUpdate(amount, mainPage.getVariable());

        Alert alert;
        //If amountUpdate & subtractBalance return false an error message will appear
        if (!(amountUpdate) && !(subtractBalance)) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please make sure that the account you are trying to send money exists within our branch");

        } else {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Thank you. £" + amount + " got sent Successfully too Account: " + accountNumber);
            TransferAccount.clear();
            TransferAmount.clear();
        }
        alert.showAndWait();
    }

    //Back
    public void back(ActionEvent event) {
        Exit exit = new Exit();
        exit.backButton(event);
    }

    //Closes app
    public void exit(ActionEvent event1) throws IOException {
        Exit exit = new Exit();
        exit.Exit();
    }
}
