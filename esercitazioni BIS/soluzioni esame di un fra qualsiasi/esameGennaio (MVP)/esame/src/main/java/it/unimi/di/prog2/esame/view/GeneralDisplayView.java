package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.presenter.Presenter;
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

public class GeneralDisplayView extends Region implements TicketView {
  public static int QUEUE_LEN = 4;
  private final ArrayList<Label> bigliettiChiamati = new ArrayList<>();
  private final List<String> calls = new ArrayList<>();

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
  public void addHandler(Presenter handler) {}

  @Override
  public void set(String s) {
    // TODO sicuramente da implementare
    if (!calls.contains(s)) {
      Collections.reverse(calls);
      calls.add(s);
      Collections.reverse(calls);

      for (int i = 0; i < QUEUE_LEN; i++) {
        if (calls.size() > i) bigliettiChiamati.get(i).setText(calls.get(i));
      }
    }
  }

  @Override
  public String getIdView() {
    return getId();
  }

}
