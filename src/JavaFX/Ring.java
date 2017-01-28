package JavaFX;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Küsi kasutajalt x, y kordinaadid ja raadius ning joonista talle ring.
 * Küsi kasutajalt sisendit kuidas soovid, pealselt, et teed seda JavaFXis.
 */
public class Ring extends Application {
    int windowSize = 500;
    Stage primaryStage;

    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        askCircle ();
    }

    private void askCircle () {
        primaryStage.setTitle("Sisesta ringi parameetrid");

        GridPane root = new GridPane() ;



        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void showRectangle(Circle circle) {
        primaryStage.setTitle("Here is your circle, take it or leave it");
        Group root = new Group();
        root.getChildren().add(circle);

        primaryStage.setScene(new Scene(root, windowSize, windowSize));
        primaryStage.show();
    }
}
