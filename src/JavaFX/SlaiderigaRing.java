package JavaFX;

/**
 * Created by aleksandra on 28/01/2017.
 *//* Joonista ring, mille suurust saab kasutaja Slideriga muuta
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class SlaiderigaRing extends Application {
    Slider slider = new Slider();
    Circle ring;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage stage = new Stage();
        StackPane stackPane = new StackPane();
        BorderPane borderPane = new BorderPane();

        stackPane.getChildren().addAll(borderPane);
        Scene scene = new Scene(stackPane, 400, 400);
        stage.setScene(scene);

        ring = new Circle(40);
        ring.setFill(Color.BLUE);
        ring.setStroke(Color.DARKBLUE);
        stackPane.getChildren().addAll(ring);

        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(40);
        slider.setShowTickLabels(true);//numbrid on näha
        slider.setShowTickMarks(true);//kriipsud on näha
        slider.setMajorTickUnit(20);//kriipsude vahemaa
        slider.setMinorTickCount(1);// mitu väikest kriipsu on suurte vahel
        slider.valueProperty().addListener((observable, vanaVaartus, uusVaartus) -> {
            System.out.println("Uus väärtus on: " + uusVaartus.intValue());
            System.out.println("Uus väärtus on: " + uusVaartus.doubleValue());
            ring.setRadius(uusVaartus.doubleValue());
        });
        borderPane.setBottom(slider);

        stage.show();
    }
}