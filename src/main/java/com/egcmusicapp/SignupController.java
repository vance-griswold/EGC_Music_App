// src/main/java/com/egcmusicapp/SignupController.java
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
import javafx.scene.layout.VBox;

/**
 * Controller for the Sign Up screen
 */
public class SignupController implements Initializable {

    @FXML private TextField txt_username;
    @FXML private TextField txt_email;               
    @FXML private PasswordField txt_password;
    @FXML private PasswordField txt_confirmPassword;
    @FXML private Label lbl_error;

    @FXML private VBox formPane;
    @FXML private VBox profilePane;
    @FXML private Label lblUsername;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
        profilePane.setVisible(false);
    }

    @FXML
    private void btnSignUpClicked() {
        String username = txt_username.getText().trim();
        String email    = txt_email.getText().trim();   
        String password = txt_password.getText();
        String confirm  = txt_confirmPassword.getText();

        
        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
            lbl_error.setText("All fields are required.");
            return;
        }
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            lbl_error.setText("Invalid email address.");
            return;
        }
        if (!password.equals(confirm)) {
            lbl_error.setText("Passwords do not match.");
            return;
        }

        // Attempt registration (now passing email)
        MusicApp app = new MusicApp();
        boolean success = app.register(username, password, email);
        if (!success) {
            lbl_error.setText("Username or email already exists.");
            return;
        }

        // Show confirmation
        lbl_error.setText("");
        formPane.setVisible(false);
        profilePane.setVisible(true);
        lblUsername.setText("Created account: " + username + "\nEmail: " + email);
    }

    @FXML
    private void backToLogin() throws IOException {
        App.setRoot("login");
    }
}
