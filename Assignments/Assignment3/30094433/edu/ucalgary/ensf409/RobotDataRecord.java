package edu.ucalgary.ensf409;

import java.util.ArrayList;


public class RobotDataRecord extends RobotDataLine{
    // Member variables
    private ArrayList<RobotDataLine> log;

    // Constructor
    RobotDataRecord(String[] array){
        this.log.add(0, array);
    }

    // Getters
    public RobotDataLine getLine(int index){
        return this.log[i];
    }

    public ArrayList<RobotDataLine> getDataRecord(){
        return this.log;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
