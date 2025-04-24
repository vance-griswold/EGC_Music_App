package com.egcmusicapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.model.User;
import com.model.UserList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

public class MyAccountController implements Initializable {

    // this is your greeting label at the top of the screen
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
        // 1) grab the logged-in user from your singleton
        user = UserList.getInstance().getCurrentUser();

        // 2) set the “Hello, …” greeting
        setUserDisplay();

        // 3) populate the rest of the UI
        updateUI();
    }

    /**  
     * update just the greeting label  
     */
    private void setUserDisplay() {
        if (user != null) {
            lblWelcome.setText("Hello, " + user.getUserName());
        } else {
            lblWelcome.setText("Hello!");
        }
    }

    /**  
     * update level, XP bar, XP label, daily-songs placeholder  
     */
    private void updateUI() {
        if (user == null) return;

        // display full username elsewhere if you like
        lblUsername.setText(user.getUserName());

        // level
        int level = user.getExperienceLevel();
        lblLevel.setText("Level " + level);

        // XP bar & label (2000 XP per level per your logic)
        int currentXP = user.getXpPoints();
        int xpToNext = level * 2000;
        double progress = xpToNext > 0
                          ? (double) currentXP / xpToNext
                          : 0.0;
        xpBar.setProgress(progress);
        lblXP.setText(currentXP + " / " + xpToNext);

        // daily songs (still a placeholder)
        lblDailySongs.setText("0");
    }

    @FXML
    private void onBackToHomeClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("/com/egcmusicapp/home.fxml")
        );
        Parent root = loader.load();
        HomeController homeCtrl = loader.getController();
        homeCtrl.setUser(user);  // pass the same user along

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
