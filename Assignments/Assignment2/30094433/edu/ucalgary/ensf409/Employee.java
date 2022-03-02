/* Assignment 2 : Employee.java
 * @Author: Steven Poon
 * UCID: 30094433
 * Date Created: 15/02/2021
 * 
 * @Version: 1.0
 * @Since 1.0
 */

package edu.ucalgary.ensf409;

public class Employee{
    //Member Variables
    private String name;
    private String IDNUMBER;
    private String managerID;
    private Employee[] supervisedEmployees = new Employee[10];
    
    //Constructors
    public Employee(String name, String idNumber){
        this.name = name;
        this.IDNUMBER = idNumber;
    }
    
    public Employee(String name, String idNumber, String managerID){
        this.name = name;
        this.IDNUMBER = idNumber;
        this.managerID = managerID;
    }
    
    //Methods
    public void addEmployee(Employee newEmployee){
        int numberEmployees = this.supervisedEmployees.length;
        if(numberEmployees < 10){
            this.supervisedEmployees[numberEmployees] = newEmployee;
        }
    }
            
        
    //Setters
    public void setName(String name){
        this.name = name;
    }
    
    public void setManagerID(String newManager){
        this.managerID = newManager;
    }
    
    //Getters
    public String getName(){ return this.name; }
    public String getIDNumber(){ return this.IDNUMBER; }
    public String getManagerID(){ return this.managerID; }
    public Employee[] getEmployees(){ return this.supervisedEmployees; }
}














