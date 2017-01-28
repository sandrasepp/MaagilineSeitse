package JavaFX;

/**
 * Created by aleksandra on 28/01/2017.
 */
        import javafx.application.Application;
        import javafx.geometry.Pos;
        import javafx.scene.Scene;
        import javafx.scene.control.Label;
        import javafx.scene.layout.Pane;
        import javafx.scene.paint.Color;
        import javafx.scene.shape.Circle;
        import javafx.stage.Stage;


/**
 * Loo JavaFXis koristaja mäng.
 * 1. Ekraan (näiteks 500x500) on paksult ringe täis. Nii, et läbi ei näe.
 * 2. Ringile hiirega vastu minnes kaob ring ära.
 * 3. Ringide all on peidus sõnum (näiteks Labeliga), mida kasutaja lõpuks näeb.
 */
public class Koristaja extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);
        Label lb = new Label("Kyikidele kysimustele on universaalne vastus 42!");
        pane.getChildren().add(lb);
        lb.setAlignment(Pos.CENTER);
        lb.setLayoutX(100);
        lb.setLayoutY(250);

        primaryStage.show();

        //Circle circle; // = new Circle(x, y, 50);
        for(int i= 0; i<500; i++){
            double x = Math.round(Math.random()*500);
            double y = Math.round(Math.random()*500);
            Circle circle = new Circle(x, y, 50);
            circle.setFill(Color.GRAY);
            pane.getChildren().add(circle);
            circle.setOnMouseEntered(e-> {
                pane.getChildren().remove(circle); //.setOpacity(0);
            });
        }
    }
}
