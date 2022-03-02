/* Exercise Sheet 5.1
 * @Author: Steven Poon
 * UCID: 30094433
 * Date Created: 23/01/2021
 * 
 * @Version: 1.8
 * @Since 1.0
 */

// Package
package edu.ucalgary.ensf409;

/*
Copyright Ann Barcomb and Emily Marasco, 2021-2022
All rights reserved.
*/


import java.util.Objects;
public class Itinerary {
    private Trip[] trips = new Trip[20];
    private int tripsLength;
    // Returns a string in the format of:
    // value (key)
    public static String fmtString(String key, String value){
        return new String(value + " (" + key + ")");
    }

    // Constructor
    public Itinerary(String[][] myTrips) {
        for(int i = 0; i < myTrips.length; i ++){
            trips[i] = new Trip(myTrips[i]);
            tripsLength = i + 1;
        }
    }

    // Getter
    public Trip[] getTrips(){
        return trips;
    }

    public String formatByArrival(){
        String arrivals = new String();
        int year = 0;
        int month = 0;
        for(int i = 0; i < tripsLength; i ++){
            if(trips[i].getYear(trips[i].getArrival()) != year){
                year = trips[i].getYear(trips[i].getArrival());
                arrivals = new String(arrivals + year + " (Year)\n");
            }
            if(trips[i].getMonth(trips[i].getArrival()) != month){
                month = trips[i].getMonth(trips[i].getArrival());
                arrivals = new String(arrivals + "--" + month + " (Month)\n");
            }
            String city = trips[i].getCity();
            String country = trips[i].getCountry();
            arrivals = new String(arrivals + "----" + city + " (City), " + 
                    country + " (Country) (Place)\n");
        }
        return arrivals;
    }

    // The first array holds years (2021-2023).
    // The second array holds months.
    // The third array holds formatted locations occurring in the year/month
    String[][][] byDate(){
        String [][][] dates = new String[3][12][15];
        int j = 0;
        int newYear = 0;
        int newMonth = 0;
        for(int i = 0; i < tripsLength; i++){
            int year = trips[i].getYear(trips[i].getArrival()) - 2021;
            int month = month = trips[i].getMonth(trips[i].getArrival()) - 1;
            String city = trips[i].getCity();
            String country = trips[i].getCountry();
            if(month != newMonth){
                newMonth = month;
                j = 0;
            }
            dates[year][month][j] = city + " (City), " + country + " (Country)";
            j ++;
        }
        
        return dates;
    }

}



























