package edu.citytech.states.model;

import edu.citytech.MainController;
import edu.citytech.states.TriStateDataLayer;
import edu.citytech.states.customTableCell.CustomTableCellState;
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
import java.util.stream.Collectors;


public class TriStateControllerOtherWay extends MainController implements Initializable {


    @FXML
    private PieChart pieTriState;

    @FXML
    private TableView<Property> tvStateInfo;

    @FXML
    private Button btnRefresh;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblTitleState;

    @FXML
    private Label lblMessage;

    @FXML
    private FlowPane fpStates;

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

    HashSet<String> set = new HashSet<>();

    TriState[] gList = TriStateDataLayer.getData();
    Predicate<TriState> nyTriState = x -> x.getState().equals("CT") ||
            x.getState().equals("NJ") || x.getState().equals("NY");


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.refreshData(e -> true);
        btnRefresh.setVisible(true);
        this.refreshPie(nyTriState);
        this.pieTriState.getData().forEach(this::clickOnPie);

        Arrays.stream(gList).forEach(e -> {
            var checkBox = new CheckBox(e.getState());
            checkBox.setPrefSize(60, 15);
            this.fpStates.getChildren().add(checkBox);

            format();

            EventHandler applyEvent = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    var count = 0;
                    var getCheckBox = fpStates.getChildren();
                    for (Node n : getCheckBox) {
                        if (event.getSource() instanceof CheckBox) {
                            CheckBox checkBox = (CheckBox) n;

                            if (checkBox.isSelected()) {
                                System.out.println(checkBox.getText());
                                if(!set.contains(checkBox.getText())){
                                    set.add(checkBox.getText());
                                }
                                count++;
                                if (count < 2 || count > 4) {
                                    btnRefresh.setVisible(false);
                                    lblMessage.setText("Incorrect Amount of states. Choose only 2 - 4 states.");
                                } else {
                                    btnRefresh.setVisible(true);
                                    lblMessage.setText("");
                                }
                            }else{
                                set.remove(checkBox.getText());
                            }

                        }
                    }
                }
            };
            checkBox.setOnAction(applyEvent);
        });
    }

    void refreshPie (Predicate<TriState> nyTriState){

        pieTriState.getData().clear();
        var list = TriStateDataLayer.getData();
        var listPie = Arrays.stream(list).filter(nyTriState).toList();
        for (var property : listPie) {
            PieChart.Data slice = new PieChart.Data(property.getState(), property.getSumOfNetIncome());
            pieTriState.getData().add(slice);
        }
    }

    void refreshData(Predicate<Property> predicate) {

        tvStateInfo.getItems().clear();

        var properties = TriStateDataLayer.getPropertiesData();
        var listOfProperties = Arrays.stream(properties).filter(predicate)
                .collect(Collectors.toList());
        ObservableList<Property> oList = tvStateInfo.getItems();
        oList.addAll(listOfProperties);
    }


    void format() {

        tcCost.setCellFactory(column -> {
            var cell = new CustomTableCellState("##,###.00");
            return cell;

        });

        tcNetIncome.setCellFactory(column -> {
            var cell = new CustomTableCellState("##,###.00");
            return cell;

        });

        tcPercentage.setCellFactory(column -> {
            var cell = new CustomTableCellState("#%");
            return cell;

        });

    }

    void clickOnPie(PieChart.Data data) {

        EventHandler<MouseEvent> eventHandler = evt -> {
            System.out.println(evt);
            System.out.println("name: " + data.getName());
            System.out.println("pieValue: " + data.getPieValue());

            lblTitleState.setText((data.getName()));

            Predicate<Property> predicate = e -> e.getState().equals(data.getName());

            this.refreshData(predicate);

        };
        data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    @FXML
    void onClick(ActionEvent event) {
        nyTriState = e->false;
        for (var node : set) {
            Predicate<TriState> item = e -> e.getState().equals(node);
            nyTriState=nyTriState.or(item);
        }
        System.out.println(set.size());
        this.refreshPie(nyTriState);
        this.refreshData(e->true);
        this.pieTriState.getData().forEach(this::clickOnPie);
    }
}

