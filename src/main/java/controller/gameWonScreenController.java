package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.DiceRollApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import result.Result;
import result.ResultManager;

import java.io.IOException;

public class gameWonScreenController {

    @FXML
    private TextField playerNameTextField;

    @FXML
    private GridPane playerNameForm;

    @FXML
    private GridPane controlGrid;

    private final Result result = DiceRollApplication.result;

    private static final Logger logger = LoggerFactory.getLogger(gameWonScreenController.class);

    public void submitResultByEnter(KeyEvent keyEvent) throws IOException{
        if (keyEvent.getCode().equals(KeyCode.ENTER) && playerNameTextField.getText().length() > 2) {
            logger.trace("ENTER pressed.");
            result.setName(playerNameTextField.getText());
            logger.info("The player's name is: {}",result.getName());
            try{
                ResultManager.uploadResult();
            }
            catch (Exception e){
                logger.error(e.toString());
            }
            ResultManager.closeEMF();
            updateScreen();
        }
    }
    public void submitResult(ActionEvent actionEvent) throws IOException{
        if(playerNameTextField.getText().length() > 2) {
            result.setName(playerNameTextField.getText());
            logger.info("The player's name is: {}",result.getName());
            try{
                ResultManager.uploadResult();
            }
            catch (Exception e){
                logger.error(e.toString());
            }
            ResultManager.closeEMF();
            updateScreen();
        }
    }

    public void updateScreen(){
        playerNameForm.setVisible(false);
        controlGrid.setVisible(true);
    }

    public void exitPressed(ActionEvent actionEvent){
        logger.trace("Program finished by user!");
        System.exit(0);
    }

    public void mainMenuPressed(ActionEvent actionEvent) throws IOException {
        logger.trace("Returning to the title screen.");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/titleScreen.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
