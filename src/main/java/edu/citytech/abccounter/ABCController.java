package edu.citytech.abccounter;

import com.jbbwebsolutions.http.utility.JSONGet;
import edu.citytech.MainController;
import edu.citytech.abccounter.model.Model;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;

public class ABCController extends MainController implements Initializable {

    @FXML
    private GridPane gridABC;

    @FXML
    private Text first;

    @FXML
    private Text second;

    @FXML
    private Text third;

    @FXML
    private ToggleGroup tgMode;

    @FXML
    private ComboBox<Model> cbHighlight;

//    @FXML
//    private AnchorPane anchorPane;

    @FXML
    void selectionMode(ActionEvent event) {
        Node node = (Node)event.getSource();

        if (node.getUserData().toString().equals("Z")){
            alphabets(true);
            load(true);
//            loadABCOptions();
        }else if (node.getUserData().toString().equals("A")) {
            alphabets(false);
            load(true);
//            loadABCOptions();
        }else if(node.getUserData().toString().equals("1")){
            numbers(false);
            load(false);
//            load123Options();
        }else if(node.getUserData().toString().equals("3")){
            numbers(true);
            load(false);
//            load123Options();
        }else if(node.getUserData().toString().equals("5")){
            $51015(false);
            load(false);
//            load123Options();
        }
        else if(node.getUserData().toString().equals("15")){
            $51015(true);
            load(false);
//            load123Options();
        }
        System.out.println(node.getUserData().toString());

    }

     
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        alphabets(false);
        load(true);

    }

    public void load(boolean abc){

        ArrayList<Model> list = new ArrayList<Model>();
        list.add(new Model("n", "none"));
        if (abc){
            list.add(new Model("v", "vowel"));
            list.add(new Model("c", "consonant"));
        }else{
            list.add(new Model("e", "even numbers"));
            list.add(new Model("o", "odd numbers"));
            list.add(new Model("6", "every 6 numbers"));
            list.add(new Model("con", "contains #4 or 9"));
        }
        var $123List = FXCollections.observableArrayList(list);
        cbHighlight.setItems($123List);

        var stage = super.anchorPane.getScene();
        super.anchorPane.setMinHeight(573);
    }

    public void alphabets(boolean reverse) {

        String sURL = "http://localhost:9615/alphabets/abc";
        var abc = JSONGet.submitGet(sURL, String[].class);
        if (reverse){
            Arrays.sort(abc, Collections.reverseOrder());
            first.setText("C"); second.setText("B"); third.setText("A");
        }else{
            first.setText("A"); second.setText("B"); third.setText("C");
        }
        System.out.println(Arrays.toString(abc));
        gridABC.getChildren().clear();
        int column = 0, row = 0;
        for (var x: abc){
            Button btn = new Button(x);
            btn.getStyleClass().add("abc");
            gridABC.add(btn,column++,row);
            if (column >3){
                row++;
                column = 0;
            }
        }

    }
    public void numbers(boolean reverse) {
        String nURL = "http://localhost:9615/numbers/123";
        var num = JSONGet.submitGet(nURL, Integer[].class);

        if (reverse){
            Arrays.sort(num, Collections.reverseOrder());
            first.setText("3"); second.setText("2"); third.setText("1");
        }else{
            first.setText("1"); second.setText("2"); third.setText("3");
        }
        System.out.println(Arrays.toString(num));
        gridABC.getChildren().clear();
        int column = 0, row = 0;
        for (var x: num){
            Button btn = new Button(x.toString());
            btn.getStyleClass().add("num");
            gridABC.add(btn,column++,row);
            if (column >7){
                row++;
                column = 0;
            }
        }
    }
    public void $51015(boolean reverse) {
        String nURL = "http://localhost:9615/numbers/123";
        var num = JSONGet.submitGet(nURL, Integer[].class);

        if (reverse){
            Arrays.sort(num, Collections.reverseOrder());
            first.setText("15"); second.setText("10"); third.setText("5");
        }else{
            first.setText("5"); second.setText("10"); third.setText("15");
        }
        System.out.println(Arrays.toString(num));
        gridABC.getChildren().clear();
        int column = 0, row = 0;
        for (var x: num){
            var n = x*5;
//            if (reverse){
//                n=n*3;
//            }
            Button btn = new Button(n+"");
            btn.getStyleClass().add("num");
            gridABC.add(btn,column++,row);
            if (column >7){
                row++;
                column = 0;
            }
        }
    }
    @FXML
    void highLightAction(ActionEvent event) {

        var selectedModel = cbHighlight.getSelectionModel();
        var current = selectedModel.getSelectedItem();
        if (current==null){
            System.out.println("Next Checkbox...");
            return;
        }
            System.out.println(current.getMode() + " " + current.getDescription());

        var buttons = gridABC.getChildren().stream().map(e -> (Button)e).toList();//{100,99,98,........0}

        for (Button b :buttons) {
            b.getStyleClass().removeAll("highLight");
        }

        if(current.getMode().equals("n"))
            for (Button b :buttons) {
                b.getStyleClass().removeAll("highLight");
            }

        if(current.getMode().equals("v"))
            for (Button b :buttons) {
                if(ABCService.isVowel(b.getText())){
                    b.getStyleClass().add("highLight");
                }
            }


        if(current.getMode().equals("c"))
            for (Button b :buttons) {
                if(ABCService.isConsonant(b.getText())){
                    b.getStyleClass().add("highLight");
                }
            }

        //-----------Numbers---------------

        if(current.getMode().equals("e"))
            for (Button b :buttons) {
                if(ABCService.isEven(b.getText())){
                    b.getStyleClass().add("highLight");
                }
            }

        if(current.getMode().equals("o"))
            for (Button b :buttons) {
                if(ABCService.isOdd(b.getText())){
                    b.getStyleClass().add("highLight");
                }
            }

        if(current.getMode().equals("6"))
            for (Button b :buttons) {
                if(ABCService.isEvery$6(b.getText())){
                    b.getStyleClass().add("highLight");
                }
            }
        if(current.getMode().equals("con"))
            for (Button b :buttons) {
                if(ABCService.isContains$4or9(b.getText())){
                    b.getStyleClass().add("highLight");
                }
            }

    }
}



