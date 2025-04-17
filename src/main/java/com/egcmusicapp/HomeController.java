package com.egcmusicapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

public class HomeController implements Initializable {

    @FXML private ImageView leftIcon;
    @FXML private ImageView rightIcon;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Optional: Load icons
        /*
        Image icon = new Image(getClass().getResource("/images/treble_clef.png").toExternalForm());
        leftIcon.setImage(icon);
        rightIcon.setImage(icon);
        */
    }

    @FXML
    private void onMyAccountClicked(ActionEvent event) throws IOException {
        App.setRoot("myaccount"); // ✅ Fix: match FXML name
    }

    @FXML
    private void onLogoutClicked(ActionEvent event) throws IOException {
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
