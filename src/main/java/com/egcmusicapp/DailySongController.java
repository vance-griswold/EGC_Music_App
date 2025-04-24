package com.egcmusicapp;

import com.model.Song;
import com.model.SongLibrary;
import com.model.dailySong;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.IOException;

import java.util.Random;

public class DailySongController {

    private SongLibrary songLibrary;
    private dailySong currentDailySong;

    @FXML
    private Label titleLabel;

    @FXML
    private Label authorLabel;

    @FXML
    private Label difficultyLabel;

    @FXML
    private Label genreLabel;

    @FXML
    private Button playBtn;

    @FXML
    public void initialize() {
        songLibrary = SongLibrary.getInstance();
        currentDailySong = new dailySong();
        assignRandomDailySong();
        updateDisplay();
    }

    private void assignRandomDailySong() {
        var songs = songLibrary.getSongs();
        if (!songs.isEmpty()) {
            Random rand = new Random();
            Song song = songs.get(rand.nextInt(songs.size()));
            currentDailySong.assignDailySong(song);
        }
    }

    @FXML
    private void onPlayClicked() {
        Song song = currentDailySong.getSong();
        if (song != null && !currentDailySong.isDailySongCompleted()) {
            currentDailySong.playDailySong(song);
            updateDisplay();
        }
    }

    private void updateDisplay() {
        Song song = currentDailySong.getSong();
        if (song != null) {
            titleLabel.setText(song.getSongTitle());
            authorLabel.setText("By " + song.getAuthor());
            difficultyLabel.setText("Difficulty: " + song.getDifficulty());
            genreLabel.setText("Genre: " + song.getGenre());
        }
    }

    @FXML
    private void onBackClicked(javafx.scene.input.MouseEvent event) throws IOException {
        App.setRoot("home");
        System.out.println("Back button clicked.");
    }
}
