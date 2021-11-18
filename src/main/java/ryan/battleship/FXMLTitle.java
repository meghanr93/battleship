package ryan.battleship;
/*
Meghan Ryan
11/15/2021
This program, you have to find randomly placed battleships within a limited number of turns.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class FXMLTitle implements Initializable {
    
    MediaPlayer player;
    
    @FXML
    private void btnPlayClick(ActionEvent event) throws IOException {
        /* Opens the game scene. */
        MainApp.setRoot("primary");
    }
    
    @FXML
    private void btnScoresClick(ActionEvent event) throws IOException {
        /* Opens the high scores scene. */
        MainApp.setRoot("scores");
    }
    
    @FXML
    void btnInstructClick(ActionEvent event) {
        /* Brings up an alert box with rules on how to play. */
    player = new MediaPlayer((new Media(getClass().getResource("/Click.mp3").toString())));
    player.play();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("How to Play");
    alert.setHeaderText(null);
    alert.setContentText("Click the grid squares to find the hidden ships. The two ships are either two or three connected grids long. Find all 5 ship grids to win. If you run out of turns, you lose.");
    alert.showAndWait();
    }
    
    @FXML
    void btnExitClick(ActionEvent event) {
        /* Exits the program. */
        System.exit(0);
    }
    
    @FXML
    void btnHover(MouseEvent event) {
        /* Causes Buttons to expand when hovered over. */
        Button button = (Button) event.getSource();
        button.setPrefHeight(55);
        button.setPrefWidth(110);
        button.setTranslateX(-2.5);
        button.setTranslateY(-5);
        button.toFront();     
    }
    
    @FXML
    void btnUnhover(MouseEvent event) {
        /* Causes expanded Buttons to shrink back to original size when not hovered over. */
        Button button = (Button) event.getSource();
        button.setPrefHeight(50);
        button.setPrefWidth(100);
        button.setTranslateX(0);
        button.setTranslateY(0);
        button.toBack();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
}
