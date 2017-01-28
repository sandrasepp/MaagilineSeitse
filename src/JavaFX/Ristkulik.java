package JavaFX;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * Küsi kasutajalt alguskordinaadid ja laius-kõrgus ning joonista talle ristkülik.
 * Küsi kasutajalt sisendit kuidas soovid, pealselt, et teed seda JavaFXis.
 */
public class Ristkulik extends Application {
    int windowSize = 500;
    Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        askRectangle();
    }

    private void askRectangle() {
        primaryStage.setTitle("Enter rectangle params");

        GridPane root = new GridPane();
        root.setMinSize(300, 180);
        root.setAlignment(Pos.CENTER);
        root.setVgap(5);
        root.setHgap(10);

        root.add(new Label("X"), 0, 0);
        root.add(new Label("Y"), 0, 1);
        root.add(new Label("Width"), 0, 2);
        root.add(new Label("Height"), 0, 3);

        TextField x = new TextField("10");
        TextField y = new TextField("10");
        TextField width = new TextField("100");
        TextField height = new TextField("200");

        Button submit = new Button("OK");
        submit.setOnAction(e -> {
            showRectangle(new Rectangle(
                    Integer.parseInt(x.getText()),
                    Integer.parseInt(y.getText()),
                    Integer.parseInt(width.getText()),
                    Integer.parseInt(height.getText())
            ));
        });

        root.add(x, 1, 0);
        root.add(y, 1, 1);
        root.add(width, 1, 2);
        root.add(height, 1, 3);
        root.add(submit, 0, 4);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void showRectangle(Rectangle rectangle) {
        primaryStage.setTitle("Here is your rectangle, take it or leave it");
        Group root = new Group();
        root.getChildren().add(rectangle);

        primaryStage.setScene(new Scene(root, windowSize, windowSize));
        primaryStage.show();
    }
}
