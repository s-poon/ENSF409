/* Assignment 2 : RewardsProfile.java
 * @Author: Steven Poon
 * UCID: 30094433
 * Date Created: 15/02/2021
 * 
 * @Version: 1.0
 * @Since 1.0
 */

package edu.ucalgary.ensf409;

import java.util.regex.*;

public class RewardsProfile{
    //Member Variables
    private String rewardsNum = "Not enrolled";
    private int pointsTotal = 10;
    private boolean worked;
    //~ private final static String isInt = "[^0123456789]";
    //Constructors
    public RewardsProfile(){}
    
    public RewardsProfile(String newNumber){
        //~ try{
            //~ if(isNumber(newNumber)){
                //~ throw new InvalidRewardsNumException();
            //~ }
        //~ }
        //~ catch(Exception e){
            //~ worked = false;
            //~ return;
        //~ }
        //~ finally{
            //~ worked = true;
            //~ this.rewardsNum = newNumber;
            //~ return;
            
        //~ }
        if(isNumber(newNumber)){
            worked = false;
        }else{
            worked = true;
            this.rewardsNum = newNumber;
        }
    }
    
    public static boolean isNumber(String inputNumber) {
        Pattern isanInt = Pattern.compile("[^0123456789]");
        Matcher myMatcher = isanInt.matcher(inputNumber);
        return myMatcher.find();
    }
    
    //Setter
    public void setPoints(int addPoints){
        this.pointsTotal = addPoints;
    }
    
    //Getters
    public int getPoints(){ return this.pointsTotal; }
    public String getNumber(){ return this.rewardsNum; }
    public boolean getWorked(){ return this.worked; }
}
