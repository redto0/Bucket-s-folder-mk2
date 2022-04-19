package com.example.finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class NPC extends PlayerCharacter {
    private double hitPoints = 6;
    private double strength;
    private double dexterity;
    private double intelligence;
    private double totalGold = 0;

    @FXML
    private TextArea textarea;

    public static int DiceCal(int rolls, int diceSides){
        int output = 0;
        for(int i = 1; i >= rolls; i++){
            output += Math.ceil(
                    diceSides * Math.random()
            );
        }
        return output;
    }
    /*
    public NPC(){
        this.hitPoints = 6;
        this.strength = DiceCal(2, 6);
        this.dexterity = DiceCal(2, 6);
        this.intelligence = DiceCal(2, 6);
        this.totalGold = 0;
    }*/
    public NPC() {
        this.hitPoints = 6;
        this.strength = DiceCal(2, 6);
        this.dexterity = DiceCal(2, 6);
        this.intelligence = DiceCal(2, 6);
        this.totalGold = DiceCal(1, 6);
    }
    public double DefendFromNPC (NPC NPC, PlayerCharacter PlayerCharacterRN){
        // TODO Defend from NPC done and Attack NPC
        if (NPC.getHitPoints() > 0){
            double lostPoints =  ( NPC.getStrength()/2 ) * Math.random();
            PlayerCharacterRN.subtractHitPoints( ( NPC.getStrength()/2 ) * Math.random() );
            // it attacks us!
            textarea.appendText("NPC did " + lostPoints + " damage\n" +
                    "You now have this " + PlayerCharacterRN.getHitPoints() + " many hit points left\n");
            return lostPoints;
        }else{
            textarea.appendText("NPC did no damage!");
            return 0.0;
        }
    }
    // TODO
    public void AttackNPC(NPC NPC,  PlayerCharacter PlayerCharacterRN) {
        double dStrength = PlayerCharacterRN.getStrength()/3;
        double DexRoll = DiceCal(1, 20);
        double dDexRoll = DexRoll - NPC.getDexterity();
        textarea.appendText("\nYou rolled " + DexRoll + "\n");
        if (dDexRoll > 0) {
            NPC.subtractHitPoints( dStrength );
            textarea.appendText("You Did " + dStrength + " Damage!\n");
        } else {
            textarea.appendText("Rolled to low! No damage done\n");
        }
        DefendFromNPC(NPC, PlayerCharacterRN);
    }

    public void RunAwayFromNPC(NPC NPC, PlayerCharacter PlayerCharacterRN){
        double IntellaganceRoll = DiceCal(1, 20);
        if (PlayerCharacterRN.getIntelligence() > IntellaganceRoll) {
            textarea.appendText("Successful snuck away without alerting the NPC!!\n");
        } else {
            textarea.appendText("NPC saw you trying to leave!\n");
            DefendFromNPC(NPC,PlayerCharacterRN);
        }
        // Room.chooseRoom
    }


}
