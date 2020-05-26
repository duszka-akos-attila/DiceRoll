package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TitleScreenController {

    public void exitPressed(ActionEvent actionEvent){
        System.exit(0);
    }

    public void standardGamePressed(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/standardGamePlayScene.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene=(Scene) ((Node) actionEvent.getSource()).getScene();
        scene.getStylesheets().add(getClass().getResource("CubeIsOnTop.css").toExternalForm());
        stage.setScene(new Scene(root));
        stage.show();

    }

}
