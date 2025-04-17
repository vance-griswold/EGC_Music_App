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
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
/*
 * Created by kayleigh faus
 */
/**
 * Controller for the Sign Up screen
 */
public class SignupController implements Initializable {

    @FXML private TextField txt_username;
    @FXML private PasswordField txt_password;
    @FXML private PasswordField txt_confirmPassword;
    @FXML private Label lbl_error;

    @FXML private VBox formPane;
    @FXML private VBox profilePane;

    @FXML private Label lblUsername;
    @FXML private ProgressBar xpProgress;
    @FXML private Label lblXP;
    @FXML private Label lblDailySongs;

    @FXML
    private void btnSignUpClicked() {
        String username = txt_username.getText();
        String password = txt_password.getText();
        String confirmPassword = txt_confirmPassword.getText();

        MusicApp app = new MusicApp();
        UserList userList = UserList.getInstance();

        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            lbl_error.setText("All fields are required.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            lbl_error.setText("Passwords do not match.");
            return;
        }

        boolean success = app.register(username, password);
        if (!success) {
            lbl_error.setText("Username already exists.");
            return;
        }

        formPane.setVisible(false);
        profilePane.setVisible(true);

        lblUsername.setText(username);
        xpProgress.setProgress(0.64); // Starting value
        lblXP.setText("3200/5000");
        lblDailySongs.setText("34");

        lbl_error.setText("");
    }

    @FXML
    private void backToLogin() throws IOException {
        App.setRoot("login");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Optional init logic
    }
}
