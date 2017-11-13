package com.company;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        ListView<Double> list = new ListView<>();
        ObservableList<Double> items = FXCollections.observableArrayList(
                0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0
        );
        list.setItems(items);
        list.setPrefSize(100, 70);
        Rectangle rectangle = new Rectangle(200, 200, Color.DARKBLUE);
        rectangle.setX(100);
        rectangle.setY(100);

        list.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> {
                    FadeTransition ft = new FadeTransition(Duration.seconds(0.5), rectangle);
                    if (oldValue == null) ft.setFromValue(1);
                    else ft.setFromValue(oldValue.doubleValue());
                    ft.setToValue(newValue.doubleValue());
                    ft.play();
                })
        );
        pane.getChildren().addAll(list, rectangle);
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
