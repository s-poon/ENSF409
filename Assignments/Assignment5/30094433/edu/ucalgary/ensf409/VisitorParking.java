package edu.ucalgary.ensf409;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;

import javax.lang.model.util.ElementScanner6;


public class VisitorParking {
    // Member Variables
    private static final String REGEX = "[a-zA-Z0-9]{1,7}";
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    HashMap<String, ArrayList<LocalDate>> currentLicences = new HashMap<>();
    private LocalDate today = LocalDate.now();

    // Constructors
    VisitorParking(){
    }

    public VisitorParking(String licence, LocalDate date){
        Matcher match = PATTERN.matcher(licence);
        if(!match.matches() || licence.length() > 7 || date.isBefore(today))
            throw new IllegalArgumentException();
        currentLicences.computeIfAbsent(licence, k -> new ArrayList<>()).add(date);
    }

    public VisitorParking(String licence)throws IllegalArgumentException{
        Matcher match = PATTERN.matcher(licence);
        if(!match.matches() || licence.length() > 7)
            throw new IllegalArgumentException();
        currentLicences.computeIfAbsent(licence, k -> new ArrayList<>()).add(today);
    }

    // Setters

    // Getters
    public ArrayList<String> getLicencesRegisteredForDate(){ return null; }
    public ArrayList<String> getLicencesRegisteredForDate(LocalDate commonDate){
        return null;
    }

    public ArrayList<LocalDate> getAllDaysLicenceIsRegistered(String licence){
        return currentLicences.get(licence);
    }

    public ArrayList<LocalDate> getStartDaysLicenceIsRegistered(String licence){
        return null;
    }

    // Methods
    public void addVisitorReservation(String licence) {
        addVisitorReservation(licence, today);
    }
    
    public void addVisitorReservation(String licence, LocalDate date) {
        Matcher match = PATTERN.matcher(licence);
        ArrayList<LocalDate> datesForKey;
        if(!match.matches() || licence.length() > 7 || date.isBefore(today))
            throw new IllegalArgumentException();
        if(currentLicences.get(licence) == null){
            currentLicences.computeIfAbsent(licence, k -> new ArrayList<>()).add(date);
            currentLicences.computeIfAbsent(licence, k -> new ArrayList<>()).add(date.plusDays(1));
            currentLicences.computeIfAbsent(licence, k -> new ArrayList<>()).add(date.plusDays(2));
            return;
        }
        datesForKey = currentLicences.get(licence);
        for(LocalDate checkDate:datesForKey){
            if(date.isBefore(checkDate) && date.plusDays(2).isAfter(checkDate))
                throw new IllegalArgumentException();
                
        }
        currentLicences.computeIfAbsent(licence, k -> new ArrayList<>()).add(date); 
    }

    public boolean licenceIsRegisteredForDate(String licence, LocalDate date) {
        return false;
    }

    public boolean licenceIsRegisteredForDate(String licence) {
        return false;
    }
}
