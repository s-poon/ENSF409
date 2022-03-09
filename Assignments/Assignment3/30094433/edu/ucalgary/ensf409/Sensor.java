package edu.ucalgary.ensf409;

import java.util.regex.Pattern;

// import javax.naming.ldap.SortResponseControl;

public class Sensor implements Cloneable, FormattedOutput{
    // Member Variables
    private String sensor;
    private final static String REGEX = "\\(([a-z]+)\\)";
    private final static Pattern PATTERN = Pattern.compile(REGEX);

    // Constructor
    Sensor(String sensor) throws IllegalArgumentException{
        this.sensor = sensor;
    }

    // Getters
    public String getSensor(){ return this.sensor; }

    // Methods
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    @Override
    public String getFormatted(){
        return new String();
    }
}
