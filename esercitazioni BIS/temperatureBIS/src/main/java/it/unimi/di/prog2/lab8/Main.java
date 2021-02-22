package it.unimi.di.prog2.lab8;

import it.unimi.di.prog2.lab8.controller.MyController;
import it.unimi.di.prog2.lab8.model.MyModel;
import it.unimi.di.prog2.lab8.view.CelsiusScale;
import it.unimi.di.prog2.lab8.view.FahrenheitScale;
import it.unimi.di.prog2.lab8.view.MyTextView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Lab08");

        GridPane gridPane = new GridPane();

        // TODO completare il test di integrazione
        // affinché venga esercitato MVC
        MyTextView celsiusField = new MyTextView(CelsiusScale.INSTANCE);
        MyTextView fahrenheitField = new MyTextView(FahrenheitScale.INSTANCE);

        MyModel model = new MyModel();
        model.addObserver(celsiusField);
        model.addObserver(fahrenheitField);

        gridPane.add(new Label("Celsius: "), 0, 0);
        gridPane.add(celsiusField, 1, 0);
        gridPane.add(new Label("Fahreneit: "), 0, 1);
        gridPane.add(fahrenheitField, 1, 1);


        MyController Ccontrol = new MyController(model,celsiusField);
        MyController Fcontrol = new MyController(model,fahrenheitField);

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
