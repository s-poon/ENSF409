package edu.ucalgary.ensf409;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.*;

public class VisitorParking {
    // Member Variables
    private static final String REGEX = "[a-zA-Z0-9]{1,7}";
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    private String[] visitors;
    private LocalDate[] dates;
    private LocalDate today = LocalDate.now();

    // Constructors
    VisitorParking(){
        visitors = new String[2];
        dates = new LocalDate[2];
    }

    public VisitorParking(String licence, LocalDate date){
        Matcher match = PATTERN.matcher(licence);
        if(!match.matches() || licence.length() > 7 || date.isBefore(today))
            throw new IllegalArgumentException();
        visitors[0] = licence;
        dates[0] = date;
    }

    public VisitorParking(String licence)throws IllegalArgumentException{
        Matcher match = PATTERN.matcher(licence);
        if(!match.matches() || licence.length() > 7)
            throw new IllegalArgumentException();
        visitors[0] = licence;
        dates[0] = today;
    }

    // Setters

    // Getters
    public ArrayList<String> getLicencesRegisteredForDate(){ return null; }
    public ArrayList<String> getLicencesRegisteredForDate(LocalDate commonDate){
        return null;
    }

    public ArrayList<LocalDate> getAllDaysLicenceIsRegistered(String licence){
        return null;
    }

    public ArrayList<LocalDate> getStartDaysLicenceIsRegistered(String licence){
        return null;
    }
    // Methods
    public void addVisitorReservation(String licence) {
        Matcher match = PATTERN.matcher(licence);
        if(!match.matches() || licence.length() > 7)
            throw new IllegalArgumentException();
        if(visitors[0] == licence)
            throw new IllegalArgumentException();
        visitors[1] = licence;
        dates[1] = today;
    }
    
    public void addVisitorReservation(String licence, LocalDate date) {
        Matcher match = PATTERN.matcher(licence);
        if(!match.matches() || licence.length() > 7 || date.isBefore(today))
            throw new IllegalArgumentException();
        if(dates[0].plusDays(2).isAfter(date))
            throw new IllegalArgumentException();
        if(visitors[0] == null){
            visitors[0] = licence;
            dates[0] = date;

        }else{
            visitors[1] = licence;
            dates[1] = date;
        }
       
    }

    public boolean licenceIsRegisteredForDate(String licence, LocalDate date) {
        return false;
    }

    public boolean licenceIsRegisteredForDate(String licence) {
        return false;
    }
}
