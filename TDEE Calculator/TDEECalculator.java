//package tdee.calculator;

import java.io.*;
import java.util.*;

public class TDEECalculator {

    public static void main(String[] args) {
        
        Scanner usrInput = new Scanner ( System.in );
        
        int x, age;
        char gender;
        double weight, height, BMR_F, BMR_M;
        
        /*
         *
         *  BMR_M = Basal Metabolic Rate for Male
         *  BMR_F = Basal Metabolic Rate for Female
         *
         */
        
        String Sentence1 =  " This is a Simple TDEE Calculator \n" +
                            " This will measure how many calories you should take \n\n" +
                            " Press ENTER to Continue... ";
        
        for ( x = 0; x < Sentence1.length(); x++ ) {
            System.out.printf ( "%c", Sentence1.charAt(x));
            
            try {
                Thread.sleep(10);
            } catch ( InterruptedException e ){}
        }
        
        try { 
            System.in.read();
        } catch ( IOException e ){}

        /* Clear console/terminal */
        System.out.print( "\033[H\033[2J" );
        System.out.flush();
        
        
/* ==================== ==================== ==================== ==================== */
        
        
        String Sentence2 =  " What is your gender? " +
                            " [ M / F ]: ";
        
        for ( x = 0; x < Sentence2.length(); x++ ) {
            System.out.printf ( "%c", Sentence2.charAt(x));
            
            try {
                Thread.sleep(10);
            } catch ( InterruptedException e ){}
        }
        
        gender = usrInput.next().charAt(0);
        
        
/* ==================== ==================== ==================== ==================== */
        
        
        String Sentence3 = " Enter your weight in kg: ";
        
        for ( x = 0; x < Sentence3.length(); x++ ) {
            System.out.printf ( "%c", Sentence3.charAt(x));
            
            try {
                Thread.sleep(10);
            } catch ( InterruptedException e ){}
        }
        
        weight = usrInput.nextDouble();
        
        
/* ==================== ==================== ==================== ==================== */
        
        
        String Sentence4 = " Enter your height in cm: ";

        for ( x = 0; x < Sentence4.length(); x++ ) {
            System.out.printf ( "%c", Sentence4.charAt(x));
            
            try {
                Thread.sleep(10);
            } catch ( InterruptedException e ){}
        }
        
        height = usrInput.nextDouble();
        
        
/* ==================== ==================== ==================== ==================== */
        
        
        String Sentence5 = " Enter your age in years: ";
        
        for ( x = 0; x < Sentence5.length(); x++ ) {
            System.out.printf ( "%c", Sentence5.charAt(x));
            
            try {
                Thread.sleep(10);
            } catch ( InterruptedException e ){}
        }
        
        age = usrInput.nextInt();
        
        
/* ==================== ==================== ==================== ==================== */
        

        /* Clear console/terminal */
        System.out.print( "\033[H\033[2J" );
        System.out.flush();
        
        /* SUMMARY */
        String ENTER = " \n\n Press ENTER to Continue... ";
        
        System.out.print ( 
                            " Gender \tWeight \t\tHeight \t\tAge \n " +
                            gender + "\t\t" + weight + "\t\t" + height + "\t\t" + age
                         );
        
        for ( x = 0; x < ENTER.length(); x++ ) {
            System.out.printf ( "%c", ENTER.charAt(x));
            
            try {
                Thread.sleep(10);
            } catch ( InterruptedException e ){}
        }
        
        try { 
            System.in.read();
        } catch ( IOException e ){}

        BMR_M = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        BMR_F = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        
        
/* ==================== ==================== ==================== ==================== */

        
        String BMR = " Your Basal Metabolic Rate is ";

        switch (gender) {
            case 'M' :{
                System.out.printf   ( BMR + "%.2f" + "\n", BMR_M );
				usrInput.close();
                System.exit(0);
			}
                
            case 'm':{ 
                System.out.printf   ( BMR + "%.2f" + "\n", BMR_M );
				usrInput.close();
                System.exit(0);
			}
                
            case 'F':{
                System.out.printf   ( BMR + "%.2f" + "\n", BMR_F );
				usrInput.close();
                System.exit(0);
			}
                
            case 'f':{
                System.out.printf   ( BMR + "%.2f" + "\n", BMR_F );
				usrInput.close();
                System.exit(0);
			}
                
            default :{
                System.out.println  ( " F**king... Nevermind... Exiting... ");
				usrInput.close();
                System.exit(1);
			}
        }

    }

}
