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
import result.Result;

import java.io.IOException;

public class gameWonScreenController {

    @FXML
    private TextField playerNameTextField;

    @FXML
    private GridPane playerNameForm;

    @FXML
    private GridPane controlGrid;

    private final Result result = DiceRollApplication.result;

    public void submitResultByEnter(KeyEvent keyEvent) throws IOException{
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            result.setName(playerNameTextField.getText());
            updateScreen();
        }
    }
    public void submitResult(ActionEvent actionEvent) throws IOException{
        result.setName(playerNameTextField.getText());
        updateScreen();
    }

    public void updateScreen(){
        playerNameForm.setVisible(false);
        controlGrid.setVisible(true);
    }

    public void exitPressed(ActionEvent actionEvent){
        System.exit(0);
    }

    public void mainMenuPressed(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/titleScreen.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
