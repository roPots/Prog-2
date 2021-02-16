package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.controller.Controller;
import it.unimi.di.prog2.esame.model.TicketModel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static junit.framework.TestCase.assertEquals;

public class IntegrationTest extends ApplicationTest {

  private DisplayView dispenser1;
  private DisplayView dispenser2;
  private DisplayView commesso1;

  @Override
  public void start(Stage stage) throws Exception {
    stage.setTitle("Fruttivendolo");

    TicketModel model = new TicketModel();

    dispenser1 = new DisplayView( "GET-disp1");
    dispenser2 = new DisplayView( "GET-disp2");

    commesso1 = new DisplayView("SERVE-disp3");

    new Controller(model, dispenser1, CustomerRole.INSTANCE);
    new Controller(model, dispenser2, CustomerRole.INSTANCE);
    new Controller(model, commesso1, ClerkRole.INSTANCE);

    GridPane gridPane = new GridPane();
    gridPane.add(dispenser1, 0, 0);
    gridPane.add(dispenser2, 0, 1);
    gridPane.add(commesso1, 0, 3);

    Scene scene = new Scene(gridPane);
    stage.setScene(scene);
    stage.show();

    // IL MODELLO NOTIFICA A TUTTE LE VISTE REGISTRATE LA SITUAZIONE INIZIALE
    model.notifyObservers();
  }

  @Test
  public void integrationTest() {
    clickOn(getBottone("GET-disp1"));
    clickOn(getBottone("GET-disp2"));
    clickOn(getBottone("GET-disp1"));

    assertEquals("3", getLabel("GET-disp2").getText());

    clickOn(getBottone("SERVE-disp3"));
    clickOn(getBottone("SERVE-disp3"));

    assertEquals("2", getLabel("SERVE-disp3").getText());

    clickOn(getBottone("SERVE-disp3"));
    clickOn(getBottone("SERVE-disp3"));

    assertEquals("3", getLabel("SERVE-disp3").getText());
  }

  private Labeled getLabel(String id) {
    return lookup("#"+id+" .label").queryLabeled();
  }

  private Button getBottone(String id) {
    return lookup("#"+ id +" .button").queryButton();
  }
}