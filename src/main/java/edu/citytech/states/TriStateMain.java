package edu.citytech.states;

import edu.citytech.LoadScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class TriStateMain extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        new LoadScene().loadPage(stage, "TriStateView.fxml","TriState Income");
    }
}
