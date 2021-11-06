package edu.citytech.growthrate;

import edu.citytech.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.text.DecimalFormat;

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
            txtyears.setStyle("-fx-border-color:red");
            return;
        }
        if (txtending.getText().isEmpty()){
            rate.setText("Enter a value in the Text Field");
            txtending.setStyle("-fx-border-color:red");
            return;
        }
        if (txtbeginning.getText().isEmpty()){
            rate.setText("Enter a value in the Text Field");
            txtbeginning.setStyle("-fx-border-color:red");
            return;
        }
        if (txtTotal.getText().isEmpty()) {
            rate.setText("Enter a value in the Text Field");
            txtTotal.setStyle("-fx-border-color:red");
            return;
        }

        try{
        double years= Double.parseDouble(txtyears.getText());
        double endValue= Double.parseDouble(txtending.getText());
        double startValue= Double.parseDouble(txtbeginning.getText());
        double totalDiv= Double.parseDouble(txtTotal.getText());

        var result = GrowthRate.getGrowRate(years,endValue,startValue,totalDiv);
        DecimalFormat df = new DecimalFormat("#%");

        rate.setText("Rate of return is "+df.format(result)+" or "+result);
        rate.setStyle("-fx-text-fill: blue;");

        txtyears.setStyle("-fx-border-color: #25eb67;");
        txtending.setStyle("-fx-border-color: #25eb67;");
        txtbeginning.setStyle("-fx-border-color: #25eb67;");
        txtTotal.setStyle("-fx-border-color: #25eb67;");

        System.out.println(result);
        }catch (Exception e){
            rate.setText("Invalid input, only numbers, please");
            rate.setStyle("-fx-text-fill: red;");
        }

    }


    @FXML
    void handle(KeyEvent event) {

        String years= txtyears.getText();
        String endValue= txtending.getText();
        String startValue= txtbeginning.getText();
        String totalDiv= txtTotal.getText();

        if(isValid(years)){
            txtyears.setStyle("-fx-border-color:red");
            rate.setText("Invalid input");
            rate.setStyle("-fx-text-fill: red;");
        }else if(isValid(endValue)){
            txtending.setStyle("-fx-border-color:red");
            rate.setText("Invalid input");
            rate.setStyle("-fx-text-fill: red;");
        }else if(isValid(startValue)){
            txtbeginning.setStyle("-fx-border-color:red");
            rate.setText("Invalid input");
            rate.setStyle("-fx-text-fill: red;");
        }else if(isValid(totalDiv)){
            txtTotal.setStyle("-fx-border-color:red");
            rate.setText("Invalid input");
            rate.setStyle("-fx-text-fill: red;");
        }else {
            txtyears.setStyle("");
            txtending.setStyle("");
            txtbeginning.setStyle("");
            txtTotal.setStyle("");
            rate.setText("");
        }


    }
    public boolean isValid(String s){
        String regex="\\d{0,9}([\\.]\\d{0,7})?";
        return !s.matches(regex);//returns true if input and regex matches otherwise false;
    }


}
