/* Exercise Sheet 4.1/Lab Assesment B
 * @Author: Steven Poon
 * UCID: 30094433
 * Date Created: 19/01/2021
 * 
 * @Version: 1.3
 * @Since 1.0
 */
 
 // Importing Classes
import java.util.Arrays;

/* SimpleArrays is a class that creates an array of strings that can 
 * then be manipulated using the two methoods in the class
 */
public class SimpleArrays{
    private String[] stringArray = new String[4];                       // Creating the instance variable stringArray that has a length of 4
    
    SimpleArrays(String inputString){                                   // Constructor that has one argument inputString
        Arrays.fill(stringArray, inputString);                          // Fills all indices of stringArray with inputString
    }
    
    SimpleArrays(){                                                     // Constructor with no arguments
        Arrays.fill(stringArray, "Hello, world");                       // Fills all indices with "Hello, World"
    }
    
    /* arrayConcat has an optional parameter index.  If no value is
     * provided them index = 0.  arrayConcat takes the index value and 
     * copies the contents of stringArray[index] to string Array[3] to 
     * a new string with each index separated by a '#'
     */
    public String arrayConcat(int index){
        String concatString = new String();                             // Creating a new empty string: concatString
        if(index >= 0 && index < 4){                                    // Checking if index is within the range of the array
            for(int i = index; i < 4; i ++){                            // Incrementing through stringArray starting at index
                if(i < 3){                                              // if statement to make sure a '#' does not appear at the end
                    concatString += stringArray[i];                     // Adding the element of stringArray[i] to concatString
                    concatString += '#';                                // Adding '#' between each element
                } else{
                    concatString += stringArray[i];                     // Adding the final element of stringArray
                }
            }
        }
        else{
            throw new IndexOutOfBoundsException();                      // Throwing an exception if index is outside of valid range
        }
        return concatString;                                            // Returning concatString
    }
    
    public String arrayConcat(){                                        // Overwriting if no argument is provided
        return arrayConcat(0);
    }
    
    /* arrayCrop has two parameters start and end.
     * arrayCrop copies the contents of stringArray[start] to 
     * stringArray[end], separated by '#' to a new string.
     */    
    public String arrayCrop(int start, int end){
        String newString = new String();                                // Creating a new empty string: newString
        if((start >= 0 && start < 4) && (end >= 0 && end < 4)){         // Ensure that start and end are valid numbers
            if(start > end){                                            // Checking if start > end and if not will switch start and end
                int temp1 = start;                                      // Assigning start to a temporary variable: temp1
                start = end;                                            // Assigning end to start
                end = temp1;                                            // Assigning temp1 to end
            } else if(start == end){                                    // If start == end return match
                return "Match";
            }
            for(int i = start; i < end; i ++){                          // Incrementing through stringArray starting at stringArray[start]
                if(i < (end - 1)){                                      // if statement to make sure a '#' does not appear at the end
                    newString += stringArray[i];                        // Adding the element of stringArray[i] to newString
                    newString += '#';                                   // Adding '#' between each element
                } else{
                    newString += stringArray[i];                        // Adding stringArray[end] to newString
                }
            }
            return newString;                                           // Returning newString
        }else {
            return "Fail";                                              // If either index is not valid then "Fail" is returned 
        }
    }
}
