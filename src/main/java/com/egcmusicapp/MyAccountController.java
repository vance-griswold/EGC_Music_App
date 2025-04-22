package com.egcmusicapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.model.User;

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

/*
 * Created by kayleigh faus
 */
public class MyAccountController implements Initializable {

    @FXML private Label lblUsername;
    @FXML private ProgressBar xpBar;
    @FXML private Label lblXP;
    @FXML private Label lblDailySongs;

    private User user;

    public void setUser(User user) {
        this.user = user;
        updateUI();
    }

    private void updateUI() {
        if (user == null) return;

        lblUsername.setText(user.getUserName());

        int currentXP = user.getXpPoints();
        int xpToNextLevel = (user.getExperienceLevel() + 1) * 1000;

        double progress = (double) currentXP / xpToNextLevel;
        xpBar.setProgress(progress);

        lblXP.setText(currentXP + "/" + xpToNextLevel);
        lblDailySongs.setText("0"); // Placeholder
    }

    @FXML
    private void onBackToHomeClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/egcmusicapp/home.fxml"));
        Parent root = loader.load();

        HomeController controller = loader.getController();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Nothing here - user will be passed in after scene is loaded
    }
}
