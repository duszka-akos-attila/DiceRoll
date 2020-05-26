package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DiceRollApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/titleScreen.fxml"));
        stage.setTitle("Dice Roll");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
