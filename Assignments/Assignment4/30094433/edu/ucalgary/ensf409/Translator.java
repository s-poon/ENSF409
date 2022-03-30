

package edu.ucalgary.ensf409;

import java.io.*;
import java.util.regex.*;


public class Translator{
    // Memeber Variables
    TranslationText translation;
    private final static String INPUTREGEX = "[a-z]{2}-[A-Z]{2}";
    private static Pattern INPUTPAT = Pattern.compile(INPUTREGEX);
    private String fileName;


    // Constructor
    Translator(String input)throws IllegalArgumentException{
        Matcher validID = INPUTPAT.matcher(input);
        if(!validID.find()){
            throw new IllegalArgumentException();
        }
        fileName = input + ".txt";
        this.importTranslation();
    }



    // Getter
    public TranslationText getTranslation(){ return this.translation; }
    // Setter

    // Methods
    public String translate(int month , int day, int year)
        throws IllegalArgumentException{
        if(month > 12 || month < 0)
            throw new IllegalArgumentException();
        if(day <= 0 || day > 31)
            throw new IllegalArgumentException();
 
        return new String();
    }

    public void importTranslation(){
        File file = null;
        try{
            file = new File("en-US.txt");
            this.deserialize();
        }catch(Exception e){
            System.out.println(fileName);
            this.importFromText();
        }
    }

    public void importFromText()/*throws IOException*/{
        System.out.print("sad");
    }

    public void serialize(){
        ObjectOutputStream output = null;
        TranslationText record = null;

        try{
            output = new ObjectOutputStream(new FileOutputStream(fileName));

        }catch(IOException e){
            System.err.println("Error Opening File");
            System.exit(1);
        }

        try{
            String[] months = new String[12];
            String[] days = new String[31];
            String sentence = new String();
            record = new TranslationText(months, days, sentence);
            output.writeObject(record);
        }catch(Exception e){
            System.err.println("Sadge");
            e.printStackTrace();
        }
        finally{
            try{
                if(output != null)
                    output.close();
            }catch(IOException e){
                System.err.println("Error Closing File");
                System.exit(1);
            }
        }
    }

    public void deserialize(){
        ObjectInputStream input = null;
        TranslationText record = null;

        try{
            input = new ObjectInputStream(new FileInputStream(fileName));
        }catch(IOException e){
            System.err.println("Error Opening File");
            System.exit(1);
        }

        try{
            record = (TranslationText) input.readObject(); 
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(input != null)
                    input.close();
            }catch(IOException e){
                System.err.println("Error Closing File");
                System.exit(1);
            }
        }
    }
}