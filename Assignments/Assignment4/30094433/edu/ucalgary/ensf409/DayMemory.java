package edu.ucalgary.ensf409;

import java.nio.charset.Charset;

public class DayMemory {
    public static void main(String[] args){
        // if(args.length < 1){
        //     throw new IllegalArgumentException();
        // }
        try{
            Translator translate = new Translator("el-GR");
            System.out.println(translate.translate(2, 1, 2001));
        }
        catch(Exception e){}
        
        
    }
}
