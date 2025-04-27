package com.egcmusicapp;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import com.model.Song;
import com.model.SongLibrary;
import com.model.User;
import com.model.UserList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;

public class MyAccountController implements Initializable {

    @FXML private Label lblWelcome;

    @FXML private Label lblLevel;
    @FXML private ProgressBar xpBar;
    @FXML private Label lblXP;
    @FXML private Label lblDailySongs;
    @FXML private ListView<String> userSongsList;

    private User user;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        user = UserList.getInstance().getCurrentUser();
        setUserDisplay();
        updateUI();
        listUserCreatedSongs();
    }

    private void setUserDisplay() {
        if (user != null) {
            lblWelcome.setText("Hello, " + user.getUserName());
        } else {
            lblWelcome.setText("Hello!");
        }
    }

    private void updateUI() {
        if (user == null) return;

        int level = user.getExperienceLevel();
        lblLevel.setText("Level " + level);

        int currentXP = user.getXpPoints();
        int xpToNext = level * 100;
        xpBar.setProgress(xpToNext > 0 ? (double) currentXP / xpToNext : 0);
        lblXP.setText(currentXP + " / " + xpToNext);

        // Daily songs completed (if stored inside user object)
        lblDailySongs.setText(String.valueOf(user.getDailySongsCompleted()));  // assuming this method exists
    }

    private void listUserCreatedSongs() {
        if (user == null) return;

        String username = user.getUserName();
        List<Song> allSongs = SongLibrary.getInstance().getSongs();

        List<String> userCreatedSongTitles = allSongs.stream()
            .filter(song -> song.getAuthor().equals(username))
            .map(Song::getSongTitle)
            .collect(Collectors.toList());

        userSongsList.getItems().addAll(userCreatedSongTitles);
    }

    @FXML
    private void onBackToHomeClicked(MouseEvent event) throws IOException {
        App.setRoot("home");
    }
}
