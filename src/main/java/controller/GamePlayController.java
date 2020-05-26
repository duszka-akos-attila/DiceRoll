package controller;

import game.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GamePlayController {

    Game game;

    @FXML
    private Label moves;

    @FXML
    private Label gamemodeTitle;

    @FXML
    private GridPane playField;

    @FXML
    private ImageView onTopImageView;

    @FXML
    private ImageView onFrontImageView;

    @FXML
    public void initialize(){
        game=new Game();
        switch (gamemodeTitle.getText()){
            case("Standard Game"):
                game.standardGame();
                break;

            case("Randomized Game"):
                game.randomizedGame();
                break;
        }
        onTopImageView.setImage(new Image(getClass().getResource("/pictures/"+ game.getDice().getOnTop()+".png").toExternalForm()));
        onFrontImageView.setImage(new Image(getClass().getResource("/pictures/"+ game.getDice().getOnFront()+".png").toExternalForm()));
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 5; j++){
                ImageView view = (ImageView) playField.getChildren().get(i * 5 + j);
                view.setImage(new Image(getClass().getResource("/pictures/"+ game.getField().getFields()[i][j]+".png").toExternalForm()));
            }
        }

        ImageView view = (ImageView) playField.getChildren().get(0);
    }

    public void forfeit(ActionEvent actionEvent) throws IOException {
        game.setSurrendered(true);
        if(game.didLost()){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/gameSurrendedScreen.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }
}
