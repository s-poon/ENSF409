
package edu.ucalgary.ensf409;

public class CharacterRogue extends GameCharacter{
    /*Member variables*/
    private String weapon = "knife";

    /*Constructors*/
    CharacterRogue(String characterName, int attackPriority) {
        super(characterName, "rogue", attackPriority, 10);
    }

    /*Getters*/
    public String getWeapon(){ return this.weapon; }
    @Override
    public String getAttackMessage(){
        return this.getCharacterName() + " attacks with their " +  this.weapon + ".";
    }

    /*Methods*/
    @Override
    public String talk(String message){
        return "....(" + message + ")....";
    }
}