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
import result.Result;
import result.ResultManager;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class leaderBoardScreenController {

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
    }


    public void loadDatabase(ActionEvent actionEvent){
        if(!gameModes.getValue().equals("Choose a gamemode!")){
            updateTableView(gameModes.getValue());
        }
    }

    public void exitPressed(ActionEvent actionEvent){
        ResultManager.closeEMF();
        System.exit(0);
    }

    public void mainMenuPressed(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/titleScreen.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void updateTableView(String gamemode){
//        logger.trace("Updating the leaderboard.");
        List<Result> topList = ResultManager.downloadResults(gamemode);

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        gameMode.setCellValueFactory(new PropertyValueFactory<>("gameMode"));
        movesNeeded.setCellValueFactory(new PropertyValueFactory<>("moves"));

        ObservableList<Result> observableResult = FXCollections.observableArrayList();
        observableResult.addAll(topList);

        leaderboardTable.setItems(observableResult);

        if(gameModes.getItems().toArray()[0].equals("Choose a gamemode!")) {
            gameModes.getItems().remove(0);
        }
    }
}
