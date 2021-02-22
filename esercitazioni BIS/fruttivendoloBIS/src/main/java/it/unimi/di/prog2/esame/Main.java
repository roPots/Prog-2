package it.unimi.di.prog2.esame;

import it.unimi.di.prog2.esame.controller.Controller;
import it.unimi.di.prog2.esame.model.TicketModel;
import it.unimi.di.prog2.esame.view.ClerkRole;
import it.unimi.di.prog2.esame.view.CustomerRole;
import it.unimi.di.prog2.esame.view.DisplayView;
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
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Fruttivendolo");

    TicketModel model = new TicketModel();

    DisplayView dispenser1 = new DisplayView("GET TICKET");
    DisplayView dispenser2 = new DisplayView("GET TICKET");

    DisplayView commesso1 = new DisplayView("SERVE");
    new Controller(model, dispenser1, CustomerRole.INSTANCE);
    new Controller(model, dispenser2, CustomerRole.INSTANCE);
    new Controller(model, commesso1, ClerkRole.INSTANCE);

    GridPane gridPane = new GridPane();
    gridPane.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    gridPane.add(dispenser1, 0, 0);
    gridPane.add(dispenser2, 2, 0);
    gridPane.add(commesso1, 1, 2);

    Scene scene = new Scene(gridPane);

    primaryStage.setScene(scene);
    primaryStage.show();

    // IL MODELLO NOTIFICA TUTTE LE VISTE PER INIZIALIZZARLE
    model.notifyObservers();
  }
}
