package it.unimi.di.prog2.esame;

import it.unimi.di.prog2.esame.controller.Controller;
import it.unimi.di.prog2.esame.controller.DispenserRole;
import it.unimi.di.prog2.esame.controller.SportelloRole;
import it.unimi.di.prog2.esame.model.Model;
import it.unimi.di.prog2.esame.view.SportelloView;
import it.unimi.di.prog2.esame.view.GeneralDisplayView;
import it.unimi.di.prog2.esame.view.DispenserView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Vaccineria 2.0");

    Model myModel = new Model();

    DispenserView dispenser = new DispenserView();
    myModel.addObserver(dispenser);
    new Controller(dispenser,myModel, DispenserRole.INSTANCE);

    GeneralDisplayView display = new GeneralDisplayView();
    myModel.addObserver(display);

    SportelloView front1 = new SportelloView("01");
    myModel.addObserver(front1);
    new Controller(front1,myModel, SportelloRole.INSTANCE);

    SportelloView front2 = new SportelloView("02");
    myModel.addObserver(front2);
    new Controller(front2,myModel, SportelloRole.INSTANCE);

    GridPane gridPane = new GridPane();
    gridPane.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    gridPane.add(dispenser, 0, 0);
    gridPane.add(new Label("Display"), 0, 1);
    gridPane.add(display, 0, 2);
    gridPane.add(new Label("Sportelli"), 0, 3);
    gridPane.add(front1, 0, 4);
    gridPane.add(front2, 2, 4);

    Scene scene = new Scene(gridPane);

    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
