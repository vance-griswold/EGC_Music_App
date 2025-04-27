package com.egcmusicapp;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.model.Chord;
import com.model.Difficulty;
import com.model.Genre;
import com.model.Measure;
import com.model.MusicApp;
import com.model.Scale;
import com.model.SheetMusic;
import com.model.Song;
import com.model.SongLibrary;
import com.model.UserList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CreateSongController {
    @FXML
    private TextField txt_title;
    @FXML
    private ImageView gnomeImage;
    @FXML
    private Label lblCurrentMeasure;

    private ArrayList<Measure> measures = new ArrayList<Measure>();
    private Difficulty difficulty = Difficulty.MEDIUM;
    private Genre genre = Genre.CLASSICAL;
    private int rating = 5;
    private Scale scale = Scale.C;
    private Measure currentMeasure = new Measure(new ArrayList<Chord>());

    public void initialize() {
        gnomeImage.setImage(new Image(getClass().getResource("/images/gnome_guitar.jpg").toExternalForm()));
        UserList list = UserList.getInstance();
        Song song = new Song(txt_title.toString(), UserList.getCurrentUser().getUserName(), this.difficulty, this.genre, "", this.rating);
        SheetMusic sheetMusic = new SheetMusic(song.getSongTitle(), song.getSheetMusic());
    }

    @FXML private void addWholeNote(ActionEvent event) throws IOException {
        String note = scale.toString() + "5w";
        Chord chord = new Chord(note);
        currentMeasure.addChord(chord);
        lblCurrentMeasure.setText(currentMeasure.getMeasure());
    }

    @FXML private void addHalfNote(ActionEvent event) throws IOException {
        String note = scale.toString() + "5h";
        Chord chord = new Chord(note);
        currentMeasure.addChord(chord);
        lblCurrentMeasure.setText(currentMeasure.getMeasure());
    }

    @FXML private void addQuarterNote(ActionEvent event) throws IOException {
        String note = scale.toString() + "5q";
        Chord chord = new Chord(note);
        currentMeasure.addChord(chord);
        lblCurrentMeasure.setText(currentMeasure.getMeasure());
    }

    @FXML private void addEighthNote(ActionEvent event) throws IOException {
        String note = scale.toString() + "5qq";
        Chord chord = new Chord(note);
        currentMeasure.addChord(chord);
        lblCurrentMeasure.setText(currentMeasure.getMeasure());
    }

    @FXML private void addWholeRest(ActionEvent event) throws IOException {
        String note = "Rw";
        Chord chord = new Chord(note);
        currentMeasure.addChord(chord);
        lblCurrentMeasure.setText(currentMeasure.getMeasure());
    }

    @FXML private void addHalfRest(ActionEvent event) throws IOException {
        String note = "Rh";
        Chord chord = new Chord(note);
        currentMeasure.addChord(chord);
        lblCurrentMeasure.setText(currentMeasure.getMeasure());
    }

    @FXML private void addQuarterRest(ActionEvent event) throws IOException {
        String note = "Rq";
        Chord chord = new Chord(note);
        currentMeasure.addChord(chord);
        lblCurrentMeasure.setText(currentMeasure.getMeasure()); 
    }

    @FXML private void addEighthRest(ActionEvent event) throws IOException {
        String note = "Rqq";
        Chord chord = new Chord(note);
        currentMeasure.addChord(chord);
        lblCurrentMeasure.setText(currentMeasure.getMeasure()); 
    }

    @FXML private void addMeasure(ActionEvent event) throws IOException {
        measures.add(currentMeasure);
        currentMeasure = new Measure(new ArrayList<Chord>());
        lblCurrentMeasure.setText(currentMeasure.getMeasure()); 
    }

    @FXML private void setDiffEasy(ActionEvent actionEvent) throws IOException {
        this.difficulty = Difficulty.EASY;
    }
    @FXML private void setDiffMedium(ActionEvent actionEvent) throws IOException {
        this.difficulty = Difficulty.MEDIUM;
    }
    @FXML private void setDiffHard(ActionEvent actionEvent) throws IOException {
        this.difficulty = Difficulty.HARD;
    }

    @FXML private void setGenreRock(ActionEvent actionEvent) throws IOException {
        this.genre = Genre.ROCK;
    }
    @FXML private void setGenreCountry(ActionEvent actionEvent) throws IOException {
        this.genre = Genre.COUNTRY;
    }
    @FXML private void setGenrePop(ActionEvent actionEvent) throws IOException {
        this.genre = Genre.POP;
    }
    @FXML private void setGenreClassical(ActionEvent actionEvent) throws IOException {
        this.genre = Genre.CLASSICAL;
    }

    @FXML private void setRating1(ActionEvent actionEvent) throws IOException {
        this.rating = 1;
    }
    @FXML private void setRating2(ActionEvent actionEvent) throws IOException {
        this.rating = 2;
    }
    @FXML private void setRating3(ActionEvent actionEvent) throws IOException {
        this.rating = 3;
    }
    @FXML private void setRating4(ActionEvent actionEvent) throws IOException {
        this.rating = 4;
    }
    @FXML private void setRating5(ActionEvent actionEvent) throws IOException {
        this.rating = 5;
    }



    @FXML private void setScaleC(ActionEvent actionEvent) throws IOException {
        this.scale = Scale.C;
    }
    @FXML private void setScaleD(ActionEvent actionEvent) throws IOException {
        this.scale = Scale.D;
    }
    @FXML private void setScaleE(ActionEvent actionEvent) throws IOException {
        this.scale = Scale.E;
    }
    @FXML private void setScaleF(ActionEvent actionEvent) throws IOException {
        this.scale = Scale.F;
    }
    @FXML private void setScaleG(ActionEvent actionEvent) throws IOException {
        this.scale = Scale.G;
    }
    @FXML private void setScaleA(ActionEvent actionEvent) throws IOException {
        this.scale = Scale.A;
    }
    @FXML private void setScaleB(ActionEvent actionEvent) throws IOException {
        this.scale = Scale.B;
    }
   
    public void switchToHome() throws IOException {
        App.setRoot("home");
    }

    public void printSheetMusic() {
        SheetMusic sheetMusic = new SheetMusic(txt_title.getText(), measures);
        Song song = new Song(txt_title.getText(), UserList.getCurrentUser().getUserName(), this.difficulty, this.genre, sheetMusic.getSong(), this.rating);
        song.printToText();
    }

    public void publishSong() throws IOException {
        SheetMusic sheetMusic = new SheetMusic(txt_title.getText(), measures);
        Song song = new Song(txt_title.getText(), UserList.getCurrentUser().getUserName(), this.difficulty, this.genre, sheetMusic.getSong(), this.rating);
        SongLibrary songLibrary = SongLibrary.getInstance();
        songLibrary.create(song);
        songLibrary.save();
        App.setRoot("home");
    }
    
}
