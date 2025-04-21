package com.egcmusicapp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class PracticeController {

    @FXML
    private TextField searchField;

    @FXML 
    private ImageView someIcon;

    @FXML
    private ComboBox<String> genreComboBox;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        var url = getClass().getResource("/images/background2.png");
        System.out.println(url == null ? "❌ Not found" : "✅ Found: " + url);
        
        genreComboBox.getItems().addAll("Classical", "Jazz", "Pop", "Rock", "Hip Hop");

        
    }
}
