package controller;

import game.Game;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class GamePlayController {

    Game game;

    @FXML
    private Label moves;

    @FXML
    private GridPane playField;

    @FXML
    private ImageView onTopImageView;

    @FXML
    private ImageView onFrontImageView;

    @FXML
    public void initialize(){
        game=new Game();
        game.standardGame();
        onTopImageView.setImage(new Image(getClass().getResource("/pictures/"+ game.getDice().getOnTop()+".png").toExternalForm()));
        onFrontImageView.setImage(new Image(getClass().getResource("/pictures/"+ game.getDice().getOnFront()+".png").toExternalForm()));
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 5; j++){
                ImageView view = (ImageView) playField.getChildren().get(i * 5 + j);
                view.setImage(new Image(getClass().getResource("/pictures/"+ game.getField().getFields()[i][j]+".png").toExternalForm()));
            }
        }

        ImageView view = (ImageView) playField.getChildren().get(0);
        view.getStyleClass().add("CubeIsHere");
    }

    public void forfeit(){
        game.setSurrendered(true);
    }
}
