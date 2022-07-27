package com.example.atm;

import com.example.atm.UserDB;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OtherAmount {
    //FIX!! //FIX!! //FIX!! //FIX!! //FIX!! //FIX!!
    //FIX!! //FIX!! //FIX!! //FIX!! //FIX!! //FIX!! //FIX!!
    //FIX!! //FIX!! //FIX!! //FIX!! //FIX!!
    @FXML
    TextField Amount;
    @FXML
    Button Submit;
    //Calling classes
    MainPageGui mainPage = new MainPageGui();
    QuickWithdrawlDataBase quickWithdrawlDataBase = new QuickWithdrawlDataBase();

    public Alert alert;

    //checking user input(other amount)
    //Checks if the user has enough funds to take out
    //Subtracts the other amount from balance
    public void getAmount() throws SQLException {
        alert = new Alert(Alert.AlertType.INFORMATION);
        // converts the string to int
        int amount = Integer.parseInt(Amount.getText());
        boolean withdrawOtherAmount = quickWithdrawlDataBase.otherAmount(amount, mainPage.getVariable());
        Integer Balance = quickWithdrawlDataBase.balance(mainPage.getVariable());

        //If no amount is entered it shows an error box
        if (Amount.getText().isEmpty()) {
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please make sure you enter an amount");
        }
        // If the inputted amount - users balance is greater than 0 a successful message shows
        else if (withdrawOtherAmount || Balance == 0) {
            alert.setTitle("Successful");
            alert.setHeaderText(null);
            alert.setContentText("Transaction successful: £" + amount + " has been withdrawn from your account");
        }

        // Else an error message
        else {
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Sorry your transaction has been declined");
        }
        // it will close that current scene when Ok button is pressed
        if (alert.showAndWait().get() == ButtonType.OK) {
            Stage stg = (Stage) this.Submit.getScene().getWindow();
            stg.close();
        }
    }

}