

package edu.ucalgary.ensf409;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.regex.*;


public class Translator{
    // Memeber Variables
    TranslationText translation;
    private final static String INPUTREGEX = "[a-z]{2}-[A-Z]{2}";
    private static Pattern INPUTPAT = Pattern.compile(INPUTREGEX);
    private String fileName;
    private File file;


    // Constructor
    Translator(String input)throws 
        IllegalArgumentException, 
        ArgFileNotFoundException{
            
        Matcher validID = INPUTPAT.matcher(input);
        if(!validID.find()){
            throw new IllegalArgumentException();
        }
        fileName = input;
        this.importTranslation();
    }



    // Getter
    public TranslationText getTranslation(){ return this.translation; }
    // Setter

    // Methods
    public String translate(int month , int day, int year)
        throws IllegalArgumentException{
        LocalDate current = LocalDate.now();
        String output;
        if(month > 12 || month < 0)
            throw new IllegalArgumentException();
        if(day <= 0 || day > 31)
            throw new IllegalArgumentException();
        if(
            year < current.getYear() || 
            (year == current.getYear() && month < current.getMonthValue()) ||
            (year == current.getYear() && month == current.getMonthValue() && day <= current.getDayOfMonth())
        ){
            output = String.format(
                translation.getSentence(),
                translation.getDay(day - 1),
                translation.getMonth(month - 1),
                year
            );
            byte[] bytes = output.getBytes(StandardCharsets.UTF_8);
            output = new String(bytes, StandardCharsets.UTF_8);
        }
        else{
            throw new IllegalArgumentException();
        }

        return output;
    }

    public void importTranslation()throws ArgFileNotFoundException{
        file = null;
        file = new File(fileName + ".ser");
        if(file.exists())
            this.deserialize();
        else
            this.importFromText();
    }

    public void importFromText()throws ArgFileNotFoundException{
        file = null;
        String[] months = new String[12];
        String[] days = new String[31];
        String sentence = new String();
        try{
            file = new File(fileName + ".txt");
            if(!file.exists())
                throw new ArgFileNotFoundException();
            BufferedReader br = new BufferedReader(new FileReader(file));
            for(int i = 0; i < 12; i ++)
                months[i] = br.readLine();
            for(int i = 0; i < 31; i ++)
                days[i] = br.readLine();
            sentence = br.readLine();
            translation = new TranslationText(months, days, sentence);
        }
        catch(IOException e){}
    }

    public void serialize(){
        ObjectOutputStream output = null;
        TranslationText record = null;

        try{
            output = new ObjectOutputStream(new FileOutputStream(fileName + ".ser", true));
            record = translation;
            output.writeObject(record);
        }
        catch(IOException e){
            e.printStackTrace();
            System.err.println("Error opening");
            System.exit(1);
        }
        finally {
			try {
				if (output != null) {
					output.close();
				}
			}
			catch(IOException e) {
				System.err.println("Error closing file.");
				System.exit(1);
			}
		}
    }


    public void deserialize(){
        ObjectInputStream input = null;
        TranslationText record = null;
        
        try{
            input = new ObjectInputStream(new FileInputStream(file));
        }
        catch(IOException e){
            System.err.println("Deserialize doesn't work");
            System.exit(1);
        }

        try{
            record = (TranslationText) input.readObject();
            translation = record;

        }
        catch(Exception e){
            System.out.println();
            e.printStackTrace();
        }
        finally{
            try{
                if(input != null)
                    input.close();
            }
            catch(IOException e){
                System.out.println("Cant close file");
                System.exit(1);
            }
        }
    }
    
}