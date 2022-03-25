package edu.ucalgary.ensf409;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.*;

public class RobotDataLine extends Movement{
    // Member Variables
    private String dataLine;
    private String robotID;
    private Sensor sensor;
    private LocalDate date;
    private Movement movement;
    private static final String DATE_REGEX = "\\[([0-9]{1,2})/([0-9]{1,2})/([0-9]{4})\\]";
    private static final Pattern DATE_PATTERN = Pattern.compile(DATE_REGEX);
    private static final String ROBOT_REGEX = "\\s([0-9]{3}[A-Z]{1})\\s";
    private static final Pattern ROBOT_PATTERN = Pattern.compile(ROBOT_REGEX);

    // Constructor
    RobotDataLine(String line) throws IllegalArgumentException{
        super(line);
        movement = new Movement(line);
        this.sensor = new Sensor(line);
        dataLine = line;
        Matcher robot = ROBOT_PATTERN.matcher(line);
        Matcher thisDate = DATE_PATTERN.matcher(line);
        if(robot.find()){
            robotID = robot.group(0).strip();
        } else{
            throw new IllegalArgumentException();
        }
        if(thisDate.find()){
            String testDate = thisDate.group(0);
            testDate = testDate.replaceAll("[\\[\\]]", "");
            // testDate = testDate.strip();
            try {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                date = LocalDate.parse(testDate, format);
            } catch (DateTimeParseException e) {
                System.out.println("bruh");
                throw new IllegalArgumentException();
            }finally{

            }
        }

    }

    // Getters
    public String getRobotID(){ return this.robotID; }
    public String getDataLine(){ return this.dataLine; }
    public Sensor getSensor(){ return this.sensor; }
    public Movement getMovement(){ return this.movement; }
    public LocalDate getDate(){ return this.date; }

    // Methods
    @Override
    public Object clone() throws CloneNotSupportedException{
        RobotDataLine newR = (RobotDataLine)super.clone();
        newR.dataLine = this.getDataLine();
        
        return newR;
    }



}
