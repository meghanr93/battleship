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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class FXMLScores implements Initializable {
    
    @FXML
    private Label lblScores;
    @FXML
    private Label lblNames;
    
    @FXML
    void btnMenuClick(ActionEvent event) throws IOException {
        /* Goes back to the menu scene. */
        MainApp.setRoot("titlescreen");
    }
    
    String name[];
    Integer score[];
    
    void readScores() {
        try {

            BufferedReader readFile = new BufferedReader(new FileReader("scores.txt"));
            for (int i = 0; i < 5; i++) {
                name[i] = readFile.readLine();
                score[i] = Integer.parseInt(readFile.readLine());
            }
            readFile.close();
        } catch (IOException e) {
        }
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
        readScores();
        lblScores.setText("");
            for (int i = 0; i < score.length; i++) {
        lblScores.setText(lblScores.getText() +i + ":" + score[i] + "\n");
        }
        lblNames.setText("");
            for (int i = 0; i < name.length; i++) {
        lblNames.setText(lblNames.getText() +i + ":" + name[i] + "\n");
    }
    }    
}
