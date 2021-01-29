package it.unimi.di.prog2.lab8.controller;

import it.unimi.di.prog2.lab8.model.Model;
import it.unimi.di.prog2.lab8.view.TemperatureView;
import javafx.event.ActionEvent;

public class MyController extends AbstractController {

    public MyController(Model model, TemperatureView view) {
        this.model = model;
        this.view = view;

        view.addListener(this);
    }

    @Override
    public void updateModel() {
       // nuthin bro..
    }


    @Override
    public void handle(ActionEvent event) {
        System.err.println("gotcha");
        model.setTemp(view.getTempValue());
    }
}
