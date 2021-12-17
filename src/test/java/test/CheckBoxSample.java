package test;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxSample extends Application {

    final String[] names = new String[]{"A", "B", "C"};
    final CheckBox[] cbs = new CheckBox[names.length];

    @Override//    w w   w  .  d e  m  o  2   s . c    o  m
    public void start(Stage primaryStage) {
        for (int i = 0; i < names.length; i++) {
            final CheckBox cb = cbs[i] = new CheckBox("CheckBox " + names[i]);
            cb.setOnAction((ActionEvent event) -> {
                if (cb.isSelected()) {
                    System.out.println(cb.getText() + " is ON.");
                } else {
                    System.out.println(cb.getText() + " is OFF.");
                }
            });
        }
        VBox vbox = new VBox();
        vbox.getChildren().addAll(cbs);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(5, 5, 5, 5));

        StackPane root = new StackPane();
        root.getChildren().add(vbox);

        Scene scene = new Scene(root);

        primaryStage.setTitle("CheckBoxSample");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
