package com.egcmusicapp;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.UUID;

import org.jfugue.player.Player;

import com.model.MistakeIndicator;
import com.model.MusicApp;
import com.model.Song;
import com.model.SongLibrary;
import com.model.UserList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Dialog;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class PlaySongController{
    @FXML
    private TextField activeNote;
    @FXML
    private Label lblNote;
    @FXML
    private Label lblScoreTop;
    @FXML
    private Label lblScoreBot;
    @FXML
    private Label lblScoreCard;
    @FXML
    private ImageView imageView;
    private int j = 0;
    private int score = 0;
    private ArrayList<Character> notes = new ArrayList<Character>();
    private MistakeIndicator mistakeIndicator = new MistakeIndicator();

    @FXML
    public void initialize() {
        Song song = MusicApp.getCurrentSong();
        if (song == null) {
            // Handle the case when no song is selected
            System.out.println("No song selected.");
            return;
        }
        getNotes();
        lblNote.setText(notes.get(j).toString());
        activeNote.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == javafx.scene.input.KeyCode.DIGIT1) {
                handleKeyPress1();
            } else if (event.getCode() == javafx.scene.input.KeyCode.DIGIT2) {
                handleKeyPress2();
            }else if (event.getCode() == javafx.scene.input.KeyCode.DIGIT3) {
                handleKeyPress3();
            }else if (event.getCode() == javafx.scene.input.KeyCode.DIGIT4) {
                handleKeyPress4();
            }else if (event.getCode() == javafx.scene.input.KeyCode.DIGIT5) {
                handleKeyPress5();
            }else if (event.getCode() == javafx.scene.input.KeyCode.DIGIT6) {
                handleKeyPress6();
            }else if (event.getCode() == javafx.scene.input.KeyCode.DIGIT7) {
                handleKeyPress7();
            }else if (event.getCode() == javafx.scene.input.KeyCode.DIGIT8) {
                handleKeyPress8();
            }
        });
    }
    public void setJ(int i) {
        this.j = i;
    }
    private ArrayList<Character> getNotes() {
        String music = MusicApp.getCurrentSong().getSheetMusic();
        for( int i = 0; i < music.length(); i++) {
            char note = music.charAt(i);
            if (note == 'C' || note == 'D' || note == 'E' || note == 'F' || note == 'G' || note == 'A' || note == 'B') {
                notes.add(note);
            }
        }
        lblScoreBot.setText(notes.size() + "");
        return notes;
    }

    private void handleKeyPress1() {
        // Your action code here when '1' is pressed
        Player player = new Player();
        player.play("C5q Rq");
        activeNote.setText("");
        noteUpdate('C');
    }
    private void handleKeyPress2() {
        // Your action code here when '2' is pressed
        Player player = new Player();
        player.play("D5q Rq");
        activeNote.setText("");
        noteUpdate('D');

    }private void handleKeyPress3() {
        // Your action code here when '3' is pressed
        Player player = new Player();
        player.play("E5q Rq");
        activeNote.setText("");
        noteUpdate('E');

    }private void handleKeyPress4() {
        // Your action code here when '4' is pressed
        Player player = new Player();
        player.play("F5q Rq");
        activeNote.setText("");
        noteUpdate('F');

    }private void handleKeyPress5() {
        // Your action code here when '5' is pressed
        Player player = new Player();
        player.play("G5q Rq");
        activeNote.setText("");
        noteUpdate('G');

    }private void handleKeyPress6() {
        // Your action code here when '6' is pressed
        Player player = new Player();
        player.play("A5q Rq");
        activeNote.setText("");
        noteUpdate('A');

    }private void handleKeyPress7() {
        // Your action code here when '7' is pressed
        Player player = new Player();
        player.play("B5q Rq");
        activeNote.setText("");
        noteUpdate('B');

    }private void handleKeyPress8() {
        // Your action code here when '8' is pressed
        Player player = new Player();
        player.play("C6q Rq");
        activeNote.setText("");
        noteUpdate('C');
    }

    private void noteUpdate(Character note) {
        if (j < notes.size()) {
            if (notes.get(j).equals(note)) {
                score = score + 1;
                lblScoreTop.setText(score + "");
            } else {
                mistakeIndicator.addMistake();
            }
            setJ(j+1);
            if (j < notes.size()) {
                lblNote.setText(notes.get(j).toString());
            } else {
                lblNote.setText("End!");
                int scorePercentage = (int) (((float) score) / ((float)notes.size()) * 100);
                if (scorePercentage == 100) {
                    lblScoreCard.setText("You passed with a score of " + scorePercentage + "%! +20 XP");
                    MusicApp.getCurrentUser().addXP(20);
                }else if (scorePercentage >= 60) {
                    lblScoreCard.setText("You passed with a score of " + scorePercentage + "%! +10 XP");
                    MusicApp.getCurrentUser().addXP(10);
                } else {
                    lblScoreCard.setText("You failed with a score of " + scorePercentage + "%.");
                }
                UserList list = UserList.getInstance();
                list.save();
            }
        }
    }

    public void switchToPractice() throws IOException {
        App.setRoot("practice");
    }

    public void printSheetMusic() {
        MusicApp.getCurrentSong().printToText();
    }
}
