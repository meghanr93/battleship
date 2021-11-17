package ryan.battleship;
/*
Meghan Ryan
11/15/2021
This program, you have to find randomly placed battleships within a limited number of turns.
 */

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
    private Button btnReset;
    @FXML
    private Button btnExit;

    @FXML
    private Label lblTurns;
    @FXML
    private Label lblHits;
    ImageView boxes[];
    int turns = 20;
    int hits = 0;
    int ship1 = 0;
    boolean playing=true;

    Image white = new Image(getClass().getResource("/white.jpg").toString());
    Image ship = new Image(getClass().getResource("/boss_galaga.jpg").toString());
    /* Image variables so they can be easily reused. */
    
    @FXML
    void btnExitClick(ActionEvent event) {
        System.exit(0);
    }
    
    @FXML
    void btnResetClick(ActionEvent event) {
        turns = 20;
        lblTurns.setText(""+20);
        hits=0;
        lblHits.setText("0");
        for (int i = 0; i < boxes.length; i++) {
            boxes[i].setImage(white);
            boxes[i].setAccessibleText("O");
        }
        setShip();
    }

    @FXML
    void imgClick(MouseEvent event) {
        /* Code runs whenever one of the grid boxes are clicked. */
        if (playing==true){
        ImageView grid = (ImageView) event.getSource();
        String state = grid.getAccessibleText();
        if (!"".equals(state)){
        /* Checks if the grid has already been clicked, if so, does nothing. */
        turns = turns-1;
        lblTurns.setText(""+turns);
        
        if ("X".equals(state)){
            grid.setImage(ship);
            grid.setAccessibleText("");
            hits = hits + 1;
            lblHits.setText(""+hits);
        }
        else if ("O".equals(state)) {
            grid.setImage(null);
            grid.setAccessibleText("");
        }       
        /* Checks if a grid has a ship or if it is empty. */        
        winCheck();
        }
        }
    }

    void setShip(){
        /* Sets the first ship part. */
        int ship1 = ThreadLocalRandom.current().nextInt(0,35+1); 
        boxes[ship1].setAccessibleText("X");
        if (ship1==0){
            setShip2(1,1,-6,-6);
        }
        else if (ship1==5){
            setShip2(-1,-1,-6,-6);
        }
        else if (ship1==30){
            setShip2(1,1,6,6);
        }
        else if (ship1==35){
            setShip2(-1,-1,-6,-6);
        }
        else if ((ship1>0)&&(ship1<5)){
            setShip2(-1,1,6,6);
        }
        else if ((ship1==6)||(ship1==12)||(ship1==18)||(ship1==24)){
            setShip2(1,1,-6,6);
        }
        else if ((ship1==11)||(ship1==17)||(ship1==23)||(ship1==29)){
            setShip2(-1,-1,-6,6);
        }
        else if ((ship1>30)&&(ship1<35)){
            setShip2(-1,1,-6,-6);
        }
        else{
            setShip2(-1,1,-6,6);
        }
        /* Conditions for where the second ship part can be placed. */
    }
    
    void setShip2(Integer left,Integer right,Integer up,Integer down){
        /* Randomly selects where to place the second part of the ship. */
        int rand = ThreadLocalRandom.current().nextInt(1,4+1);
        switch (rand) {
            case 1:
                boxes[ship1+left].setAccessibleText("X");
                break;
            case 2:
                boxes[ship1+right].setAccessibleText("X");
                break;
            case 3:
                boxes[ship1+up].setAccessibleText("X");
                break;
            case 4:
                boxes[ship1+down].setAccessibleText("X");
                break;
            default:
                break;
        }
    }
    
    void winCheck(){
        /* Checks for win or lose condition. */
        if (hits==5){
            playing = false;
        }
        else if (turns==0){
            playing = false;
        }
    }
    
    @FXML
    void imgHover(MouseEvent event) {
        ImageView grid = (ImageView) event.getSource();
        String state = grid.getAccessibleText();
        if ((!"".equals(state))&&(playing=true)){ 
            grid.setFitHeight(110);
            grid.setFitWidth(110);
            grid.setTranslateX(-5);
            grid.setTranslateY(-5);
            grid.toFront();
        }
    }

    @FXML
    void imgUnhover(MouseEvent event) {
        ImageView grid = (ImageView) event.getSource();
        grid.setFitHeight(100);
        grid.setFitWidth(100);
        grid.setTranslateX(0);
        grid.setTranslateY(0);
        grid.toBack();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ImageView temp[] ={imgGrid1, imgGrid2, imgGrid3, imgGrid4, imgGrid5, imgGrid6, imgGrid7,
        imgGrid8, imgGrid9, imgGrid10, imgGrid11, imgGrid12, imgGrid13, imgGrid14, imgGrid15, imgGrid16,
        imgGrid17, imgGrid18, imgGrid19, imgGrid20, imgGrid21, imgGrid22, imgGrid23, imgGrid24, imgGrid25,
        imgGrid26, imgGrid27, imgGrid28, imgGrid29, imgGrid30, imgGrid31, imgGrid32, imgGrid33, imgGrid34,
        imgGrid35, imgGrid36};
        boxes=temp;
        setShip();
    }    
}
