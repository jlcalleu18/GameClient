package edu.citytech.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainController {

    @FXML
    void abcCounterMode(ActionEvent event) {
        System.out.println("ABC Mode");
    }

    @FXML
    void tictactoeMode(ActionEvent event) {
        System.out.println("TicTacToe Mode");
    }
}
