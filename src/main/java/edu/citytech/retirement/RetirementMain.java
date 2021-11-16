package edu.citytech.retirement;

import edu.citytech.LoadScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class RetirementMain extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        new LoadScene().loadPage(stage,"RetirementView.fxml","Retirement");
    }
}
