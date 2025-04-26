package com.egcmusicapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.model.User;
import com.model.UserList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;

public class MyAccountController implements Initializable {

    // greeting label
    @FXML private Label lblWelcome;

    // existing fields
    @FXML private Label lblUsername;
    @FXML private Label lblLevel;
    @FXML private ProgressBar xpBar;
    @FXML private Label lblXP;
    @FXML private Label lblDailySongs;

    private User user;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        user = UserList.getInstance().getCurrentUser();
        setUserDisplay();
        updateUI();
    }

    private void setUserDisplay() {
        if (user != null) {
            lblWelcome.setText("Hello, " + user.getUserName());
        } else {
            lblWelcome.setText("Hello!");
        }
    }

    private void updateUI() {
        if (user == null) return;

        lblUsername.setText(user.getUserName());
        int level = user.getExperienceLevel();
        lblLevel.setText("Level " + level);

        int currentXP = user.getXpPoints();
        int xpToNext = level * 100;
        xpBar.setProgress(xpToNext > 0 ? (double) currentXP / xpToNext : 0);
        lblXP.setText(currentXP + " / " + xpToNext);

        lblDailySongs.setText("0");  // placeholder
    }

    @FXML
    private void onBackToHomeClicked(MouseEvent event) throws IOException {
        App.setRoot("home");
        System.out.println("Back arrow clicked.");
    }
}
