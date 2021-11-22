package edu.citytech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {

    @FXML
    protected AnchorPane anchorPane;

    @FXML
    void abcCounterMode(ActionEvent event) {
        selectMode("ABCView.fxml", "ABC View ");
    }

    @FXML
    void tictactoeMode(ActionEvent event) {
        selectMode("TicTacToeView.fxml", "TicTacToe View");
    }
    @FXML
    void growthRateMode(ActionEvent event) {
        selectMode("GrowthRateView.fxml", "Growth Rate View");
    }
    @FXML
    void retirementMode(ActionEvent event) {
        selectMode("RetirementView.fxml", "Retirement View");
    }


    public void selectMode(String fxml, String title){
        try {

            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(fxml));
            var stage = (Stage) anchorPane.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
