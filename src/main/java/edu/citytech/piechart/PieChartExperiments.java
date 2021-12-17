package edu.citytech.piechart;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PieChartExperiments extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("TriState Income");
        PieChart pieChart = new PieChart();


        var data = TriStateDataSource.getData();

/*
            //functional code
            data.forEach(realEstate -> {

            PieChart.Data slice = new PieChart.Data(realEstate.getState(), realEstate.getAmount());
            pieChart.getData().add(slice);

            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(slice);
            pieChartData.forEach(e ->
                    e.nameProperty().bind(
                            Bindings.concat(
                                    e.getName(), " ", e.pieValueProperty(), " "
                            )
                    )
            );
        });*/

        //procedural code
        for (var realEstate : data) {
            PieChart.Data slice = new PieChart.Data(realEstate.getState(), realEstate.getSumOfNetIncome());
            pieChart.getData().add(slice);
            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(slice);

            for (var e : pieChartData) {
                var bind = Bindings.concat(e.getName(), " ", e.pieValueProperty(), " ");
                e.nameProperty().bind(bind);
            }
        }


        VBox vbox = new VBox(pieChart);

        Scene scene = new Scene(vbox, 400, 200);

        primaryStage.setScene(scene);
        primaryStage.setHeight(450);
        primaryStage.setWidth(600);

        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}