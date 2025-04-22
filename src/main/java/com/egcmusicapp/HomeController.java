package com.egcmusicapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.model.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class HomeController implements Initializable {

    @FXML private ImageView leftIcon;
    @FXML private ImageView rightIcon;
    @FXML private Label lblWelcome;

    private User currentUser;

    public void setUser(User user) {
        this.currentUser = user;

        if (lblWelcome != null && user != null) {
            lblWelcome.setText("Hello, " + user.getUserName());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // setUser will be called after FXML is loaded
    }

    @FXML
    private void onMyAccountClicked(ActionEvent event) throws IOException {
        App.setRoot("myaccount");
    }

    @FXML
    private void onLogoutClicked(ActionEvent event) throws IOException {
        currentUser = null; // optional: clear session
        App.setRoot("login");
    }

    @FXML
    private void onDailySongClicked(ActionEvent event) throws IOException {
        App.setRoot("dailySong");
    }

    @FXML
    private void onPracticeClicked(ActionEvent event) throws IOException {
        App.setRoot("practice");
    }

    @FXML
    private void onCreateSongClicked(ActionEvent event) throws IOException {
        App.setRoot("createSong");
    }

    @FXML
    private void onPlaylistClicked(ActionEvent event) throws IOException {
        App.setRoot("playlist");
    }

    @FXML
    private void onLeaderboardClicked(ActionEvent event) throws IOException {
        App.setRoot("leaderboard");
    }
}
