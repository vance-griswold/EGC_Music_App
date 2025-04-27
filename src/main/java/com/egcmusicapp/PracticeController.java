package com.egcmusicapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import com.model.MusicApp;
import com.model.Song;
import com.model.SongLibrary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class PracticeController implements Initializable {

    @FXML
    private TextField searchField;

    @FXML
    private ComboBox<String> genreComboBox;

    @FXML
    private ListView<Song> songListView;

    @FXML
    private Button backButton;

    @FXML
    private AnchorPane backgroundPane;

    private ObservableList<Song> songs;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        songs = FXCollections.observableArrayList(SongLibrary.getInstance().getSongs());
        songListView.setItems(songs);

        genreComboBox.getItems().addAll("ALL", "CLASSICAL", "JAZZ", "POP", "ROCK", "HIP HOP");
        genreComboBox.setValue("ALL");

        genreComboBox.setOnAction(e -> filterSongs());
        searchField.textProperty().addListener((obs, oldText, newText) -> filterSongs());

        songListView.setCellFactory(param -> new ListCell<>() {
            private final Label titleLabel = new Label();
            private final Label artistLabel = new Label();
            private final Label genreLabel = new Label();
            private final Button playButton = new Button("+");

            private final VBox textInfoBox = new VBox();
            private final VBox artistGenreBox = new VBox();
            private final HBox content = new HBox();

            {
                titleLabel.getStyleClass().add("song-title");
                artistLabel.getStyleClass().add("song-artist");
                genreLabel.getStyleClass().add("song-genre");
                playButton.getStyleClass().add("play-button");

                textInfoBox.setAlignment(Pos.CENTER_LEFT);
                textInfoBox.getChildren().add(titleLabel);

                artistGenreBox.setAlignment(Pos.CENTER_RIGHT);
                artistGenreBox.setSpacing(5);
                artistGenreBox.getChildren().addAll(artistLabel, genreLabel);

                Region spacer = new Region();
                HBox.setHgrow(spacer, Priority.ALWAYS);

                content.setAlignment(Pos.CENTER_LEFT);
                content.setSpacing(10);
                content.setPadding(new Insets(10));
                content.getChildren().addAll(textInfoBox, spacer, artistGenreBox, playButton);
                content.getStyleClass().add("song-card");

                playButton.setOnAction(event -> {
                    Song song = getItem();
                    if (song != null) {
                        MusicApp.setCurrentSong(song); // Set the current song
                        try {
                            App.setRoot("playSong"); // Switch to the Play Song screen
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

            @Override
            protected void updateItem(Song song, boolean empty) {
                super.updateItem(song, empty);
                if (empty || song == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    titleLabel.setText(song.getSongTitle());
                    artistLabel.setText(song.getAuthor());
                    genreLabel.setText(song.getGenre().toString());
                    setGraphic(content);
                }
            }
        });


       
    }

    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("home");
    }

    private void filterSongs() {
        String selectedGenre = genreComboBox.getValue();
        String searchText = searchField.getText().toLowerCase();

        ObservableList<Song> filteredSongs = songs.stream()
            .filter(song -> (selectedGenre.equals("ALL") || song.getGenre().toString().equalsIgnoreCase(selectedGenre)) &&
                            (searchText.isEmpty() || song.getSongTitle().toLowerCase().contains(searchText)))
            .collect(Collectors.toCollection(FXCollections::observableArrayList));

        songListView.setItems(filteredSongs);
    }
}
