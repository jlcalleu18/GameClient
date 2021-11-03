package edu.citytech.tictactoe.growthrate;

import edu.citytech.tictactoe.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class GrowthController extends MainController {

    @FXML
    private Button btncalculate;

    @FXML
    private TextField txtyears;

    @FXML
    private TextField txtending;

    @FXML
    private TextField txtbeginning;

    @FXML
    private TextField txtTotal;

    @FXML
    private Label rate;

    @FXML
    void calculate(ActionEvent event) {
        if(txtyears.getText().isEmpty()){
            rate.setText("Enter a value in the Text Field");
            txtyears.getStyleClass().add("txt");
            return;
        }
        if (txtending.getText().isEmpty()){
            rate.setText("Enter a value in the Text Field");
            txtending.getStyleClass().add("txt");
            return;
        }
        if (txtbeginning.getText().isEmpty()){
            rate.setText("Enter a value in the Text Field");
            txtbeginning.getStyleClass().add("txt");
            return;
        }
        if (txtTotal.getText().isEmpty()) {
            rate.setText("Enter a value in the Text Field");
            txtTotal.getStyleClass().add("txt");
            return;
        }

        double years= Double.parseDouble(txtyears.getText());
        double endValue= Double.parseDouble(txtending.getText());
        double startValue= Double.parseDouble(txtbeginning.getText());
        double totalDiv= Double.parseDouble(txtTotal.getText());

        var result = GrowthRate.getGrowRate(years,endValue,startValue,totalDiv);
        DecimalFormat df = new DecimalFormat("#%");

        rate.setText("Rate of return is "+result+" or "+df.format(result));
        System.out.println(result);

    }
    @FXML
    void click(MouseEvent event) {
        rate.setText("");
        txtyears.getStyleClass().remove("txt");
        txtending.getStyleClass().remove("txt");
        txtbeginning.getStyleClass().remove("txt");
        txtTotal.getStyleClass().remove("txt");
    }

}
