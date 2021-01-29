package funtimeswithjfx;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    private Slider slider;
    private TextField textField;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("I'm a graphic application");

        GridPane gridPane = new GridPane();

        textField = new TextField();
        gridPane.add(textField, 0, 0);

        slider = new Slider(-10, 10, 3);
        slider.setMinorTickCount(0);
        slider.setMajorTickUnit(1);
        slider.setSnapToTicks(true);

        gridPane.add(slider, 0, 1);

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);

        textField.textProperty().addListener(
                (observable,oldValue,newValue) -> System.out.println("T:" + newValue)
        );
        slider.valueProperty().addListener(
                ((observable, oldValue, newValue) -> System.err.println("S:" + newValue))
        );

        slider.setOnMouseReleased(
                event -> textField.setText(Double.toString(slider.getValue()))
        );
        textField.setOnAction(
                event -> slider.adjustValue(Double.parseDouble(textField.getText()))
        );

        primaryStage.show();
    }
}
