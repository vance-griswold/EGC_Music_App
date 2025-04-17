package com.egcmusicapp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.model.MusicApp;
import com.model.UserList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


/**
 * created by kayleigh faus
 */
public class LoginController implements Initializable {
    @FXML
    private TextField txt_username;
    @FXML
    private TextField txt_password;
    @FXML
    private Label lbl_error;

    @FXML
    private void btnLoginClicked(MouseEvent event) throws IOException {
        String username = txt_username.getText();
        String password = txt_password.getText(); // Not used yet

        MusicApp app = new MusicApp();
        UserList userList = UserList.getInstance();

        if (!app.login(username, password)) {
            lbl_error.setText("Invalid login credentials.");
            return;
        }

        App.setRoot("home");
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        App.setRoot("secondary");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Optional: init logic
    }
}
