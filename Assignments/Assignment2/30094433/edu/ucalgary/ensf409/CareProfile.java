/* Assignment 2 : CareProfile.java
 * @Author: Steven Poon
 * UCID: 30094433
 * Date Created: 15/02/2021
 * 
 * @Version: 1.0
 * @Since 1.0
 */

package edu.ucalgary.ensf409;

public class CareProfile{
    //Member Variables
    private String[] medList = new String[20];
    private String medInstructions;
    private String feedingInstructions;
    public String name;
    
    //Constructors
    public CareProfile(String[] medList, String meds, String feeding){
        for(int i = 0; i < medList.length; i ++){
            this.medList[i] = medList[i];
        }
        this.medInstructions = meds;
        this.feedingInstructions = feeding;
    }
    
    public String summarizeCareInstructions(){
        String instructions = "Care for " + name + "\n";
        for(int i = 0; i < medList.length; i ++){
            if(medList[i + 1] == null){
                instructions += medList[i] + "\n";
                break;
            }else{
                instructions += medList[i] + ", ";
            }
        }
        instructions += this.medInstructions + "\n";
        instructions += this.feedingInstructions;
        return instructions;
    }
    
    
}
