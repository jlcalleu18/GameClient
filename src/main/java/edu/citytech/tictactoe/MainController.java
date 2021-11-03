package edu.citytech.tictactoe;

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
        selectMode("ABCView.fxml");
    }

    @FXML
    void tictactoeMode(ActionEvent event) {
        selectMode("TicTacToeView.fxml");
    }
    @FXML
    void growthRateMode(ActionEvent event) {
        selectMode("GrowthRateView.fxml");
    }


    public void selectMode(String fxml){
        try {

            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(fxml));
            var stage = (Stage) anchorPane.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
