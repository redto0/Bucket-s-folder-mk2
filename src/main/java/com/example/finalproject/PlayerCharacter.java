package com.example.finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class PlayerCharacter {
    public static int DiceCal(int rolls, int diceSides){
        int output = 0;
        for(int i = 1; i >= rolls; i++){
            output += Math.ceil(
                    diceSides * Math.random()
            );
        }
        return output;
    }

    private double hitPoints = 20;
    private double strength;
    private double dexterity;
    private double intelligence;
    private double totalGold = 0;
    private int roomNumber = 0;

    public PlayerCharacter() {
        this.hitPoints = 20;
        this.strength = DiceCal(3, 6);
        this.dexterity = DiceCal(3, 6);
        this.intelligence = DiceCal(3, 6);
        this.totalGold = 0;
    }


    public void PlayerCharacterDev(double hitPoints, double strength,
                                   double dexterity, double intelligence,
                                   double totalGold) {
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.totalGold = totalGold;
    }

    public void subtractHitPoints(double hitPoints) {
        this.hitPoints -= hitPoints;
    }
    public void setHitPoints(double hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void addToTotalGold(double totalGold) {
        this.totalGold += totalGold;
    }

    public double getTotalGold() {
        return totalGold;
    }
    public double getHitPoints() {
        return hitPoints;
    }
    public double getStrength() {
        return strength;
    }
    public double getDexterity() {
        return dexterity;
    }
    public double getIntelligence() {
        return intelligence;
    }

    @FXML
    private TextArea textarea;
    public int roomLeft(int i){
        //int i;
        // todone the setters for the left/right buttons aren't returning the correct value;
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
