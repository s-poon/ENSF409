/* Assignment 2 : Booking.java
 * @Author: Steven Poon
 * UCID: 30094433
 * Date Created: 15/02/2021
 * 
 * @Version: 1.0
 * @Since 1.0
 */

package edu.ucalgary.ensf409;

public class Booking{
    //Method Variables
    private String STARTDATE;
    private String ENDDATE;
    private Pet BOOKEDPET;
    private Employee CAREGIVER;
    
    //Constructor
    public Booking(Pet pet, Employee assigned, String startDate, String endDate){
        this.BOOKEDPET = pet;
        this.CAREGIVER = assigned;
        this.STARTDATE = startDate;
        this. ENDDATE = endDate;
    }
    
    //Getters
    public String getStartDate(){ return this.STARTDATE; }
    public String getEndDate(){ return this.ENDDATE; }
    public Pet getBookedPet(){ return this.BOOKEDPET; }
    public Employee getCaregiver(){ return this.CAREGIVER; }
}
