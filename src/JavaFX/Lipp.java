package JavaFX;

/**
 * Created by aleksandra on 28/01/2017.
 * /**
 * 1. Joonista eesti lipp kasutades kolme Rectangle
 * 2. Joonista Jaapani lipp kasutades Rectangle ja Circle
 */


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Lipp extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        eestiLipp();   //Refractory/Extract/Method viisil saadud Ctr+Alt+M
        jaapaniLipp();
    }

    private void jaapaniLipp() {
        Stage stage1 = new Stage();
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 500,300);
        stage1.setScene(scene);

        Rectangle kast = new Rectangle(0, 0, 500, 300); //alx, algy, lõppx, lõppy
        kast.setFill(Color.WHITE);
        pane.getChildren().add(kast);

        Circle ring = new Circle(250, 150, 100);
        ring.setFill(Color.RED);
        pane.getChildren().add(ring);

        stage1.show();
    }

    private void eestiLipp() {
        Stage stage = new Stage();
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 500,300);
        stage.setScene(scene);

        Rectangle kast = new Rectangle(0, 0, 500, 100); //alx, algy, lõppx, lõppy
        kast.setFill(Color.BLUE);
        pane.getChildren().add(kast);
        Rectangle kast1 = new Rectangle(0, 100, 500, 100);
        kast1.setFill(Color.BLACK);
        pane.getChildren().add(kast1);
        Rectangle kast2 = new Rectangle(0, 200, 500, 100);
        kast2.setFill(Color.WHITE);
        pane.getChildren().add(kast2);

        stage.show();
    }

}
