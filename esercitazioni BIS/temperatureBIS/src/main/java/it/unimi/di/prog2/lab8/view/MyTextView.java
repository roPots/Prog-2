package it.unimi.di.prog2.lab8.view;

import it.unimi.di.prog2.lab8.controller.MyController;
import it.unimi.di.prog2.lab8.observer.Observer;
import it.unimi.di.prog2.lab8.observer.Subject;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MyTextView extends TextField implements TemperatureView, Observer<Double> {
    private final ScaleStrategy scale;

    public MyTextView(ScaleStrategy scale) {
        this.scale = scale;
    }

    @Override
    public void addListener(MyController controller) {
        this.setOnAction(controller);
    }

    @Override
    public double getTempValue() {
        return scale.valueToCelsius(Double.parseDouble(getText()));
    }

    @Override
    public void update(Subject<Double> subject, Double state) {
        setText(String.valueOf(scale.valueFromCelsius(subject.getState())));
    }
}
