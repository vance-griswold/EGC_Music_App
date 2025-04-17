package com.egcmusicapp;

import java.io.IOException;

import javafx.fxml.FXML;

/**
 * Controller for the Secondary (cover) view.
 * Handles navigation to the Login screen.
 */
public class SecondaryController {

    @FXML
    private void switchToLogin() throws IOException {
        // Switch to login page when button is clicked
        App.setRoot("login");
    }
}
