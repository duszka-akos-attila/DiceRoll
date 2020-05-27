package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import result.Result;
import result.ResultManager;

import java.util.List;
import java.io.IOException;

public class leaderBoardScreenController {

    private static final Logger logger = LoggerFactory.getLogger(ResultManager.class);

    @FXML
    private ChoiceBox<String> gameModes;

    @FXML
    private TableView<Result> leaderboardTable;

    @FXML
    private TableColumn<Result,String> name;

    @FXML
    private TableColumn<Result,String> gameMode;

    @FXML
    private TableColumn<Result,Long> movesNeeded;

    @FXML
    public void initialize(){
        gameModes.getItems().add("Choose a gamemode!");
        gameModes.getItems().add("Standard Game");
        gameModes.getItems().add("Randomized Game");
        gameModes.setValue("Choose a gamemode!");
        logger.trace("Initialized Leaderboard screen.");
    }


    public void loadDatabase(ActionEvent actionEvent){
        if(!gameModes.getValue().equals("Choose a gamemode!")){
            updateTableView(gameModes.getValue());
        }
    }

    public void exitPressed(ActionEvent actionEvent){
        try {
            ResultManager.closeEMF();
        }
        catch (Exception e){
            logger.error(e.toString());
        }

        logger.trace("The player pressed the Exit button.");
        System.exit(0);
    }

    public void mainMenuPressed(ActionEvent actionEvent) throws IOException {
        logger.trace("The player pressed the Main menu button.");
        logger.trace("Loading titleScreen scene!");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/titleScreen.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void updateTableView(String gamemode){
        logger.trace("Updating the leaderboard.");
        List<Result> topList = ResultManager.downloadResults(gamemode);

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        gameMode.setCellValueFactory(new PropertyValueFactory<>("gameMode"));
        movesNeeded.setCellValueFactory(new PropertyValueFactory<>("moves"));

        ObservableList<Result> observableResult = FXCollections.observableArrayList();
        observableResult.addAll(topList);

        leaderboardTable.setItems(observableResult);

        if(gameModes.getItems().toArray()[0].equals("Choose a gamemode!")) {
            logger.trace("Standard value for the ChoiceBox is now deleted!");
            gameModes.getItems().remove(0);
        }
    }
}
