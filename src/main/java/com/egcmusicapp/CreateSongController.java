package com.egcmusicapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.model.Difficulty;
import com.model.Genre;
import com.model.SheetMusic;
import com.model.Song;
import com.model.SongLibrary;
import com.model.UserList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class CreateSongController implements Initializable {
    @FXML
    private TextField txt_title;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UserList list = UserList.getInstance();
        Song song = new Song(txt_title.toString(), UserList.getCurrentUser().getUserName(), Difficulty.MEDIUM, Genre.CLASSICAL, "", 5);
        SheetMusic sheetMusic = new SheetMusic(song.getSongTitle(), song.getSheetMusic());
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }

    @FXML private void addWholeNote(ActionEvent event) throws IOException {
        
    }

    @FXML private void addHalfNote(ActionEvent event) throws IOException {
        
    }

    @FXML private void addQuarterNote(ActionEvent event) throws IOException {
        
    }

    @FXML private void addEighthNote(ActionEvent event) throws IOException {
        
    }

    @FXML private void addWholeRest(ActionEvent event) throws IOException {
        
    }

    @FXML private void addHalfRest(ActionEvent event) throws IOException {
        
    }

    @FXML private void addQuarterRest(ActionEvent event) throws IOException {
        
    }

    @FXML private void addEighthRest(ActionEvent event) throws IOException {
        
    }

    @FXML private void createMusic(ActionEvent event) throws IOException {
        
    }

    
}
