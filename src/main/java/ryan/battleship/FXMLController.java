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
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import javafx.scene.control.TextInputDialog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

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
    private Label lblHits;
    @FXML
    private Label lblSeconds;
    @FXML
    private Label lblWins;
    
    ImageView boxes[];
    int turns = 24;
    int hits = 0;
    int left = 1;
    int right = 1;
    int up = 6;
    int down = 6;
    boolean threeship=true;
    boolean playing=true;
    String dialog;
    String nametext="";
    int current;
    int wincount;
    
    MediaPlayer player;
    
    /* Game timer timeline and variables. */
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), ae -> time()));
    int sec = 0;   
    boolean start = false;

    Image white = new Image(getClass().getResource("/white.jpg").toString());
    Image ship = new Image(getClass().getResource("/boss_galaga.jpg").toString());
    /* Image variables so they can be easily reused. */
    
    /* Score arrays. */
    String name[]= new String[5];
    int score[]= new int[5];
    
    void readScores() {
        /* Reads the scores in the file. */
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

    void writeScore() {
        /* Writes to the name and score file. */
        try {
            BufferedWriter outFile = new BufferedWriter(new FileWriter("scores.txt"));
            for (int i = 0; i < 5; i++) {
                outFile.write(name[i]);
                outFile.newLine();
                outFile.write(""+(score[i]));
                outFile.newLine();
            }
            outFile.close();
        } catch (IOException e) {
        }
    }
    
    void readWins() {
        /* Checks total wins over the course of the game played in a file. */
        try {
            BufferedReader readFile = new BufferedReader(new FileReader("wins.txt"));
            wincount = Integer.parseInt(readFile.readLine());              
            readFile.close();
        } catch (IOException e) {
        }
    }
   
    void writeWins() {
        /* Adds to the win count file. */
        try {
            BufferedWriter outFile = new BufferedWriter(new FileWriter("wins.txt"));
            outFile.write(""+(wincount));
            outFile.close();
        } catch (IOException e) {
        }
    }
    
    @FXML
    void btnExitClick(ActionEvent event) throws IOException {
        /* Changes the scene to title screen. */
        MainApp.setRoot("titlescreen");
    }
    
    @FXML 
    void time(){
        /* Adds a second to the game timer. */
        if (start==true){
        sec = sec+1;
        lblSeconds.setText(""+sec);
        }
    }
    
    @FXML
    void btnResetClick(ActionEvent event) {
        /* Resets the game, generating new ships and setting all of the Images back to white. */
        player = new MediaPlayer((new Media(getClass().getResource("/Ding.mp3").toString())));
        player.play();
        turns = 24;
        lblTurns.setText(""+24);
        hits=0;
        start=false;
        sec=0;
        lblSeconds.setText("0");
        lblHits.setText("0");
        for (int i = 0; i < boxes.length; i++) {
            boxes[i].setImage(white);
            boxes[i].setAccessibleText("O");
        }
        threeship=true;
        setShip();
        setShip();
        playing = true;
    }

    @FXML
    void imgClick(MouseEvent event)throws IOException {
        /* Code runs whenever one of the grid boxes are clicked. */
        if (playing == true){
            start=true;
            ImageView grid = (ImageView) event.getSource();
            String state = grid.getAccessibleText();
        if (!"".equals(state)){
        /* Checks if the grid has already been clicked, if so, does nothing. */
            turns = turns-1;
            lblTurns.setText(""+turns);
            grid.setFitHeight(100);
            grid.setFitWidth(100);
            grid.setTranslateX(0);
            grid.setTranslateY(0);
            grid.toBack();
        if ("X".equals(state)){
            player = new MediaPlayer((new Media(getClass().getResource("/Rocket_Explosion.mp3").toString())));
            player.play();
            grid.setImage(ship);
            grid.setAccessibleText("");
            hits = hits + 1;
            lblHits.setText(""+hits);
        }
        else if ("O".equals(state)) {
            player = new MediaPlayer((new Media(getClass().getResource("/Bamboo_Hit.mp3").toString())));
            player.play();
            grid.setImage(null);
            grid.setAccessibleText("");
        }       
        /* Checks if a grid has a ship or if it is empty. */             
        }
        winCheck();
        }
    }
    
    void setDirections(Integer l, Integer r, Integer u, Integer d){
        /* Changes the grid the second or third part of a ship will be placed in.
        It saves the direction of a ship while the ship is generated so the second and third
        ship part are generated in the same direction. */
        left = l;
        right = r;
        up = u;
        down = d;
    }

    void setShip(){
        /* Sets the first ship part. */
        int ship1 = ThreadLocalRandom.current().nextInt(0,35+1); 
        System.out.println(ship1);
        if (boxes[ship1].getAccessibleText().equals("X")){
            setShip();
        }
        else{
            boxes[ship1].setAccessibleText("X");
        int rand = ThreadLocalRandom.current().nextInt(1,4+1);
        if ((ship1==0)||(ship1==1)||(ship1==6)||(ship1==7)){
            setDirections(1,1,6,6);
            setShip2(left,right,up,down, rand, ship1);
            if (threeship==true){
            setShip2((left*2),(right*2),(up*2),(down*2), rand, ship1);
            threeship=false;
            /* If threeship is true, generates a third ship part. Otherwise the ship will
            be only two parts long. */
            }
        }
        else if ((ship1==4)||(ship1==5)||(ship1==10)||(ship1==11)){
            setDirections(-1,-1,6,6);
            setShip2(left,right,up,down, rand, ship1);
            if (threeship==true){
            setShip2((left*2),(right*2),(up*2),(down*2), rand, ship1);
            threeship=false;
            }
        }
        else if ((ship1==24)||(ship1==25)||(ship1==30)||(ship1==31)){
            setDirections(1,1,-6,-6);
            setShip2(left,right,up,down, rand, ship1);
            if (threeship==true){
            setShip2((left*2),(right*2),(up*2),(down*2), rand, ship1);
            threeship=false;
            }
        }
        else if ((ship1==28)||(ship1==29)||(ship1==34)||(ship1==35)){
            setDirections(-1,-1,-6,-6);
            setShip2(left,right,up,down, rand, ship1);
            if (threeship==true){
            setShip2((left*2),(right*2),(up*2),(down*2), rand, ship1);
            threeship=false;
            }
        }
        /* ^corners */
        else if ((ship1==2)||(ship1==3)||(ship1==8)||(ship1==9)){
            setDirections(-1,1,6,6);
            setShip2(left,right,up,down, rand, ship1);
            if (threeship==true){
            setShip2((left*2),(right*2),(up*2),(down*2), rand, ship1);
            threeship=false;
            }
        }
        else if ((ship1==12)||(ship1==13)||(ship1==18)||(ship1==19)){
            setDirections(1,1,-6,6);
            setShip2(left,right,up,down, rand, ship1);
            if (threeship==true){
            setShip2((left*2),(right*2),(up*2),(down*2), rand, ship1);
            threeship=false;
            }
        }
        else if ((ship1==16)||(ship1==17)||(ship1==22)||(ship1==23)){
            setDirections(-1,-1,-6,6);
            setShip2(left,right,up,down, rand, ship1);
            if (threeship==true){
            setShip2((left*2),(right*2),(up*2),(down*2), rand, ship1);
            threeship=false;
            }
        }
        else if ((ship1==26)||(ship1==27)||(ship1==32)||(ship1==33)){
            setDirections(-1,1,-6,-6);
            setShip2(left,right,up,down, rand, ship1);
            if (threeship==true){
            setShip2((left*2),(right*2),(up*2),(down*2), rand, ship1);
            threeship=false;
            }
        }
        /* ^ sides */
        else{
            setShip2(-1,1,-6,6, rand, ship1);
            if (threeship==true){
            setShip2(-2,2,-12,12, rand, ship1);
            threeship=false;
            }
        }
        /* Conditions for where the second and third ship part can be placed. */
        }
    }
    
    void setShip2(Integer left,Integer right,Integer up,Integer down, Integer rand, Integer ship1){
        /* Randomly selects where to place the second part of the ship. */
        switch (rand) {
            case 1:
                if (boxes[ship1+left].getAccessibleText().equals("X")){
                    rand = ThreadLocalRandom.current().nextInt(2,4+1);
                    setShip2(left,right,up,down,rand,ship1);
                }
                else{
                boxes[ship1+left].setAccessibleText("X");  
                }
                break;
            case 2:
                if (boxes[ship1+right].getAccessibleText().equals("X")){
                    rand = ThreadLocalRandom.current().nextInt(1,4+1);
                    setShip2(left,right,up,down,rand,ship1);
                }
                else{
                boxes[ship1+right].setAccessibleText("X");
                }
                break;
            case 3:
                if (boxes[ship1+up].getAccessibleText().equals("X")){
                    rand = ThreadLocalRandom.current().nextInt(1,4+1);
                    setShip2(left,right,up,down,rand,ship1);
                }
                else{
                boxes[ship1+up].setAccessibleText("X");
                }
                break;
            case 4:
                if (boxes[ship1+down].getAccessibleText().equals("X")){
                    rand = ThreadLocalRandom.current().nextInt(1,3+1);
                    setShip2(left,right,up,down,rand,ship1);
                }
                else{
                boxes[ship1+down].setAccessibleText("X");
                }
                break;
            default:
                break;
        }
    }
    
    void winbox(){
        /* Brings up a TextInputDialog box to input a name when the player gets a new score. */
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("New Score!");
        dialog.setHeaderText("You've beaten a previous score!");
        dialog.setContentText("Please enter your name:");
        Optional<String> result = dialog.showAndWait();
        nametext=dialog.getEditor().getText();
    }
    
    void winCheck()throws IOException {
        /* Checks for win or lose condition. */
        if (hits==5){
            playing=false;
            start=false;
            player = new MediaPlayer((new Media(getClass().getResource("/Win.mp3").toString())));
            player.play();
            current = (24-turns);
            readScores();  
            readWins();
            wincount=wincount+1;
            writeWins();
            lblWins.setText(""+wincount);
            /* Moves around the scores in the score arrays and writes to the scores file. */
                if (score[0] > current) {
                    winbox();
                    name[4]=name[3];
                    name[3]=name[2];
                    name[2]=name[1];
                    name[1]=name[0];
                    name[0]=(nametext);
                    score[4]=score[3];
                    score[3]=score[2];
                    score[2]=score[1];
                    score[1]=score[0];
                    score[0]=current;
                    writeScore();
                }
                else if (score[1] > current){
                    winbox();
                    name[4]=name[3];
                    name[3]=name[2];
                    name[2]=name[1];
                    name[1]=nametext;
                    score[4]=score[3];
                    score[3]=score[2];
                    score[2]=score[1];
                    score[1]=current;
                    writeScore();
                }
                else if (score[2] > current){
                    winbox();
                    name[4]=name[3];
                    name[3]=name[2];
                    name[2]=nametext;
                    score[4]=score[3];
                    score[3]=score[2];
                    score[2]=current;
                    writeScore();
                }
                else if (score[3] > current){
                    winbox();
                    name[4]=name[3];
                    name[3]=nametext;
                    score[4]=score[3];
                    score[3]=current;
                    writeScore();
                }
                else if (score[4] > current){
                    winbox();
                    name[4]=(nametext);
                    score[4]=current;
                    writeScore();
                }           
            MainApp.setRoot("winscreen");
        }
        else if (turns==0){
            playing=false;
            start=false;
            player = new MediaPlayer((new Media(getClass().getResource("/Fail.mp3").toString())));
            player.play();
            for (int i = 0; i < boxes.length; i++) {
                /* Changes the images so the player can see where the ships were. */
                if (boxes[i].getAccessibleText().equals("O")){
                boxes[i].setImage(null);
                }
                if (boxes[i].getAccessibleText().equals("X")){
                boxes[i].setImage(ship);
                }
            boxes[i].setAccessibleText("");
            MainApp.setRoot("losescreen");
        }
        }
    }
    
    @FXML
    void imgHover(MouseEvent event) {
        /* Causes the ImageView grids to expand when hovered over. */
        ImageView grid = (ImageView) event.getSource();
        String state = grid.getAccessibleText();
        if ((!"".equals(state))&&(playing==true)){ 
            grid.setFitHeight(110);
            grid.setFitWidth(110);
            grid.setTranslateX(-5);
            grid.setTranslateY(-5);
            grid.toFront();
        }
    }

    @FXML
    void imgUnhover(MouseEvent event) {
        /* Causes the expanded ImageView grids to shrink back to original size when not hovered over. */
        ImageView grid = (ImageView) event.getSource();
        grid.setFitHeight(100);
        grid.setFitWidth(100);
        grid.setTranslateX(0);
        grid.setTranslateY(0);
        grid.toBack();
    }
    
    @FXML
    void btnHover(MouseEvent event) {
        /* Causes Buttons to expand when hovered over. */
        Button button = (Button) event.getSource();
        button.setPrefHeight(55);
        button.setPrefWidth(82.5);
        button.setTranslateX(-2.5);
        button.setTranslateY(-3.75);
        button.toFront();     
    }
    
    @FXML
    void btnUnhover(MouseEvent event) {
        /* Causes expanded Buttons to shrink back to original size when not hovered over. */
        Button button = (Button) event.getSource();
        button.setPrefHeight(50);
        button.setPrefWidth(75);
        button.setTranslateX(0);
        button.setTranslateY(0);
        button.toBack();
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
        setShip();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        readScores();
        readWins();
        lblWins.setText(""+wincount);
    }    
}
