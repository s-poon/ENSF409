

package edu.ucalgary.ensf409;


interface InterfacePrintOutput{


    public static void printFightLog(ArrayList<String> log) {
        Iterator<String> i = log.iterator();
        while(i.hasNext()) {
            System.out.println(i.next());
        }
    }

    public static void printStats(GameCharacter theCharacter) {
        String characterName = theCharacter.characterName;
        String characterClass = theCharacter.getCharacterClass();
        System.out.println("Name: " + characterName);
        System.out.println("Life: " + theCharacter.lifeforce);
        System.out.println("Class: " + characterClass);
        System.out.println("Says: " + theCharacter.talk("I am " + characterName + " the " + characterClass + "."));
        System.out.println("Attack speed: " + theCharacter.getAttackPriority());
        System.out.println("Damage: " + theCharacter.getAttackDamage());
        System.out.println("Attack: " + theCharacter.getAttackMessage());
    }

}