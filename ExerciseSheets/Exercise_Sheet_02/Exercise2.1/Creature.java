/*
 * @Author: Steven Poon
 * Date Created: 11/01/2021
 * 
 * @Version: 1.1
 * @Since 1.0
 */

public class Creature{
    //@param args Handles command-line argument
    public static void main(String[] args){
        Animal myAnimal = new Animal();
        String myType = myAnimal.animalType();
        System.out.println("This is a placeholder for Creature " + myType);
    }
}

class Animal{
    private String animalType = "dog";      //creating a string for animal type
    
    public String animalType(){             //creating the function animalType
        return animalType;                  //returning animalType
    }
    
}
