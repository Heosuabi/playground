package eu.scilled.playground;

import eu.scilled.javafx.util.Console;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class JavaFXStarter extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("simple.fxml"));

        Button button = new Button("Console");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage console = new Stage();
                console.initStyle(StageStyle.UTILITY);
                console.setTitle("Debug Console");
                console.setScene(new Scene(new Console()));
                console.show();
            }
        });
        Group root = new Group(button);

        stage.setTitle("FXML Test");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
