package edu.citytech.properties;

import edu.citytech.MainController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class PropertiesController extends MainController implements Initializable {

    @FXML
    private TableView<?> tvProperties;

    @FXML
    private TableColumn<?, ?> tcPropertyId;

    @FXML
    private TableColumn<?, ?> tcCost;

    @FXML
    private TableColumn<?, ?> tcGrossIncome;

    @FXML
    private TableColumn<?, ?> tcEpenses;

    @FXML
    private TableColumn<?, ?> tcNetIncome;

    @FXML
    private TableColumn<?, ?> tcOccupancy;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
