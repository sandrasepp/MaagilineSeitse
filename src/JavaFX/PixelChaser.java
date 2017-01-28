package JavaFX;

/**
 * Created by aleksandra on 28/01/2017.
 * Joonista ekraanile hunnik ristkülikuid, suvalistel positsioonidel. Ühe korra kastile klikates
 * muutub ta 2x väiksemaks. Teist korda klikates kaob ta sootuks.
 *
 * //** Lihtsam variant
 =>
 public class PixelChaser extends Application { @Override
 public void start(Stage primaryStage) throws Exception {

 Stage stage = new Stage();
 Pane pane = new Pane();
 Scene scene = new Scene(pane, 500, 500);
 stage.setScene(scene);

 for (int i = 0; i < 50; i++){

 Rectangle rect = new Rectangle((int)(Math.random()*500), (int)(Math.random()*500), 40, 40 );
 rect.setFill(Color.LIGHTBLUE);
 pane.getChildren().add(rect);

 rect.setOnMouseClicked(event ->{



 rect.setHeight(rect.getHeight()/2);
 rect.setWidth(rect.getWidth()/2);

 rect.setOnMouseClicked(event2 ->{

 rect.setVisible(false);

 });

 });
 }

 stage.show();


 }
 }


 */

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.util.Random;


public class PixelChaser extends Application {
    int maxSize = 80;
    int windowSize = 500;
    int rectCount = 100;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(getClass().getSimpleName());

        Group root = new Group();
        ObservableList<Node> children = root.getChildren();
        for (int i = 0; i < rectCount; i++) {
            children.add(createShape());
        }

        primaryStage.setScene(new Scene(root, windowSize, windowSize));
        primaryStage.show();
    }

    private Shape createShape() {
        ClickCountingRectangle rectangle = new ClickCountingRectangle();
        rectangle.setOnMouseClicked(me -> rectangle.onClick());
        return rectangle;
    }

    private class ClickCountingRectangle extends Rectangle {
        private boolean clicked;

        public ClickCountingRectangle() {
            Random r = new Random();
            setWidth(10 + r.nextInt(maxSize));
            setHeight(10 + r.nextInt(maxSize));
            setFill(new Color(r.nextDouble(), r.nextDouble(), r.nextDouble(), 1));
            setLayoutX(r.nextInt(windowSize));
            setLayoutY(r.nextInt(windowSize));
        }

        void onClick() {
            if (clicked) {
                ((Group) getParent()).getChildren().remove(this);
            } else {
                setHeight(getHeight() / 2);
                setWidth(getWidth() / 2);
                setLayoutX(getLayoutX() + getWidth() / 2);
                setLayoutY(getLayoutY() + getHeight() / 2);
                clicked = true;
            }
        }
    }

}



