package edu.ucalgary.ensf409;

/* Exercise Sheet 5.1
 * @Author: Steven Poon
 * UCID: 30094433
 * Date Created: 23/01/2021
 * 
 * @Version: 1.8
 * @Since 1.0
 */

/*
Copyright Ann Barcomb and Emily Marasco, 2021-2022
All rights reserved.
*/

// Importing Classes
import java.util.regex.*;

public class Trip {
    private String arrival;
    private String departure;
    private String city;
    private String country;

    // Returns a string in the format of:
    // value (key)
    public static String fmtString(String key, String value){
        return new String(value + " (" + key + ")");
    }

    // Constructor
    public Trip(String[] array){
        arrival = array[0];
        departure = array[1];
        city = array[2];
        country = array[3];
    }

    // Given a date string, return just the year
    public static int getYear(String date){
        String[] yearMonthDay = date.split("-");
        return Integer.parseInt(yearMonthDay[0]);
    }

    // Given a date string, return just the month
    // Since it is an int, a date like "2022-01-12" returns 1
    public static int getMonth(String date){
        String[] yearMonthDay = date.split("-");
        return Integer.parseInt(yearMonthDay[1]);
    }

    // Return a formatted string of key/value pairs, with commas
    // between each. See the output for an example.
    public String formatTrip(){
        String formattedTrip = arrival + " (Arrival), " + departure + 
                " (Departure), " + city + " (City), " + country + " (Country)";
        return formattedTrip;
    }

    // Getter
    public String getArrival(){
        return arrival;
    }

    // Getter
    public String getDeparture(){
        return departure;
    }

    // Getter
    public String getCity(){
        return city;
    }

    // Getter
    public String getCountry(){
        return country;
    }

    // Setter
    public void setArrival(String date){
        arrival = date;
    }

    // Setter
    public void setDeparture(String date){
        departure = date;
    }

    // Setter 
    public void setCity(String city){
        this.city = city;
    }

    // Setter 
    public void setCountry(String country) {
        this.country = country;
    }
}
