package edu.citytech.retirement;

import edu.citytech.MainController;
import edu.citytech.retirement.model.Year;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RetirementController extends MainController implements Initializable {

    @FXML
    private TableView<Year> tvRetirement;

    @FXML
    private TextField txtYears;

    @FXML
    private TableColumn<Year, Float> tcStartingBalance;

    @FXML
    private TableColumn<Year, Float> tcYearlyDeposit;

    @FXML
    private TableColumn<Year, Float> tcInterestEarned;

    @FXML
    private TableColumn<Year, Float> tcEndingBalance;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        var years = RetirementDataLayer.getRetirement("30").getYears();
        ObservableList<Year> oYears = tvRetirement.getItems();
        oYears.addAll(years);
        tcStartingBalance.setCellFactory(column ->{
            var cell = new CustomTableCell();
            return cell;
        });
        tcYearlyDeposit.setCellFactory(column ->{
            var cell = new CustomTableCell();
            return cell;
        });
        tcInterestEarned.setCellFactory(column ->{
            var cell = new CustomTableCell();
            return cell;
        });
        tcEndingBalance.setCellFactory(column ->{
            var cell = new CustomTableCell();
            return cell;
        });
    }
    @FXML
    void process(ActionEvent event) {
        tvRetirement.getItems().clear();
        var years = RetirementDataLayer.getRetirement(txtYears.getText()).getYears();
        ObservableList<Year> oYears = tvRetirement.getItems();
        oYears.addAll(years);
    }
}
/*float TotalPrice = 0;
        TotalPrice = tvRetirement.getItems().stream().map(
                (item) -> item.getYearlyDeposit()).reduce(TotalPrice, (accumulator, _item) -> accumulator + _item);

        lbDeposit.setText(String.valueOf(TotalPrice));*/