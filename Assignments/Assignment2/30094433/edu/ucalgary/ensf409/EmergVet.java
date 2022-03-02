/* Assignment 2 : EmergVet.java
 * @Author: Steven Poon
 * UCID: 30094433
 * Date Created: 15/02/2021
 * 
 * @Version: 1.0
 * @Since 1.0
 */

package edu.ucalgary.ensf409;

public class EmergVet{
    // Member Variables
    private String name;
    private String phoneNum;
    
    // Constructors
    public EmergVet(String name, String phoneNumber){
        this.name = name;
        this.phoneNum = phoneNumber;
    }
    
    //Getters
    public String getName(){ return this.name; }
    public String getPhoneNum(){ return this.phoneNum; }
}
