package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.presenter.Presenter;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SportelloView extends Region implements TicketView {
  private final Label numero = new Label();
  private final Button bottone = new Button();

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
  public void addHandler(Presenter handler) {
    bottone.setOnAction(handler);
  }

  @Override
  public void set(String s) {
    numero.setText("S" + getId() + " " + s);
  }
}
