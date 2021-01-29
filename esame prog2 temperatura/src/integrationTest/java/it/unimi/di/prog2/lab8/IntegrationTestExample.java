package it.unimi.di.prog2.lab8;

import static junit.framework.TestCase.assertEquals;

import it.unimi.di.prog2.lab8.controller.AbstractController;
import it.unimi.di.prog2.lab8.controller.MyController;
import it.unimi.di.prog2.lab8.model.MyModel;
import it.unimi.di.prog2.lab8.view.CelsiusScale;
import it.unimi.di.prog2.lab8.view.FahrenheitScale;
import it.unimi.di.prog2.lab8.view.MyTextView;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class IntegrationTestExample extends ApplicationTest {
  @Override
  public void start(Stage stage) throws Exception {
    stage.setTitle("Lab08");

    GridPane gridPane = new GridPane();

    // TODO completare il test di integrazione
    // affinché venga esercitato MVC

    Scene scene = new Scene(gridPane);
    stage.setScene(scene);
    stage.show();
  }

  @Test
  public void twoTextFieldWithDifferentStrategies() {
    doubleClickOn(celsiusField);
    write("100");
    press(KeyCode.ENTER);
    release(KeyCode.ENTER);
    assertEquals("212.00", fahrenheitField.getText());

    doubleClickOn(celsiusField);
    write("5.0");
    press(KeyCode.ENTER);
    release(KeyCode.ENTER);
    assertEquals("41.00", fahrenheitField.getText());

    doubleClickOn(fahreneitField);
    write("212");
    press(KeyCode.ENTER);
    release(KeyCode.ENTER);
    assertEquals("100.00", celsiusField.getText());
  }
}
