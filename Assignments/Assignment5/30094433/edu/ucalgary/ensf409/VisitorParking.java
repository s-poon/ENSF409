package edu.ucalgary.ensf409;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;




public class VisitorParking {
    // Member Variables
    HashMap<String, ArrayList<LocalDate>> currentLicences = new HashMap<>();
    private LocalDate today = LocalDate.now();

    // Constructors
    VisitorParking(){}

    public VisitorParking(String licence, LocalDate date)throws IllegalArgumentException{
        if(date.isBefore(today))
            throw new IllegalArgumentException();
        licence = Parking.standardizeAndValidateLicence(licence);
        currentLicences.computeIfAbsent(licence, k -> new ArrayList<>()).add(date);
    }

    public VisitorParking(String licence)throws IllegalArgumentException{
        licence = Parking.standardizeAndValidateLicence(licence);
        currentLicences.computeIfAbsent(licence, k -> new ArrayList<>()).add(today);
    }

    // Setters

    // Getters
    public ArrayList<String> getLicencesRegisteredForDate(){ 
        ArrayList<String> licences = new ArrayList<>();
        for(String key:currentLicences.keySet())
            for(LocalDate checkDate:currentLicences.get(key))
                if(checkDate == today)
                    licences.add(key);
        return licences; 
    }
    public ArrayList<String> getLicencesRegisteredForDate(LocalDate date){
        ArrayList<String> licences = new ArrayList<>();
        for(String key:currentLicences.keySet())
            for(LocalDate checkDate:currentLicences.get(key))
                if(checkDate == date)
                    licences.add(key);
        return licences; 
    }

    public ArrayList<LocalDate> getAllDaysLicenceIsRegistered(String licence){
        return currentLicences.get(licence).sort();
    }

    public ArrayList<LocalDate> getStartDaysLicenceIsRegistered(String licence){
        ArrayList<LocalDate> startDates = new ArrayList<>();
        for(int i = 0; i < currentLicences.get(licence).size(); i += 3){
            startDates.add(currentLicences.get(licence).get(i));
        }
        Collections.sort(startDates);
        return startDates;
    }

    // Methods
    public void addVisitorReservation(String licence) {
        addVisitorReservation(licence, today);
    }
    
    public void addVisitorReservation(String licence, LocalDate date) throws IllegalArgumentException{
        licence = Parking.standardizeAndValidateLicence(licence);
        int numReservations = 0;
        if(date.isBefore(today))
            throw new IllegalArgumentException();
        if(currentLicences.get(licence) == null){
            currentLicences.computeIfAbsent(licence, k -> new ArrayList<>()).add(date);
            currentLicences.computeIfAbsent(licence, k -> new ArrayList<>()).add(date.plusDays(1));
            currentLicences.computeIfAbsent(licence, k -> new ArrayList<>()).add(date.plusDays(2));
            return;
        }
        for(LocalDate checkDate:currentLicences.get(licence)){
            if(date.isBefore(checkDate) && date.plusDays(2).isAfter(checkDate))
                throw new IllegalArgumentException();
        }

        for(String key:currentLicences.keySet())
            for(LocalDate checkDate:currentLicences.get(key))
                if(checkDate == date)
                    numReservations ++;
        if(numReservations > 1)
            throw new IllegalArgumentException();
        currentLicences.computeIfAbsent(licence, k -> new ArrayList<>()).add(date); 
        currentLicences.computeIfAbsent(licence, k -> new ArrayList<>()).add(date.plusDays(1));
        currentLicences.computeIfAbsent(licence, k -> new ArrayList<>()).add(date.plusDays(2));
    }

    public boolean licenceIsRegisteredForDate(String licence, LocalDate date) {
        try{
            currentLicences.get(licence).contains(date);
        }catch(NullPointerException e){
            return false;
        }
        
        return currentLicences.get(licence).contains(date);
    }

    public boolean licenceIsRegisteredForDate(String licence) {
        return currentLicences.get(licence).contains(today);
    }
}
