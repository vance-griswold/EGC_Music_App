package com.egcmusicapp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
/*
 * Created by kayleigh faus
 */
public class MyAccountController implements Initializable {

    @FXML
    private Label lblUsername;

    @FXML
    private ProgressBar xpBar;

    @FXML
    private Label lblXP;

    @FXML
    private Label lblDailySongs;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // You can dynamically load real user data here
        lblUsername.setText("Gnomer Simpson");
        xpBar.setProgress(0.64);
        lblXP.setText("3200/5000");
        lblDailySongs.setText("34");
    }
}
