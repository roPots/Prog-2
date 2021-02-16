package it.unimi.di.prog2.esame;

import it.unimi.di.prog2.esame.model.Model;
import it.unimi.di.prog2.esame.presenter.ConcretePresenter;
import it.unimi.di.prog2.esame.presenter.Dispenser;
import it.unimi.di.prog2.esame.presenter.GeneralDisplay;
import it.unimi.di.prog2.esame.presenter.Sportello;
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

    Model model = new Model();

    DispenserView dispenser = new DispenserView();
    ConcretePresenter dispControl = new ConcretePresenter(dispenser, model, Dispenser.INSTANCE);

    GeneralDisplayView display = new GeneralDisplayView();
    ConcretePresenter generaldispControl = new ConcretePresenter(display, model, GeneralDisplay.INSTANCE);

    SportelloView desk1 = new SportelloView();
    ConcretePresenter desk1control = new ConcretePresenter(desk1,model, new Sportello("01"));
    SportelloView desk2 = new SportelloView();
    ConcretePresenter desk2control = new ConcretePresenter(desk2, model, new Sportello("02"));

    GridPane gridPane = new GridPane();
    gridPane.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

    gridPane.add(new Label("Dispenser"), 0, 0); // (mostra il numero del prossimo ticket disponibile
    gridPane.add(dispenser, 0, 1);
    gridPane.add(new Label("Display"), 0, 2); // (mostra gli ultimi 4 ticket presi in carico e da quale sportello)
    gridPane.add(display, 0, 3);
    gridPane.add(new Label("Sportelli"), 0, 4); // (mostra quali sportelli hanno in carico quale ticket)
    gridPane.add(desk1, 0, 5);
    gridPane.add(desk2, 2, 5);

    Scene scene = new Scene(gridPane);

    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
