package edu.ucalgary.ensf409;

import java.util.regex.*;

public class Movement implements Cloneable, FormattedOutput{
    // Enumerations
    enum Actions{
        FORWARD,
        LEFT,
        REVERSE,
        RIGHT,
        START,
        STOP
    }

    enum Directions{
        E{
            public String toString(){
                return "East";
            }
        },
        N{
            public String toString(){
                return "N";
            } 
        },
        NE{
            public String toString(){
                return "NE";
            }
        },
        NW{
            public String toString(){
                return "NW";
            }
        },
        S{
            public String toString(){
                return "S";
            }
        },
        SE{
            public String toString(){
                return "SE";
            }
        },
        SW{
            public String toString(){
                return "SW";
            }
        },
        W{
            public String toString(){
                return "W";
            }
        }
    }

    // Member Variables
    private String action;
    private String direction;
    private final static String REGEX = "\"([A-Z]+)\\s-\\s([A-Z]{1,2})";
    private final static Pattern PATTERN = Pattern.compile(REGEX);

    // Constructor
    Movement(String movement) throws IllegalArgumentException{
        String[] rawData = new String[2];
        Matcher move = PATTERN.matcher(movement);
        if(!move.find()){
            System.out.println("...");
            throw new IllegalArgumentException();
        }
        rawData = move.group(0).split("-");
        action = rawData[0].replaceAll("\"", "").strip();
        direction = rawData[1].strip();
    }

    //Getters
    public String getAction(){ return this.action; }
    public String getDirection(){ return this.direction; }

    // Methods 
    @Override
    public String getFormatted(){
        return "Action: " + this.action + ", Direction: " + this.direction;
    }

    public Object clone() throws CloneNotSupportedException{
        Movement newM = (Movement)super.clone();
        return newM;
        // return super.clone();
    }

    

}
