package edu.citytech.retirement;

import edu.citytech.MainController;
import edu.citytech.retirement.model.Retirement;
import edu.citytech.retirement.model.Year;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
    @FXML
    private Label lbStart;

    @FXML
    private Label lbYear;

    @FXML
    private Label lbInterest;

    @FXML
    private Label lbEnding;

    @FXML
    private Label lbNo;
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
        lbNo.setText("30");
        lbStart.setText(String.valueOf(getTotal("start")));
        lbYear.setText(String.valueOf(getTotal("year")));
        lbInterest.setText(String.valueOf(getTotal("interest")));
        lbEnding.setText(String.valueOf(getTotal("ending")));
    }
    @FXML
    void process(ActionEvent event) {
        tvRetirement.getItems().clear();
        var years = RetirementDataLayer.getRetirement(txtYears.getText()).getYears();
        ObservableList<Year> oYears = tvRetirement.getItems();
        oYears.addAll(years);
        lbNo.setText(txtYears.getText());
        lbStart.setText(String.valueOf(getTotal("start")));
        lbYear.setText(String.valueOf(getTotal("year")));
        lbInterest.setText(String.valueOf(getTotal("interest")));
        lbEnding.setText(String.valueOf(getTotal("ending")));
    }
    public float getTotal(String getRetirement){
        float totalPrice = 0;
        if (getRetirement.equals("start")){
            totalPrice = tvRetirement.getItems().stream().map(
                    (item) -> item.getStartingBalance()).reduce(totalPrice, (accumulator, _item) -> accumulator + _item);
            return totalPrice;
        }else if (getRetirement.equals("year")){
            totalPrice = tvRetirement.getItems().stream().map(
                    (item) -> item.getYearlyDeposit()).reduce(totalPrice, (accumulator, _item) -> accumulator + _item);
            return totalPrice;
        }else if (getRetirement.equals("interest")){
            totalPrice = tvRetirement.getItems().stream().map(
                    (item) -> item.getInterestEarned()).reduce(totalPrice, (accumulator, _item) -> accumulator + _item);
            return totalPrice;
        }else if (getRetirement.equals("ending")){
            totalPrice = tvRetirement.getItems().stream().map(
                    (item) -> item.getEndingBalance()).reduce(totalPrice, (accumulator, _item) -> accumulator + _item);
            return totalPrice;
        }else{
            return totalPrice;
        }
    }
}
/**/