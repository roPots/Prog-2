package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.controller.Controller;
import it.unimi.di.prog2.esame.model.Ticket;
import it.unimi.di.prog2.esame.observer.Subject;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

public class GeneralDisplayView extends Region implements TicketView {
  public static final int QUEUE_LEN = 4;
  private final ArrayList<Label> bigliettiChiamati = new ArrayList<>();

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
  public void addHandler(Controller handler) {

  }

  @Override
  public void set(String s) {
    List<String> last4 = SportelloView.getLast4served();

    for (int i = 0; i < last4.size(); i++) {
      (bigliettiChiamati.get(i)).setText(last4.get(i));
    }
  }

  @Override
  public void update(Subject<Ticket> subj, Ticket state) {
    set(null);
    System.out.println(SportelloView.getLast4served());
  }
}
