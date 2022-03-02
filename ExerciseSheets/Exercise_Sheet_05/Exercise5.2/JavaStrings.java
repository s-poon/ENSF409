/* Exercise Sheet 5.1
 * @Author: Steven Poon
 * UCID: 30094433
 * Date Created: 23/01/2021
 * 
 * @Version: 1.5
 * @Since 1.0
 */
 
//Importing any additional classes
import java.util.regex.*;

/* JavaStrings is a class that will manipulate strings using its 3
 * classes and will return the REGEX using a single getter methood
 */
public class JavaStrings{
    
    /**********************Member Variables****************************/
    private static Pattern SECRET_CODE_REGEX = Pattern.compile(         // Creating the Pattern SECRET_CODE_REGEX
                                "^\\D{3}");
    
    /************************Methods***********************************/
    /* addTogether has two parameters.  addTogether removes leading and 
     * trailing whitespace from each argument and adds the new lengths 
     * together and returns that value
     */
    public int addTogether(String string1, String string2){
        String string1Trimmed = string1.trim();                         // Removing leading and trailing whitespace
        String string2Trimmed = string2.trim();                         // Removing leading and trailing whitespace
        return string1Trimmed.length() + string2Trimmed.length();       // Returning the length of both strings
    }
    
    /* idProcessing has 4 parameters.  idProcessing takes the
     * intials of the owner and pet and adds them to a string along with
     * the year of birth of the pet.
     */
    public String idProcessing(String firstName, String lastName, 
                                String petName, int birthYear){
        char[] initials = {firstName.charAt(0), lastName.charAt(0),     // Creating a char array of the initials of the owner and pet
                            petName.charAt(0)}; 
        String newID = String.valueOf(initials) +                       // Adding the initials to the birthyear
                            String.valueOf(birthYear);
        return newID;                                                   // Returning the new string
    }
    
    /* secretCode has one parameter. It takes the argument and replaces
     * all of the vowels with 'z' and then returns the first 3 letters
     */
    public String secretCode(String ingredient){
        String firstStep = ingredient.replaceAll("[AEIOUaeiou]", "z");  // Replacing all of the vowels with 'z'
        Matcher secondStep = SECRET_CODE_REGEX.matcher(firstStep);      // Creating a matcher object using the Pattern SECRET_CODE_REGEX
        secondStep.find();                                              // Finding the subsequences from the Matcher
        String finalStep = secondStep.group(0);                         // Assigning the first 3 letters to the finalStep variable
        return finalStep;                                               // Returning the coded ingredient
    }
    
    /**********************Getter Methods******************************/
    /* getSecretCodeRegex returns SECRET_CODE_REGEX */
    public static String getSecretCodeRegex(){
        return SECRET_CODE_REGEX.pattern();
    }
}

/* main() that was used to test
 * 
 * public static void main(String args[]) {
        JavaStrings myObject = new JavaStrings();

        // Print out examples from addTogether.
        String oneExample = "12 4 6789";
        String twoExample = "abcdef gh";
        int theLength = myObject.addTogether(oneExample,twoExample);
        System.out.println(theLength);

        // Length is unchanged by adding whitespace to front and back
        oneExample = "   " + oneExample + "\n";
        twoExample = "\t" + twoExample;
        theLength = myObject.addTogether(oneExample,twoExample);
        System.out.println(theLength);

        // Print out example of idProcessing
        String personFirst = "Dorothy";
        String personLast = "Gale";
        String petName = "Toto";
        int petBirth = 1899;
        String theID = myObject.idProcessing(personFirst,personLast,
                       petName,petBirth);
        System.out.println(theID);

        // Print out examples from secretCode
        String ingredientOne = "tomato";
        String ingredientTwo = "WATER";
        String theCode = myObject.secretCode(ingredientOne);
        System.out.println(theCode);
        theCode = myObject.secretCode(ingredientTwo);
        System.out.println(theCode);
        System.out.println(myObject.getSecretCodeRegex());
    }
    */
                
        
