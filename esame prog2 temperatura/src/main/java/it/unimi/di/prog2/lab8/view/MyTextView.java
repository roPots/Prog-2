package it.unimi.di.prog2.lab8.view;

import it.unimi.di.prog2.lab8.controller.AbstractController;
import it.unimi.di.prog2.lab8.model.MyModel;
import it.unimi.di.prog2.lab8.observer.Observer;
import it.unimi.di.prog2.lab8.observer.Subject;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MyTextView extends Region implements Observer, TemperatureView {
    private ScaleStrategy strategy;
    private TextField temperature = new TextField();
    private Label name;
    private Button enter = new Button("apply");

    public MyTextView(MyModel model, ScaleStrategy strategy, String name) {
       model.addObserver(this);
       this.strategy = strategy;
       this.name = new Label(name);

       //display
        setBackground(new Background(
                new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(5.0), Insets.EMPTY)));
        setBorder(new Border(
                new BorderStroke(null, BorderStrokeStyle.SOLID, new CornerRadii(5.0), new BorderWidths(2))));

        temperature.setFont(Font.font("Courier", 30));
        GridPane grid = new GridPane();
        grid.add(this.name,0,0);
        grid.add(temperature, 1, 0);
        grid.add(enter,0,1);

        this.getChildren().add(grid);
    }

    @Override
    public void update(Subject subject, Object state) {
        double newtemp = strategy.valueFromCelsius(((MyModel)subject).getTemp());
        temperature.setText(Double.toString(newtemp));
    }

    @Override
    public void addListener(AbstractController controller) {
        enter.setOnAction(controller);
    }

    @Override
    public double getTempValue() {
        return strategy.valueToCelsius(Double.parseDouble(temperature.getText()));
    }
}
