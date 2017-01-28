package JavaFX;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Random;


/**
 * Joonista 500x500 ekraanile ring. Kui hiir ringile vastu läheb, leiab ring omale
 * uue koha. Ei pea animeerima ega midagi fäänsit. Lihtsalt ilmub uues kohas ja kõik.
 * Ehk hiirega saab ringi taga ajada. Kordan - ring leiab uue koha juba hiire puudutusest,
 * mitte klikist. Aga alustada võid muidugi klikist.
 */
public class Tagaajamine extends Application {
    int SIZE = 500;
    int RADIUS = 20;
    Circle circle;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(getClass().getSimpleName());

        Group root = new Group();
        root.getChildren().add(createCircle());

        primaryStage.setScene(new Scene(root, SIZE, SIZE));
        primaryStage.show();
    }

    private Circle createCircle() {
        circle = new Circle(RADIUS, Color.valueOf("ff8888"));
        circle.setOnMouseEntered(mouseEvent -> doMove());
        doMove();
        return circle;
    }

    private void doMove() {
        Random random = new Random();
        circle.setCenterX(random.nextInt(SIZE));
        circle.setCenterY(random.nextInt(SIZE));
    }

}
