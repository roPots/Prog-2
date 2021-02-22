package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.controller.Controller;
import it.unimi.di.prog2.esame.model.Model;
import it.unimi.di.prog2.esame.model.Ticket;
import it.unimi.di.prog2.esame.observer.Subject;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SportelloView extends Region implements TicketView {
  private final Label numero = new Label();
  private final Button bottone = new Button();
  private boolean serving = false;
  public static int QUEUE_LEN = 4;

  private static List<String> last4served = new ArrayList<>();

  public SportelloView(String id) {
    setId(id);
    numero.setText("S" + id + " XX");
    bottone.setText("CHIAMA");

    setBackground(new Background(
        new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(5.0), Insets.EMPTY)));
    setBorder(new Border(
        new BorderStroke(null, BorderStrokeStyle.SOLID, new CornerRadii(5.0), new BorderWidths(2))));

    numero.setFont(Font.font("Courier", 30));
    GridPane grid = new GridPane();
    grid.add(numero, 0, 0);
    grid.add(bottone, 0, 1);
    this.getChildren().add(grid);
  }

  @Override
  public void addHandler(Controller handler) {
    bottone.setOnMouseClicked(handler);
    bottone.setOnAction(event -> serving = true);
  }

  @Override
  public void set(String s) {
    numero.setText("S" + getId() + " " + s);

    newServing(numero.getText());
  }

  private static void newServing(String served) {
    last4served.add(served);
    if (last4served.size() > QUEUE_LEN) last4served.remove(0);
  }

  public static List<String> getLast4served() {
    List<String> temp = new ArrayList<>();
    for (String s : last4served) {
      temp.add(s);
    }
    return temp;
  }

  @Override
  public void update(Subject<Ticket> subj, Ticket state) {
    if (serving) { // !! PROBLEMA, se NextToServe fallisce, serving viene comunque sbloccato. aggiugnere return booleano a nexttoserve?
      set(String.valueOf(state.getNextToServe()));
      serving = false;
    }
  }
}
