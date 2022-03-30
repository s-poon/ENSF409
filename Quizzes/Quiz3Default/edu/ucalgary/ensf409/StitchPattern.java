package edu.ucalgary.ensf409;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class StitchPattern {
    // Member Variables
    File file;
    String contents;
    // String pattern;
    ArrayList<ArrayList<Character>> pattern;
    // Constructor
    StitchPattern(File file){
        this.file = file;
    }

    // Setters
    public void setPattern(String givenData) {
        pattern = new ArrayList<ArrayList<Character>>();
        int j = 0;
        for(int i = 0; i < givenData.length(); i ++){
            if(givenData.charAt(i) == '\n'){
                j ++;
            }
            pattern.add(new ArrayList<Character>());
            pattern.get(j).add(givenData.charAt(i));
        }
        this.contents = givenData;
    }
    // Getters
    public ArrayList<ArrayList<Character>> getPattern() {
        return pattern;
    }

    // Methods
    public boolean readFile(){
        if(file.exists()){
            BufferedReader bf = null;
            try{
                bf = new BufferedReader(new FileReader(file));
                StringBuilder sb = new StringBuilder();
                int i = 0;
                while(bf.readLine() != null){
                    for(int j = 0; j < bf.readLine().length(); j ++){
                        pattern.get(i).add(bf.readLine().charAt(j));
                    }
                    pattern.get(i).add('\n');
                    i ++;
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

    public void mirrorHorizontal() {
        // int j = 0;
        for(int i = 0; i < pattern.size(); i ++){
            for(int j = 0; j < pattern.get(i).size(); j ++){
                pattern.get(i).add(0, pattern.get(i).get(j));
            }
        }
    }

    public void mirrorVertical() {
    }

    public void mirrorBoth() {
    }

    public void parseData() {
    }

    

    
}
