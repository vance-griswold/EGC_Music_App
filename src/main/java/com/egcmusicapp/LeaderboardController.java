package com.egcmusicapp;

import java.io.IOException;

import com.model.Leaderboard;
import com.model.User;
import com.model.UserList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LeaderboardController {

    @FXML
    private TableView<User> leaderboardTable;

    @FXML private TableColumn<User, Integer> rankColumn;

    @FXML
    private TableColumn<User, String> usernameColumn;

    @FXML
    private TableColumn<User, Integer> levelColumn;

    @FXML
    private TableColumn<User, Integer> xpColumn;

    private Leaderboard leaderboard;

    @FXML
    public void initialize() {
        leaderboard = new Leaderboard();

        // Load users from UserList and update the leaderboard
        for (User user : UserList.getInstance().getUsers()) {
            leaderboard.updateLeaderboard(user);
        }

        // Setup table columns
        rankColumn.setCellValueFactory(new PropertyValueFactory<>("rank"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
        levelColumn.setCellValueFactory(new PropertyValueFactory<>("experienceLevel"));
        xpColumn.setCellValueFactory(new PropertyValueFactory<>("xpPoints"));

        // Load leaderboard data into the table
        ObservableList<User> leaderboardData = FXCollections.observableArrayList(
            leaderboard.getHighestLevelUsers()
        );
        leaderboardTable.setItems(leaderboardData);
    }

    @FXML
    private void onBackClicked(javafx.scene.input.MouseEvent event) throws IOException {
        App.setRoot("home");
        System.out.println("Back button clicked.");
    }
}
