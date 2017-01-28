package JavaFX;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Joonista 500x500 ekraanile hunnikuga punaseid ringe.
 * Kui hiir ringile vastu läheb, muutub ring roheliseks.
 * Kordan - ring muudab värvi juba hiire puudutusest, mitte klikist.
 */
public class FooridUnenaos extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage stage = new Stage();
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 500, 500);
        stage.setMaxHeight(500);
        stage.setMaxWidth(500);

        for (int i = 0; i < 100; i++) {
            Circle circle = new Circle((int) (Math.random() * 500), (int) (Math.random() * 500), 20);
            circle.setFill(Color.RED);

            pane.getChildren().add(circle);
            circle.setOnMouseEntered(event -> {

                circle.setFill(Color.GREEN);
            });

        }

        stage.setScene(scene);
        stage.show();
    }

}