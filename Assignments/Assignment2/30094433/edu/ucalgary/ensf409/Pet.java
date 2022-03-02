/* Assignment 2 : Pet.java
 * @Author: Steven Poon
 * UCID: 30094433
 * Date Created: 15/02/2021
 * 
 * @Version: 1.0
 * @Since 1.0
 */

package edu.ucalgary.ensf409;

public class Pet{
    //Member Variables
    private String NAME;
    private String SPECIES;
    private String BREED;
    private String COLOUR;
    private boolean vaccineStatus = false;
    private Client owner;
    private EmergVet vet;
    private CareProfile care;
    
    //Constructors
    public Pet(String name, String species, String breed, String colour, 
                                                                Client owner){
        NAME = name;
        SPECIES = species;
        BREED = breed;
        COLOUR = colour;
        this.owner = owner;
    }
    
    //Setters
    public void setVet(EmergVet vet){
        this.vet = vet;
    }
    
    public void setCare(String[] meds, String medInstr, String feedingInstr){
        care = new CareProfile(meds, medInstr, feedingInstr);
        care.name = this.getName();
    }
    
    public void updateVaccineStatus(boolean change){
        vaccineStatus = change;
    }
    
    public void setOwner(Client updateOwner){
        this.owner = updateOwner;
    }
    
    //Getters
    public EmergVet getVet(){ return this.vet; }
    public boolean getVaccineStatus(){ return this.vaccineStatus; }
    public String getCareSummary(){ return this.care.summarizeCareInstructions();}
    public Client getOwner(){ return this.owner; }
    public String getName(){ return this.NAME; }
    public String getSpecies(){ return this.SPECIES; }
    public String getBreed(){ return this.BREED; }
    public String getColour(){ return this.COLOUR; }
}
        
    
