package com.example.finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;

public class Room {
    @FXML
    private TextArea textarea;

    private double goldPresent;
    private boolean isDiscovered = false;
    private NPC currentNPC;
    private boolean isBlocked;
    private PlayerCharacter CurrentPlayerCharacter;
    private boolean checker;

    public Room(double goldPresent, boolean isDiscovered, NPC currentNPC, PlayerCharacter currentPlayerCharacter) {
        this.goldPresent = goldPresent;
        this.isDiscovered = isDiscovered;
        this.currentNPC = currentNPC;
        CurrentPlayerCharacter = currentPlayerCharacter;
    }

    public ArrayList<Room> genRooms(ArrayList<Room> Arr){
        for (int k = 0; k < 99; k++){
            Arr.add(new Room());
        }
        return Arr;
    }

    public Room() {
        System.out.println("start one\n");
        this.goldPresent = DiceCal(1, 6);
        System.out.println("Dice cal done\n");
        this.isDiscovered = false;
        System.out.println("isDiscovered done\n");
        this.currentNPC = new NPC();
        System.out.println("isDiscovered done\n");
        setBlocked();
        System.out.println("setBlocked done\n");
    }

    public void setBlocked() {
        boolean blocked;
        int Ran = (int) Math.round( Math.random() + 0.3 );
        if (Ran == 1){
            blocked = true;
        }else if (Ran == 0){
            blocked = false;
        } else {
            blocked = false;
        }
        this.isBlocked = blocked;
    }

    public void setGoldPresent(double goldPresent) {
        this.goldPresent = goldPresent;
    }

    public void SearchRoom(){
        if (this.currentNPC.getHitPoints() <= 0){
            CurrentPlayerCharacter.addToTotalGold(this.goldPresent);
            setGoldPresent(0.0);
            /** printout how much gold we got */
        }else{
            //todo print out no gold
        }
    }

    // example for left/righters

    public boolean isChecker() {
        return checker;
    }


    public static double DiceCal(int rolls, int diceSides){
        int output = 0;
        for(int i = 1; i >= rolls; i++){
            output += Math.ceil(
                    diceSides * Math.random()
            );
        }
        return (double) output;
    }

    public void setChecker(boolean checker) {
        this.checker = checker;
    }

    public double getGoldPresent() {
        return goldPresent;
    }

    public NPC getCurrentNPC() {
        return currentNPC;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public PlayerCharacter getCurrentPlayerCharacter() {
        return CurrentPlayerCharacter;
    }
}
