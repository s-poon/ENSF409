/* Assignment 2 : Client.java
 * @Author: Steven Poon
 * UCID: 30094433
 * Date Created: 15/02/2021
 * 
 * @Version: 1.0
 * @Since 1.0
 */

package edu.ucalgary.ensf409;

public class Client{
    //Member variables
    private String name;
    private String phoneNumber;
    private String address;
    private RewardsProfile rewardsInfo = new RewardsProfile();
    
    //Constructors
    public Client(String name, String phoneNumber, String address){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    
    //Methods
    public boolean enrollRewards(String newNumber){
        this.rewardsInfo = new RewardsProfile(newNumber);
        return this.rewardsInfo.getWorked();
    }
    
    public void updatePoints(int addPoints){
        int points = this.rewardsInfo.getPoints();
        this.rewardsInfo.setPoints(points + addPoints);
    }
    
    //Setters
    public void setName(String name){
        this.name = name;
    }
    
    public void setPhoneNumber(String num){
        this.phoneNumber = num;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    //Getters
    public int getRewardsPoints(){ return this.rewardsInfo.getPoints(); }
    public String getRewardsNumber(){ return this.rewardsInfo.getNumber(); }
    public String getName(){ return this.name; };
    public String getPhoneNumber(){ return this.phoneNumber; }
    public String getAddress(){ return this.address; }
    
        
}
