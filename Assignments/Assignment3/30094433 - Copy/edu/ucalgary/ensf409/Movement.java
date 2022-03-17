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
                return "North";
            } 
        },
        NE{
            public String toString(){
                return "Norteast";
            }
        },
        NW{
            public String toString(){
                return "Northwest";
            }
        },
        S{
            public String toString(){
                return "South";
            }
        },
        SE{
            public String toString(){
                return "Southeast";
            }
        },
        SW{
            public String toString(){
                return "Southwest";
            }
        },
        W{
            public String toString(){
                return "West";
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
        return "Action: " + this.action + ", Direction: " + directionToEnum(this.direction);
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        Movement newM = (Movement)super.clone();
        newM.action = this.action;
        newM.direction = this.direction;
        return newM;
    }

    public static String directionToEnum(String input){
        String output = new String();
        switch(input){
            case "N":
                output = Directions.N.toString();
                break;
            case "NE":
                output = Directions.NE.toString();
                break;
            case "E":
                output = Directions.E.toString();
                break;
            case "SE":
                output = Directions.SE.toString();
                break;
            case "S":
                output = Directions.S.toString();
                break;
            case "SW":
                output = Directions.SW.toString();
                break;
            case "W":
                output = Directions.W.toString();
                break;
            case "NW":
                output = Directions.NW.toString();
                break;
        }
        return output;
    }
}
