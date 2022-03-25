

package edu.ucalgary.ensf409;

import java.io.*;

public class Translator{
    // Memeber Variables
    TranslationText translation;


    // Constructor
    Translator(String input)throws IllegalArgumentException{
        
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

    }

    public void importFromText(String input)throws IOException{

    }

    public void serialize(){
        ObjectOutputStream output = null;
        TranslationText record = null;

        try{
            output = new ObjectOutputStream(new FileOutputStream("file"));

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
            input = new ObjectInputStream(new FileInputStream("file"));
        }catch(IOException e){
            System.err.println("Error Opening File");
            System.exit(1);
        }

        try{
            record = (TranslationText) input.readObject();
            
        }catch(Exception e){
            System.err.println("Oof");
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