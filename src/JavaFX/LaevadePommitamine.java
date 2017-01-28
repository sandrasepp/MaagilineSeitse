package JavaFX;

/**
 * Created by aleksandra on 28/01/2017.
 */

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * Joonista laevade pommitamine kasutades JavaFXi.
 */
public class LaevadePommitamine extends Application {
    GridPane laud;
    StackPane maailm;
    Stage stage;
    int laualTulpasid = 4;
    int laualRidasid = 4;
    int ruuduKylg = 50;
    double laevaToenaosus = 1.6; // suurem on tõenäosem
    Image laevaPilt = new Image("teema2/pirate.png");
    ImagePattern laevaMuster = new ImagePattern(laevaPilt);

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        seadistaStseen();
        genereeriLaevad();
        reageeriKlikile();

        primaryStage.show(); // Näita lava
    }


    private void seadistaStseen() {
        int piksleidLai = laualTulpasid * ruuduKylg;
        int piksleidKorge = laualRidasid * ruuduKylg;

        maailm = new StackPane(); //mänguvälja seadistused
        Rectangle taust = new Rectangle(piksleidLai, piksleidKorge);
        taust.setFill(Color.BLUE);
        maailm.getChildren().add(taust);

        laud = new GridPane();
        maailm.getChildren().add(laud);

        Scene scene = new Scene(maailm, piksleidLai, piksleidKorge);
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> System.exit(0));
    }

    private void genereeriLaevad() {
        int laevasid = 0;
        for (int i = 0; i < laualRidasid; i++) {
            for (int j = 0; j < laualTulpasid; j++) {
                Rectangle ruut = new Rectangle(ruuduKylg, ruuduKylg);
                int rand = (int) (Math.random() * laevaToenaosus);
                if (rand == 1) {
                    ruut.setId("laev");
                    laevasid++;
                } else {
                    ruut.setId("tyhi");
                }
                ruut.setFill(Color.rgb(0, 0, 0, 0));
                laud.add(ruut, j, i);
            }
        }
        System.out.println("Laevasid on " + laevasid);
    }

    private void reageeriKlikile() {
        //laevadOnOtsas();
        //gameOver();

        laud.setOnMouseClicked(event -> {
            Rectangle shape = (Rectangle) event.getTarget();
            Integer rida = GridPane.getRowIndex(shape);
            Integer tulp = GridPane.getColumnIndex(shape);
            String id = shape.getId();
            if (id == "laev") {
                shape.setId("pohjas");
                shape.setFill(Color.GREEN);
            }
            //if (laevadOnOtsas()){
            // gameOver();
            //}
            //ootad enne kirja
            if (laevadOnOtsas()) {
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        gameOver();
                    }
                }));
                timeline.play();
            }
        });

    }

    private void gameOver() {
        Label tekst = new Label("V6itsid!");
        StackPane stack = new StackPane();
        stack.getChildren().add(tekst);
        Scene stseen = new Scene(stack, 200, 200);
        stage.setScene(stseen);
    }

    private boolean laevadOnOtsas() {
        for (Node node : laud.getChildren()) {
            if (node.getId() == "laev") {
                return false;
            }
        }
        return true;
    }

}
