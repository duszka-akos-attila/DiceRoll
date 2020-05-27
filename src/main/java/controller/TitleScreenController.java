package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import result.ResultManager;

import java.io.IOException;

public class TitleScreenController {

    private static final Logger logger = LoggerFactory.getLogger(TitleScreenController.class);

    public void exitPressed(ActionEvent actionEvent){
        logger.trace("Program is being terminated by the player!");
        try {
            ResultManager.closeEMF();
        }
        catch (Exception e){
            logger.error(e.toString());
        }
        System.exit(0);
    }

    public void standardGamePressed(ActionEvent actionEvent) throws IOException {
        logger.info("Player starting a Standard game.");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/standardGamePlayScene.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void randomizeddGamePressed(ActionEvent actionEvent) throws IOException {
        logger.info("Player starting a Randomized game.");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/randomizedGamePlayScene.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void leaderBoardPressed(ActionEvent actionEvent) throws IOException{
        logger.trace("Player selected leaderboard.");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/leaderBoardScreen.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

}
