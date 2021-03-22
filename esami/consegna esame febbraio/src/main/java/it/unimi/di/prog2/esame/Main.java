package it.unimi.di.prog2.esame;

import it.unimi.di.prog2.esame.model.Question;
import it.unimi.di.prog2.esame.model.QuestionModel;
import it.unimi.di.prog2.esame.presenter.GeneralDisplayPresenter;
import it.unimi.di.prog2.esame.presenter.PersonalViewPresenter;
import it.unimi.di.prog2.esame.view.GeneralDisplayView;
import it.unimi.di.prog2.esame.view.PersonalView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

  public static final int NUM_QUESTIONS = 6;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Conference 2.0");

    PersonalView[] personal = new PersonalView[2];

    GeneralDisplayView display = new GeneralDisplayView();


    GridPane gridPane = new GridPane();
    gridPane.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    gridPane.setPadding(new Insets(10, 10, 10, 10));
    gridPane.add(display, 1, 0);
    for (int i = 0; i < 2; i++) {
      personal[i] = new PersonalView();
      gridPane.add(personal[i], i * 2, 0);
    }

    QuestionModel myModel = new QuestionModel();

    new PersonalViewPresenter(personal[0], myModel);
    new PersonalViewPresenter(personal[1], myModel);

    new GeneralDisplayPresenter(display, myModel);

    Scene scene = new Scene(gridPane);

    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
