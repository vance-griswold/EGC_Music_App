package com.egcmusicapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.model.MusicApp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
/*
 * Created by kayleigh faus
 */
/**
 * Controller for the Login screen
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txt_username;

    @FXML
    private PasswordField txt_password;

    @FXML
    private Label lbl_error;

    /**
     * Handles the Login button click event
     */
    @FXML
    private void onLoginClicked() throws IOException {
        String username = txt_username.getText();
        String password = txt_password.getText();

        MusicApp app = new MusicApp();

        if (username.isEmpty() || password.isEmpty()) {
            lbl_error.setText("Please enter both username and password.");
            return;
        }

        if (!app.login(username, password)) {
            lbl_error.setText("Invalid login credentials.");
            return;
        }

        // On successful login, go to the home screen
        App.setRoot("home");
    }

    /**
     * Handles the Back button click event (you can customize this)
     */
    @FXML
    private void onBackClicked() throws IOException {
        // Optional: back to splash screen or previous screen
        App.setRoot("splash"); // Or remove this if you don't have a back screen
    }

    /**
     * Navigates to the sign-up page
     */
    @FXML
    private void onSignUpClicked() throws IOException {
        App.setRoot("signup");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Optional: Add init logic here
    }
}
