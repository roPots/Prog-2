package it.unimi.di.prog2.lab8;

import it.unimi.di.prog2.lab8.controller.MyController;
import it.unimi.di.prog2.lab8.model.MyModel;
import it.unimi.di.prog2.lab8.view.CelsiusScale;
import it.unimi.di.prog2.lab8.view.FahrenheitScale;
import it.unimi.di.prog2.lab8.view.KelvinScale;
import it.unimi.di.prog2.lab8.view.MyTextView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Temperature Converter");

        GridPane grid = new GridPane();
        grid.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        MyModel model = new MyModel();
        MyTextView view1 = new MyTextView(model,CelsiusScale.INSTANCE,"Celsius");
        MyTextView view2 = new MyTextView(model, FahrenheitScale.INSTANCE,"Fahrenheit");
        MyTextView view3 = new MyTextView(model, KelvinScale.INSTANCE, "Kelvin");
        MyController controller1 = new MyController(model,view1);
        MyController controller2 = new MyController(model,view2);
        MyController controller3 = new MyController(model,view3);

        grid.add(view1,0,0);
        grid.add(view2,0,1);
        grid.add(view3,0,2);

        Scene myScene = new Scene(grid);
        primaryStage.setScene(myScene);

        primaryStage.show();
    }
}
