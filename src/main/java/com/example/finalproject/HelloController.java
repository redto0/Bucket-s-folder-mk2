package com.example.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;


public class HelloController {

    // todo add output box please

    int j = -1;
    //ArrayList<Room> //RoomArrL = genRooms();
    int i = -1;
    Room[] RoomArrL = new Room[99];
    PlayerCharacter Player = new PlayerCharacter();
    @FXML
    private Button moveupbutton;
    @FXML
    private Button sleepbutton;
    @FXML
    private Button fightbutton;
    @FXML
    private Button movedownbutton;
    @FXML
    private Button moveleftbutton;
    @FXML
    private Button searchbutton;
    @FXML
    private Button moverightbutton;
    @FXML
    private Button runbutton;
    @FXML
    private Label gold;
    @FXML
    private TextArea playerstats;
    @FXML
    private TextArea NPCstats;
    @FXML
    private TextArea textarea;
    @FXML
    private Button Restarter;

    //for (int k = 0; k < 99; k++){
    //    RoomArrL.add(new Room());
    // todo make for loop work
    //}

    @FXML
    public void RestarterClicked(ActionEvent actionEvent) {
        Restart();
        Restarter.setText("Restart");
        //textarea.appendText("This is the gold check " + RoomArrL.length + "\n" );
    }

    @FXML
    public void runButtonClicked(ActionEvent actionEvent) {
        //double roomer = RoomArrL.get(9).getGoldPresent();
        //textarea.appendText("This is the gold check " + roomer );
        //roomer.getGoldPresent();
    }

    @FXML
    public void searchButtonClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void fightButtonClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void sleepButtonClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void moveUpButtonClicked(ActionEvent actionEvent) {
        //textarea.appendText("You moved UP a room\n");
            i = roomUp(i);
    }

    @FXML
    public void moveRightButtonClicked(ActionEvent actionEvent) {
        //textarea.appendText("You moved RIGHT a room\n");
        i = roomRight(i);
    }

    @FXML
    public void moveLeftButtonClicked(ActionEvent actionEvent) {
        //textarea.appendText("You moved LEFT a room\n");
        i = roomLeft(i);
        //textarea.appendText("your room is " + i + "\n");
    }

    @FXML
    public void moveDownButtonClicked(ActionEvent actionEvent) {
        //textarea.appendText("You moved DOWN a room\n");
        i = roomDown(i);
    }

    public void Restart (){
        textarea.setText("");
        Restarter.setText("Restart");
        Restarter.textProperty();
        i = 0;
        //RoomArrL.clear();
        Player = new PlayerCharacter();
        for (double k = 0; k < 100; k++){
            System.out.println(k + "k mf\n");
            textarea.appendText(k + "k mf\n");
            // todo fix me, I crash the game
            // the below is the issue, the loop works fine and all, but it doesn't now
            RoomArrL[ (int) k ] = new Room();
        }
    };


    public int roomLeft(int i){
        //int i;
        // todo the setters for the left/right buttons aren't returning the correct value;
        int k = i;
        while (i > 0){

            i -= 10;
        }
        if (i != 0){
            k--;
            textarea.appendText("You moved LEFT to room " + k + "\n");
        } else {
            textarea.appendText("You were unable to move LEFT\n");
        }
        return k;
    }
    public int roomDown(int i){
        if (i < 90){
            i += 10;
            textarea.appendText("You moved DOWN to room " + i + "\n");
        }else {
            textarea.appendText("You were unable to move DOWN\n");
        }   return i;
    }

    public int roomUp(int i){
        if (i > 9){
            i -= 10;
            textarea.appendText("You moved UP to room " + i + "\n");

        } else {
            textarea.appendText("You were unable to move UP\n");
        } return i;
    }

    public int roomRight(int i){
        int j = i + 1;
        if( j % 10 != 0){
            textarea.appendText("You moved RIGHT to room " + j + "\n");
            return j;
        } else {
            textarea.appendText("You were unable to move RIGHT\n");
            return i;
        }
    }
}