/* Assignment 2 : ReportCard.java
 * @Author: Steven Poon
 * UCID: 30094433
 * Date Created: 15/02/2021
 * 
 * @Version: 1.0
 * @Since 1.0
 */

package edu.ucalgary.ensf409;

public class ReportCard{
    //Member Variables
    private Booking REPORT;
    
    //Constructor
    public ReportCard(Booking reportInfo){
        this.REPORT = reportInfo;
    }
    
    public String printReport(){
        String report = this.REPORT.getCaregiver().getName() + 
            " enjoyed taking care of " + this.REPORT.getBookedPet().getName() + 
                                                        ". See you next time!";
        return report;
    }
}
