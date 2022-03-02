/*
Copyright Ann Barcomb and Emily Marasco, 2022
All rights reserved. This code may not be published or shared.
Sharing or posting this code is an academic integrity violation.
*/

package edu.ucalgary.ensf409;

class LocationFormatting {
    /*
     * Convert key to upper case, then format as: KEY = value
     * @return formatted key-value pair
    */
    String formatOutput(String key, String value) {
        String newKey = key.toUpperCase();
        return newKey + " = " + value;
    }
}
