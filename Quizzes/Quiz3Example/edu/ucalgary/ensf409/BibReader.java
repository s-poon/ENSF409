package edu.ucalgary.ensf409;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.regex.*;

public class BibReader {
    // Member Variables
    private File file;
    private String contents;
    private HashMap<String, String> attributes;
    private final static String REGEX = "([a-zA-Z]*[ ]{0,1})0=[ ]{0,1}{(.*?)}";
    private final static Pattern PATTERN = Pattern.compile(REGEX);
    // Constructor0
    BibReader(File input){
        this.file = input;
    }
    // Setters
    public void setContents(String contents){ this.contents = contents; }

    // Getters
    public String getContents(){ return this.contents; }
    public String getAttribute(String attribute){ return this.attributes.get(attribute); }
    public HashMap<String, String> getAttributes(){ return this.attributes; }
    // Methods
    public boolean readFile(){
        if(file.exists()){
            BufferedReader bf = null;
            try{
                bf = new BufferedReader(new FileReader(file));
                StringBuilder sb = new StringBuilder();
                while(bf.readLine() != null){
                    sb.append(bf.readLine());
                }
                contents = sb.toString();
            }
            catch(Exception e){
                e.printStackTrace();
            }
            finally{
                if(bf != null){
                    try{
                        bf.close();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }

            return true;
        }
        else{
            return false;
        }
    }

    public boolean parseContents(){
        Matcher match = PATTERN.matcher(contents);
        String att;
        String data;

        while(match.find()){
            att = match.group(0);
            data = match.group(1);
            if(!attributes.containsKey(att))
                attributes.put(att, data);
            
        }
                

        return true;
    }

}
