package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.presenter.Presenter;
import it.unimi.di.prog2.esame.model.Ticket;
import it.unimi.di.prog2.esame.observer.Observer;
import it.unimi.di.prog2.esame.observer.Subject;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GetTicketView extends Region implements TicketView {
  private final Label numero = new Label("00");
  private final Button bottone = new Button("PRENDI");

  public GetTicketView(RoleStrategy strategy) {
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
  public String getIdView() {
    return getId();
  }

  @Override
  public void set(String s) {
    numero.setText(s);
  }

}
