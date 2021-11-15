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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class FXMLController implements Initializable {
        
    @FXML
    private ImageView imgGrid1;
    @FXML
    private ImageView imgGrid2;
    @FXML
    private ImageView imgGrid3;
    @FXML
    private ImageView imgGrid4;
    @FXML
    private ImageView imgGrid5;
    @FXML
    private ImageView imgGrid6;
    @FXML
    private ImageView imgGrid7;
    @FXML
    private ImageView imgGrid8;
    @FXML
    private ImageView imgGrid9;
    @FXML
    private ImageView imgGrid10;
    @FXML
    private ImageView imgGrid11;
    @FXML
    private ImageView imgGrid12;
    @FXML
    private ImageView imgGrid13;
    @FXML
    private ImageView imgGrid14;
    @FXML
    private ImageView imgGrid15;
    @FXML
    private ImageView imgGrid16;
    @FXML
    private ImageView imgGrid17;
    @FXML
    private ImageView imgGrid18;
    @FXML
    private ImageView imgGrid19;
    @FXML
    private ImageView imgGrid20;
    @FXML
    private ImageView imgGrid21;
    @FXML
    private ImageView imgGrid22;
    @FXML
    private ImageView imgGrid23;
    @FXML
    private ImageView imgGrid24;
    @FXML
    private ImageView imgGrid25;
    @FXML
    private ImageView imgGrid26;
    @FXML
    private ImageView imgGrid27;
    @FXML
    private ImageView imgGrid28;
    @FXML
    private ImageView imgGrid29;
    @FXML
    private ImageView imgGrid30;
    @FXML
    private ImageView imgGrid31;
    @FXML
    private ImageView imgGrid32;
    @FXML
    private ImageView imgGrid33;
    @FXML
    private ImageView imgGrid34;
    @FXML
    private ImageView imgGrid35;
    @FXML
    private ImageView imgGrid36;

    @FXML
    private Label lblTurns;

    @FXML
    void btnExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void imgClick(MouseEvent event) {
        
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ImageView boxes[] = {imgGrid1, imgGrid2, imgGrid3, imgGrid4, imgGrid5, imgGrid6, imgGrid7,
        imgGrid8, imgGrid9, imgGrid10, imgGrid11, imgGrid12, imgGrid13, imgGrid14, imgGrid15, imgGrid16,
        imgGrid17, imgGrid18, imgGrid19, imgGrid20, imgGrid21, imgGrid22, imgGrid23, imgGrid24, imgGrid25,
        imgGrid26, imgGrid27, imgGrid28, imgGrid29, imgGrid30, imgGrid31, imgGrid32, imgGrid33, imgGrid34,
        imgGrid35, imgGrid36};
    }    
}
