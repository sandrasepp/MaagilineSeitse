package JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;

/**
 * Tee JavaFXiga detektiivi mäng, kus kasutaja saab nähtamatuid ringe otsida.
 * 1. Ekraanil (näiteks 500x500) on suvalistes kohtades 3 ringi, mida näha ei ole.
 * 2. Hiirega ringile vastu minnes tuleb ring nähtavale.
 */
public class Detektiiv extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage stage = new Stage();
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 500, 500);
        stage.setMaxHeight(500);
        stage.setMaxWidth(500);

        for (int i = 0; i < 3; i++) {

            Circle circle = new Circle((int) (Math.random() * 500), (int) (Math.random() * 500), 40);
            circle.setFill(Color.TRANSPARENT);

            pane.getChildren().add(circle);
            circle.setOnMouseEntered(event -> {

                circle.setFill(Color.BLUEVIOLET);

            });


        }

        stage.setScene(scene);
        stage.show();
    }

}