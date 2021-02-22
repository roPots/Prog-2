package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.controller.Controller;
import it.unimi.di.prog2.esame.model.Ticket;
import it.unimi.di.prog2.esame.observer.Observer;
import it.unimi.di.prog2.esame.observer.Subject;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneralDisplayView extends Region implements TicketView, Observer<Ticket> {
  public static int QUEUE_LEN = 4;
  private int index;
  private final ArrayList<Label> bigliettiChiamati = new ArrayList<>();
  private List<String> calls = new ArrayList<>();

  public GeneralDisplayView() {
    setBackground(new Background(
        new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(5.0), Insets.EMPTY)));
    setBorder(new Border(
        new BorderStroke(null, BorderStrokeStyle.SOLID, new CornerRadii(5.0), new BorderWidths(2))));

    GridPane grid = new GridPane();
    for (int i = 0; i < QUEUE_LEN; i++) {
      Label label = new Label();
      label.setFont(Font.font("Courier", 30));
      label.setText("S-- XX");
      bigliettiChiamati.add(label);
      grid.add(label, 0, i);
    }
    this.getChildren().add(grid);
  }

  @Override
  public void addHandler(Controller handler) {}

  @Override
  public void set(String s) {
    // TODO sicuramente da implementare

    Collections.reverse(calls);
    calls.add(s); // il display non si deve aggiornare quando si prende un ticket dal dispenser
    Collections.reverse(calls);

    for (int i = 0; i < QUEUE_LEN; i++) {
      if (calls.size() > i) bigliettiChiamati.get(i).setText(calls.get(i));
    }

  }

  @Override
  public String getIdView() {
    return getId();
  }

  @Override
  public void update(Subject<Ticket> model) {
    String idOffice = model.getState().getIdOffice();
    String ticketCalled = String.valueOf(model.getState().getNext());
    String s = "S"+ idOffice+ " "+ticketCalled;

    if (idOffice != null && !calls.contains(s)) this.set(s);

  }
}
