package JavaFX;

/**
 * Created by aleksandra on 28/01/2017.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Joonista ring, mille värvi saab kasutaja muuta
 */
public class RingiVarv extends Application {
    private Circle circle;
    ColorPicker colorPicker = new ColorPicker();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage stage = new Stage();
        StackPane stackPane = new StackPane();
        BorderPane borderPane = new BorderPane();
        stackPane.getChildren().addAll(borderPane);
        Scene scene = new Scene(stackPane, 500, 500);
        stage.setScene(scene);

        circle = new Circle(40);
        circle.setFill(Color.BLUE);
        circle.setStroke(Color.DARKBLUE);
        stackPane.getChildren().addAll(circle);

        colorPicker.setOnAction(event -> {
            Color color = colorPicker.getValue();
            circle.setFill(color);
        });
        borderPane.setBottom(colorPicker);

        stage.show();
    }
}