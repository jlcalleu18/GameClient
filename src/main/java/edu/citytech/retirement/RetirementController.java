package edu.citytech.retirement;

import edu.citytech.MainController;
import edu.citytech.retirement.model.Year;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RetirementController extends MainController implements Initializable {

    @FXML
    private TableView<Year> tvRetirement;

    @FXML
    private TextField txtYears;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        var years = RetirementDataLayer.getRetirement("30").getYears();
        ObservableList<Year> oYears = tvRetirement.getItems();
        oYears.addAll(years);
    }
    @FXML
    void process(ActionEvent event) {
        tvRetirement.getItems().clear();
        String yearsRetirement = txtYears.getText();
        var years = RetirementDataLayer.getRetirement(yearsRetirement).getYears();
        ObservableList<Year> oYears = tvRetirement.getItems();
        oYears.addAll(years);
    }
}
