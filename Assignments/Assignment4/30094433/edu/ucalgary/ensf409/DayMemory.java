package edu.ucalgary.ensf409;


public class DayMemory {
    public static void main(String[] args)throws 
            CommandArgumentNotProvidedException,
            ArgFileNotFoundException{
        if(args.length < 1){
            throw new CommandArgumentNotProvidedException();
        }
        Translator translate = new Translator(args[0]);
        System.out.println(translate.translate(4, 9, -2022));
        

    }
}
