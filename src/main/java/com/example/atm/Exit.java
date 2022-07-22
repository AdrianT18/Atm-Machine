package com.example.atm;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Exit {
    // A message box will appear and thanking the user for using the ATM
    public void Exit() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thank You");
        alert.setHeaderText(null);
        alert.setContentText("Thank you for using this ATM!");
        alert.showAndWait();
        Platform.exit();
    }

    // Returns the user back to the menu page
    public void backButton(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MoneyPage.fxml"));
            Scene scene1 = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.hide();
            stage.setTitle("Money Page");
            stage.setScene(scene1);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Returns user back to Other services Page
    public void backButtonOther(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("OtherServices.fxml"));
            Scene scene1 = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.hide();
            stage.setTitle("Money Page");
            stage.setScene(scene1);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
