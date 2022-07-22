package com.example.atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ReportCard {
    @FXML
    TextField VerifyAccount, VerifyName;
    @FXML
    Button SubmitReport, BackReport, ExitReport;
    UserDB userDB = new UserDB();

    public String account;
    public String name;

    //Verifying account number and First Name
    //If it doesn't exist error message shows up
    //If successful it will go back to the home page
    public void reportCard(ActionEvent event) throws IOException, SQLException {
        account = new String(VerifyAccount.getText());
        name = new String(VerifyName.getText());
        //creates a boolean and if the return is true it will be successful
        boolean reportC = userDB.reportCard(account);
        //Alert boxes
        Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
        Alert alert = new Alert(Alert.AlertType.ERROR);

        //If the return is false an error box will appear otherwise successful
        if (!(reportC)) {
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please make sure that your account number and pin are valid");
            alert.showAndWait();
        } else {
            alertInfo.setTitle("Report Successful ");
            alertInfo.setHeaderText(null);
            alertInfo.setContentText("Thank you. We will report your card as lost or stolen until the bank lets us know it's found. For now your card will be unusable.");
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

    //closes scene
    Exit exit = new Exit();

    public void exit() {
        exit.Exit();
    }

    //Back to other services
    public void back(ActionEvent event) {
        exit.backButtonOther(event);
    }
}
