package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class DisplayView extends Region implements TicketView {
  //TODO: dire se questa classe è immutabile e perché
  // no perchè gli oggetti attributi della classe non sono immutabili, infatti esistono dei metodi (come set()) che permettono di cambiare il valore della lable
  final Label numero = new Label();
  final Button bottone = new Button();

  public DisplayView(String s) {
    numero.setText("0");
    bottone.setText(s);
    setId(s);

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

  //TODO realizzare i metodi mancanti per soddisfare le interfacce implementate
  @Override
  public void addHandler(Controller handler) {
    bottone.setOnAction(handler);
  }

  @Override
  public void set(String s) {
    numero.setText(s);
  }

}
