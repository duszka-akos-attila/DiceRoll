package main;

import game.DiceManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import result.Result;

/**
 * This class starts the Graphical User Interface, when called in the main.
 */

public class DiceRollApplication extends Application {

    private static final Logger logger = LoggerFactory.getLogger(DiceRollApplication.class);

    /**
     * The result variable represents the game's result, which is initialized here,
     * so it can be accessed from any GUI Scene.
     * {@link Result}
     */

    public static Result result;

    @Override
    public void start(Stage stage) throws Exception {
        logger.info("Starting the GUI with titleScreen!");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/titleScreen.fxml"));
        stage.setTitle("Dice Roll");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image(getClass().getResource("/pictures/b6.png").toExternalForm()));
        stage.show();
    }
}
