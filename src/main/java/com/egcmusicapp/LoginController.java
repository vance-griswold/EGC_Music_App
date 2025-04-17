package com.egcmusicapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.model.MusicApp;
import com.model.UserList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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

    @FXML
    private void btnLoginClicked() throws IOException {
        String username = txt_username.getText();
        String password = txt_password.getText();

        MusicApp app = new MusicApp();
        UserList userList = UserList.getInstance();

        if (!app.login(username, password)) {
            lbl_error.setText("Invalid login credentials.");
            return;
        }

        // On successful login, go to the home screen
        App.setRoot("home"); // Go to home.fxml on success
    }

    @FXML
    private void back() throws IOException {
        // Go back to the secondary page (cover screen)
        App.setRoot("secondary"); // Back to cover screen
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Optional: init logic
    }
}
