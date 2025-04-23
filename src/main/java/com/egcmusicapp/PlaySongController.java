package com.egcmusicapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.jfugue.player.Player;

import com.model.MusicApp;
import com.model.Song;
import com.model.SongLibrary;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class PlaySongController{
    @FXML
    private TextField activeNote;
    
    @FXML
    public void initialize() {
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

    private void handleKeyPress1() {
        // Your action code here when '1' is pressed
        Player player = new Player();
        player.play("C5h Rh");
        activeNote.setText("");

    }
    private void handleKeyPress2() {
        // Your action code here when '2' is pressed
        Player player = new Player();
        player.play("D5h Rh");
        activeNote.setText("");

    }private void handleKeyPress3() {
        // Your action code here when '3' is pressed
        Player player = new Player();
        player.play("E5h Rh");
        activeNote.setText("");

    }private void handleKeyPress4() {
        // Your action code here when '4' is pressed
        Player player = new Player();
        player.play("F5h Rh");
        activeNote.setText("");

    }private void handleKeyPress5() {
        // Your action code here when '5' is pressed
        Player player = new Player();
        player.play("G5h Rh");
        activeNote.setText("");

    }private void handleKeyPress6() {
        // Your action code here when '6' is pressed
        Player player = new Player();
        player.play("A5h Rh");
        activeNote.setText("");

    }private void handleKeyPress7() {
        // Your action code here when '7' is pressed
        Player player = new Player();
        player.play("B5h Rh");
        activeNote.setText("");

    }private void handleKeyPress8() {
        // Your action code here when '8' is pressed
        Player player = new Player();
        player.play("C6h Rh");
        activeNote.setText("");

    }
    public void switchToPractice() throws IOException {
        App.setRoot("practice");
    }
}
