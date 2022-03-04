/*
Copyright Ann Barcomb and Emily Marasco, 2022
Licensed under GPL v3
See LICENSE.txt for more information.
*/

package edu.ucalgary.ensf409;

import java.util.*;

public class PlayTheGame implements InterfacePrintOutput{
    public static void main(String[] args) throws IllegalArgumentException, SingleUseMethodException {
        System.out.println("Meet our characters.\n");

        var char1 = new CharacterWarrior("Katniss", 110, "bow", "knife");
        printStats(char1);
        System.out.println("");

        var char2 = new CharacterWarrior("Xena", 92, "short sword");
        printStats(char2);
        System.out.println("");

        var char4 = new CharacterRogue("Alexander Hamilton", 90);
        printStats(char4);
        System.out.println("");

        var char5 = new CharacterRogue("Aaron Burr", 91);
        printStats(char5);
        System.out.println("");

        System.out.println("Starting a duel between Alexander Hamilton and Aaron Burr.");
        var combat = new Duel(char4, char5);
        ArrayList<String> outcome = combat.fightAndReturnLog();  
        printFightLog(outcome);
    }

    @Override
    public static void printFightLog(ArrayList<String> log) {
        InterfacePrintOutput.super.printFightLog(log);
    }
    
    @Override
    public static void printStats(GameCharacter theCharacter) {

    }
}