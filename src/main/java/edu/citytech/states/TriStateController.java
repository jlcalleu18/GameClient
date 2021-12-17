package edu.citytech.states;


import edu.citytech.MainController;
import edu.citytech.states.customTableCell.CustomTableCellState;
import edu.citytech.states.model.Property;
import edu.citytech.states.model.TriState;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.*;
import java.util.function.Predicate;

public class TriStateController extends MainController implements Initializable {

    @FXML
    private PieChart pieTriState;

    @FXML
    private TableView<Property> tvStateInfo;

    @FXML
    private TableColumn<Property, String> tcId;

    @FXML
    private TableColumn<Property, Float> tcCost;

    @FXML
    private TableColumn<Property, String> tcState;

    @FXML
    private TableColumn<Property, Float> tcPercentage;

    @FXML
    private TableColumn<Property, Float> tcNetIncome;

    @FXML
    private FlowPane fpStates;

    @FXML
    private Button btnRefresh;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblTitleState;

    @FXML
    private Label lblMessage;


    TriState[] gList = TriStateDataLayer.getData();
    ArrayList<String> selectedItem = new ArrayList<>();

    Predicate<TriState> nyTriState = x ->
            x.getState().equals("NY") ||
            x.getState().equals("NJ") ||
            x.getState().equals("CT");

    Predicate<TriState> triState = x -> false;
    Predicate<Property> predicate = e -> false;
    int count =0;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("We made it");
        this.refreshData(e -> true);
        this.refreshPieChar(nyTriState);
        this.format();
        this.pieCharAdd();
        btnRefresh.setVisible(false);
        lblMessage.setText("Select between 2 and 4 states");


    }

    void pieCharAdd(){
        Arrays.stream(gList).forEach(e ->{
            CheckBox checkBox = new CheckBox(e.getState());
            checkBox.setPrefSize(60,15);
            this.fpStates.getChildren().add(checkBox);
            checkBox.setOnAction((ActionEvent event) -> {

                if (checkBox.isSelected()) {
                    selectedItem.add(checkBox.getText());
                    count++;
                    btnRefresh.setVisible(count >= 2 && count <= 4);
                    lblMessage.setVisible(count < 2 || count > 4);
                    System.out.println(checkBox.getText() + " is ON");
                } else {
                    selectedItem.remove(checkBox.getText());
                    count--;
                    btnRefresh.setVisible(count >= 2 && count <= 4);
                    lblMessage.setVisible(count < 2 || count > 4);
                    System.out.println(checkBox.getText() + " is OFF");
                }
            });

        });
        this.pieTriState.getData().forEach(this::clickOnPie);
    }

    void refreshPieChar (Predicate<TriState> triStates){

        //refreshing the pieChar
        pieTriState.getData().clear();
        var list = TriStateDataLayer.getData();
        var listStart = Arrays.stream(list).filter(triStates).toList();
        for (var property : listStart) {
            PieChart.Data slice = new PieChart.Data(property.getState(), property.getSumOfNetIncome());
            pieTriState.getData().add(slice);
        }
    }

    void refreshData(Predicate<Property> predicate){

        //refreshing the properties table
        tvStateInfo.getItems().clear();
        var properties = TriStateDataLayer.getPropertiesData();
        var listOfProperties = Arrays.stream(properties).filter(predicate).toList();
        ObservableList<Property> oList = tvStateInfo.getItems();
        oList.addAll(listOfProperties);
    }


    void format(){
        tvStateInfo.getColumns().stream().skip(1).forEach(tableColumn ->{
            tcCost.setCellFactory(c -> new CustomTableCellState("$##,###.00"));
            tcNetIncome.setCellFactory(c -> new CustomTableCellState("$##,###.00"));
            tcPercentage.setCellFactory(c -> new CustomTableCellState("#%"));
        });
    }

    void clickOnPie(PieChart.Data data){

        EventHandler<MouseEvent> eventHandler = evt -> {
            predicate = e -> e.getState().equals(data.getName());
            this.refreshData(predicate);
            lblTitleState.setText((data.getName()));
            System.out.format("Name: %s pieValue: %s \n",data.getName(), data.getPieValue());
        };

        data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    @FXML
    void btnOnClick(ActionEvent event) {
        triState = e->false;
        for (var items: selectedItem) {
            Predicate<TriState>  temp = x -> x.getState().equals(items);
            triState= triState.or(temp);
        }
        System.out.println(selectedItem.size());
        this.refreshData(e->true);
        this.refreshPieChar(triState);
        this.pieTriState.getData().forEach(this::clickOnPie);
    }
}
