package edu.ucalgary.ensf409;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// import javax.naming.ldap.SortResponseControl;

public class Sensor implements Cloneable, FormattedOutput{
    // Member Variables
    private String sensor;
    private final static String REGEX = "\\(([a-z]+)\\)";
    private final static Pattern PATTERN = Pattern.compile(REGEX);

    // Constructor
    Sensor(String sensor) throws IllegalArgumentException{
        Matcher thisSensor = PATTERN.matcher(sensor);
        if(!thisSensor.find())
            throw new IllegalArgumentException();
        this.sensor = thisSensor.group(0);
        this.sensor = this.sensor.replaceAll("[\\(\\)]", "");
    }

    // Getters
    public String getSensor(){ return this.sensor; }

    // Methods
    public Object clone() throws CloneNotSupportedException{
        Sensor newS = (Sensor)super.clone();
        return newS;
    }
    @Override
    public String getFormatted(){
        return "Sensor: " + this.sensor;
    }
}
