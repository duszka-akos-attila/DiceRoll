package controller;

import game.DiceManager;
import game.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.DiceRollApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import result.Result;
import result.ResultManager;

import java.io.IOException;

import static java.lang.String.valueOf;


public class GamePlayController {

    private static final Logger logger = LoggerFactory.getLogger(ResultManager.class);

    Game game;
    Result result;

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
        game = new Game();
        DiceRollApplication.result = new Result();
        result = DiceRollApplication.result;
        switch (gamemodeTitle.getText()){
            case("Standard Game"):
                game.standardGame();
                result.setGameMode("Standard Game");
                logger.trace("Initialized a Standard game.");
                break;

            case("Randomized Game"):
                game.randomizedGame();
                result.setGameMode("Randomized Game");
                logger.trace("Initialized a Randomized game.");
                break;
        }

        updateScreen();
    }

    public void rollDice(KeyEvent keyEvent) throws IOException {
        DiceManager dm = new DiceManager();
        logger.trace("Keyboard key pressed.");

        switch (keyEvent.getCode()){
            case A:
                if(dm.canRoll(game,"left")) {
                    result.increaseMovesByOne();
                    dm.rollDice(game, "left");
                    updateScreen();
                }
                break;

            case D:
                if(dm.canRoll(game,"right")) {
                    result.increaseMovesByOne();
                    dm.rollDice(game, "right");
                    updateScreen();
                }
                break;

            case W:
                if(dm.canRoll(game,"up")) {
                    result.increaseMovesByOne();
                    dm.rollDice(game, "up");
                    updateScreen();
                }
                break;

            case S:
                if(dm.canRoll(game,"down")) {
                    result.increaseMovesByOne();
                    dm.rollDice(game, "down");
                    updateScreen();
                }
                break;

            case F6:
                game.getDice().setPosition(new int[]{5,4});
                updateScreen();
                logger.info("CHEAT WAS ACTIVATED!");
                break;
        }

        if(game.didWin()){
            switchToGameWonScreen(keyEvent);
        }
    }

    public void forfeit(ActionEvent actionEvent) throws IOException {
        game.setSurrendered(true);
        logger.info("Player has forfeited!");
        if(game.didLost()){
            logger.trace("Loading gameSurrendedScreen scene.");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/gameSurrendedScreen.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    public void switchToGameWonScreen(KeyEvent keyEvent) throws IOException {
            logger.info("Player has won!");
            DiceRollApplication.result = this.result;
            logger.trace("Updating DiceRollApplication.result with final result.");
            logger.trace("Loading gameWonScreen scene.");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/gameWonScreen.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) keyEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
    }

    public void updateScreen(){
        onTopImageView.setImage(new Image(getClass().getResource("/pictures/"+ game.getDice().getOnTop()+".png").toExternalForm()));
        onFrontImageView.setImage(new Image(getClass().getResource("/pictures/"+ game.getDice().getOnFront()+".png").toExternalForm()));
        int dicePosition = game.getDice().getPosition()[0] * 5 + game.getDice().getPosition()[1];
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 5; j++){
                ImageView view = (ImageView) playField.getChildren().get(i * 5 + j);
                view.setImage(new Image(getClass().getResource("/pictures/"+ game.getField().getFields()[i][j]+".png").toExternalForm()));
            }
        }

        ImageView view = (ImageView) playField.getChildren().get(game.getDice().getPosition()[0] * 5 + game.getDice().getPosition()[1]);
        view.setImage(new Image(getClass().getResource("/pictures/b"+ game.getField().getFields()[game.getDice().getPosition()[0]][game.getDice().getPosition()[1]]+".png").toExternalForm()));

        moves.setText(valueOf(result.getMoves()));
        DiceRollApplication.result = this.result;
        logger.trace("Updateing DiceRollApplication.result with current result.");
        logger.trace("Screen is now updated!");
    }
}
