package edu.ucalgary.ensf409;

import java.io.Serializable;

public class TranslationText implements Serializable{
    // Member Variables
    private String[] months = new String[12];
    private String[] days = new String[31];
    private String sentence = new String();
    static final long serialVersionUID = 19;

    // Constructor
    TranslationText(String[] months, String[] days, String sentence){
        this.months = months;
        this.days = days;
        this.sentence = sentence;
    }
    
    // Getters
    public String getSentence(){ return this.sentence; }
    public String[] getMonths(){ return this.months; }
    public String[] getDays(){ return this.days; }
    public String getMonth(int month){ return this.months[month]; }
    public String getDay(int day){ return this.days[day]; }
}
