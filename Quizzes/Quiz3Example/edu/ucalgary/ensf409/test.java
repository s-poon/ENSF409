package edu.ucalgary.ensf409;

import java.io.File;

public class test {
    public static void main(String args[]){
        File file = new File("th.txt");

        BibReader br = new BibReader(file);
        br.parseContents();
        System.out.println(br.getContents());
        
    }
}
