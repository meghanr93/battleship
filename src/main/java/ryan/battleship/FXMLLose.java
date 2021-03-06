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
import javafx.scene.control.Label;

public class FXMLLose implements Initializable {
    
    @FXML
    void btnMenuClick(ActionEvent event) throws IOException {
        /* Goes back to the menu scene. */
        MainApp.setRoot("titlescreen");
    }
    
    @FXML
    void btnGameClick(ActionEvent event) throws IOException {
        /* Goes back to the menu scene. */
        MainApp.setRoot("primary");
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
