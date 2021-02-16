package it.unimi.di.prog2.esame;

import it.unimi.di.prog2.esame.view.FrontOfficeView;
import it.unimi.di.prog2.esame.view.GeneralDisplayView;
import it.unimi.di.prog2.esame.view.GetTicketView;
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

    GetTicketView dispenser = new GetTicketView();

    GeneralDisplayView display = new GeneralDisplayView();

    FrontOfficeView front1 = new FrontOfficeView("01");
    FrontOfficeView front2 = new FrontOfficeView("02");

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
