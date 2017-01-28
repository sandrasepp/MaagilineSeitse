package JavaFX;

/**
 * Created by aleksandra on 28/01/2017.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * Loo Label, mille sisu saab kasutaja TextFieldi kaudu muuta.
 */
public class MuutuvLabel extends Application {
    private Label label;
    private TextField textField;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage stage = new Stage();
        StackPane stackPane = new StackPane();
        BorderPane borderPane = new BorderPane();
        stackPane.getChildren().addAll(borderPane);
        Scene scene = new Scene(stackPane, 500, 500);
        stage.setScene(scene);

        label = new Label();
        label.setTextAlignment(TextAlignment.CENTER);
        stackPane.getChildren().addAll(label);

        textField = new TextField();
        textField.setPromptText("Sisesta siia midagi");
        textField.setOnAction(event -> {
            String tekst = textField.getText();
            label.setText(tekst);
        });
        borderPane.setBottom(textField);

        stage.show();
    }
}