package edu.ucalgary.ensf409;

import java.util.*;

interface PrintOutput{
    public void printStats(GameCharacter theCharacter);
    public void printFightLog(ArrayList<String> log);
    public void printMessage(String message);
}