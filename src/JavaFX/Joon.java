package JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


/**
 * Küsi kasutajalt alguse ja lõpu x-y kordinaadid ning joonista talle joon.
 * Akna võime limiteerida 500x500 piksli peale.
 * Küsi kasutajalt sisendit kuidas soovid, pealselt, et teed seda JavaFXis.
 */
public class Joon extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 500, 500);


        Kasutajaliides k1 = new Kasutajaliides(pane);
        TextField textfield = new TextField();
        Button submit = new Button("Joonista");
        submit.setDefaultButton(true);
        submit.setLayoutX(170);

        submit.setOnAction(event -> {
                    // küsida input
                    String input = textfield.getText();

                    //lahutada numbrid
                    String[] k = input.split("-");
                    int[] intK = new int[4];
                    for (int i = 0; i < k.length; i++) {
                        intK[i] = Integer.parseInt(k[i]);
                    }
                    //joonistada joon
                    Line line = new Line(intK[0], intK[1], intK[2], intK[3]);
                    pane.getChildren().add(line);

                    System.out.println("action");
                }
        );
        pane.getChildren().addAll(textfield, submit);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class Kasutajaliides {
        public Kasutajaliides(Pane pane) {

        }
    }
}
