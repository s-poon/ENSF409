package edu.ucalgary.ensf409;

import java.util.ArrayList;


public class RobotDataRecord extends RobotDataLine{
    // Member variables
    private ArrayList<RobotDataLine> log = new ArrayList<>();

    // Constructor
    RobotDataRecord(String[] array){
        super(array[0]);
        for(int i = 0; i < array.length; i ++){
            RobotDataLine temp = new RobotDataLine(array[i]);
            log.add(i, temp);
        }
    }

    // Getters
    public RobotDataLine getLine(int index){
        return this.log.get(index);
    }

    public ArrayList<RobotDataLine> getDataRecord(){
        return this.log;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
