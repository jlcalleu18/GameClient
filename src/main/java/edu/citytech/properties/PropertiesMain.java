package edu.citytech.properties;

import edu.citytech.LoadScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class PropertiesMain extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        new LoadScene().loadPage(stage,"PropertiesView.fxml","Properties");
    }
}
