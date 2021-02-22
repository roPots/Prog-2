package it.unimi.di.prog2.lab8.controller;

import it.unimi.di.prog2.lab8.model.Model;
import it.unimi.di.prog2.lab8.model.MyModel;
import it.unimi.di.prog2.lab8.view.ScaleStrategy;
import it.unimi.di.prog2.lab8.view.TemperatureView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MyController implements EventHandler<ActionEvent> {
  private final MyModel model;
  private final TemperatureView view;


  public MyController(MyModel model, TemperatureView view) {
    this.model = model;
    this.view = view;

    view.addListener(this);
  }

  public void updateModel() {
    model.setTemp(view.getTempValue());
  }

  @Override
  public void handle(ActionEvent event) {
    updateModel();
  }
}
