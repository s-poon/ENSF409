package edu.ucalgary.ensf409;

public class DayMemory {
    public static void main(String[] args){
        // if(args.length < 1){
        //     throw new IllegalArgumentException();
        // }
        try{
            Translator translate = new Translator("es-BO");
            System.out.println(translate.translate(2, 1, 2001));
        }
        catch(Exception e){}
        
        
    }
}
