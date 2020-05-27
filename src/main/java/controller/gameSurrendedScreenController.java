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

public class gameSurrendedScreenController {

    private static final Logger logger = LoggerFactory.getLogger(gameSurrendedScreenController.class);

    public void exitPressed(ActionEvent actionEvent){
        try {
            ResultManager.closeEMF();
        }
        catch (Exception e){
            logger.error(e.toString());
        }
        System.exit(0);
    }

    public void mainMenuPressed(ActionEvent actionEvent) throws IOException {
        logger.trace("The player pressed Main menu button.");
        logger.trace("Loading titleScreen scene.");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/titleScreen.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
