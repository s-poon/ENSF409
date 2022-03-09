package edu.ucalgary.ensf409;

import java.time.LocalDate;

import java.util.regex.*;

public class RobotDataLine extends Movement{
    // Member Variables
    private String dataLine;
    private String robotID;
    private Sensor senor;
    private LocalDate date;
    private static final String DATE_REGEX = "\\[([0-9]{1,2})/([0-9]{1,2})/([0-9]{4})\\]";
    private static final Pattern DATE_PATTERN = Pattern.compile(DATE_REGEX);
    private static final String ROBOT_REGEX = "\\s([0-9]{3}[A-Z]{1})\\s";
    private static final Pattern ROBOT_PATTERN = Pattern.compile(ROBOT_REGEX);

    // Constructor
    RobotDataLine(String line) throws IllegalArgumentException{

    }

    // Getters
    public String getRobotID(){ return this.robotID; }
    public String getDataLine(){ return this.dataLine; }
    public Sensor getSenor(){ return this.senor; }
    public Movement getMovement(){ return this.getMovement(); }
    public LocalDate getDate(){ return this.date; }

    // Methods
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }



}
