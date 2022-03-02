/*
 * @Author: Steven Poon
 * Date Created: 11/01/2021
 * 
 * @Version: 1.2
 * @Since 1.0
 */


/* Hello is a simple program for lecture 1
 */
 
public class Hello{
    //prints out "Hello and the contents of the variable
    public static void main(String[] args){
        boolean foo = true;                             //foo is a test variable
        int testint = 5;                                //testint is a test variable
        float testfloat = 3.1415f;                      //testfloat is a test variable
        double testdouble = (double)testfloat;          //typecasting testfloat to a double
        short testshort = 51;                           //testshort is a test variable
        byte testbyte = 28;                             //testbyte is a test variable
        char testchar = 'H';                            //testfloat is a test variable
        long testlong = testint;                        //testlong is a test variable
        System.out.println("Boolean Value: " + foo);    //printing out all of the vars
        System.out.println("Char Value: " + testchar);
        System.out.println("Byte Value: " + testbyte);
        System.out.println("Short Value: " + testshort);
        System.out.println("Integer Value: " + testint);
        System.out.println("Long Value: " + testlong);
        System.out.println("Float Value: " + testfloat);
        System.out.println("Double Value: " + testdouble);
        
        
    }
}   //End of class declaration
