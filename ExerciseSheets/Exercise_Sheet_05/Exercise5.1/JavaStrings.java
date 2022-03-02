/* Exercise Sheet 5.1
 * @Author: Steven Poon
 * UCID: 30094433
 * Date Created: 23/01/2021
 * 
 * @Version: 1.0
 * @Since 1.0
 */
 
 
 public class JavaStrings{
     
     public static void main(String[] args){
         char[] fact4 = {'F', 'i', 's', 'h', ' ', 's', 'w', 'i', 'm'};
         
         String animalFact1 = "Horses are mammals.";
         String animalFact2 = new String("Elephants are mammals.");
         String animalFact3 = new String(animalFact1);
         String animalFact4 = new String(fact4);
         String animalFact5 = new String("Cows Moo");
         
         int totalLength = 0;
         totalLength += animalFact1.length();
         totalLength += animalFact2.length();
         totalLength += animalFact3.length();
         totalLength += animalFact4.length();
         totalLength += animalFact5.length();
         
         System.out.println(totalLength);
     }
 }
         
