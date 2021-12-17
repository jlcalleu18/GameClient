package edu.citytech.retirement;

import edu.citytech.MainController;
import edu.citytech.retirement.model.Year;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Date;
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



    public void populateTable(int year){
        var years = RetirementDataLayer.getRetirement(year).getYears();
        ObservableList<Year> oYears = tvRetirement.getItems();
        oYears.addAll(years);
        System.out.println(" "+ new Date());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populateTable(30);

        tvRetirement.getColumns().stream().skip(1).forEach(tableColumn ->{
            tableColumn.setCellFactory(c -> new CustomTableCell("$##,###.00"));
        });

        lbNo.setText("30");
        lbStart.setText("$"+ getTotal("start"));
        lbYear.setText("$"+ getTotal("year"));
        lbInterest.setText("$"+ getTotal("interest"));
        lbEnding.setText("$"+ getTotal("ending"));


/*        tcStartingBalance.setCellFactory(column ->{
            var cell = new CustomTableCellState("$00,000.00");
            return cell;
        });
        tcYearlyDeposit.setCellFactory(column ->{
            var cell = new CustomTableCellState("$##,###.00");
            return cell;
        });
        tcInterestEarned.setCellFactory(column ->{
            var cell = new CustomTableCellState("00,000.00");
            return cell;
        });
        tcEndingBalance.setCellFactory(column ->{
            var cell = new CustomTableCellState();
            return cell;
        });*/

    }



    @FXML
    void process(ActionEvent event) {
        tvRetirement.getItems().clear();
        String strYears = txtYears.getText();
        int years = Integer.parseInt(strYears);
        populateTable(years);

        lbNo.setText(txtYears.getText());
        lbStart.setText("$"+ getTotal("start"));
        lbYear.setText("$"+ getTotal("year"));
        lbInterest.setText("$"+ getTotal("interest"));
        lbEnding.setText("$"+ getTotal("ending"));
    }


    public float getTotal(String getRetirement){
        float totalPrice = 0;
        if (getRetirement.equals("start")){
            totalPrice = tvRetirement.getItems().stream().map(
                    Year::getStartingBalance).reduce(totalPrice, Float::sum);
            return totalPrice;
        }else if (getRetirement.equals("year")){
            totalPrice = tvRetirement.getItems().stream().map(
                    Year::getYearlyDeposit).reduce(totalPrice, Float::sum);
            return totalPrice;
        }else if (getRetirement.equals("interest")){
            totalPrice = tvRetirement.getItems().stream().map(
                    Year::getInterestEarned).reduce(totalPrice, Float::sum);
            return totalPrice;
        }else if (getRetirement.equals("ending")){
            totalPrice = tvRetirement.getItems().stream().map(
                    Year::getEndingBalance).reduce(totalPrice, Float::sum);
            return totalPrice;
        }else{
            return totalPrice;
        }
    }
}