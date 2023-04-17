// package LabExer5A;

/**
 *
 * @author 		dux
 * @website		https://github.com/Jiei-Dux
 * 
 */

/*===== LIBRARY IMPORTS =====*/
import java.util.*;

public class LabExer5A {

    /*~~~~ MAIN CODE ~~~~*/
    public static void main ( String[] args ) {

    	/*~~~~ Classes ~~~~*/
		Random IAmRandom = new Random ();
    	Scanner usrInput = new Scanner ( System.in );

    	/*~~~~ Random Number Generator ~~~~*/
		int Num = IAmRandom.nextInt ( (50 - 1) + 1 ) + 1;

		/*~~~~ Universal Variables ~~~~*/
    	int x, usrGuess;
		String ErrorMsg = " Why would you do that?? ";


		try {


    		/*~~~~ INSTRUCTIONS ~~~~*/
		
    	    	/*--- UPI Variables ---*/
    	    	String Instructions = 
    	        	"""
					The system has chosen a number between 1 - 50.
					 
					Now start guessing! \n
    	        	""";

        		/*--- User / Player Instructions ---*/
				System.out.print( "\033[H\033[2J" );
				System.out.flush();

        		for ( x = 0; x < Instructions.length(); x++ ) {

        	    	System.out.printf ("%c", Instructions.charAt(x));

            		try { Thread.sleep(20); } 
					catch ( InterruptedException Error ) { System.out.println ( ErrorMsg ); }

        		}




    		/*~~~~ GAME ~~~~*/
    		while ( true ) {

    	    	System.out.print ( "Guess: " );

    	    	// Get usrInput
    	    	usrGuess = usrInput.nextInt();

    	    	//-- Check usrGuess --//

    	        	// usrGuess Variables
    	        	String CorrectGuess = 
    	        	    """
						 
    	        	    Wow! You guessed the number!
						 
    	        	    Congratulations!
						 
    	        	    """;

        	    	String WrongGuessLess =
        	    	    " \nNope... The number is LESS than " +
        	    	    usrGuess + "\n" +
        	    	    "Guess Again... \n";
        	    	String WrongGuessGreater = 
        	    	    " \nNope... The number is GREATER than " +
        	    	    usrGuess + "\n" +
        	    	    "Guess Again... \n";




            		// usrGuess Checker
            		if ( Num < usrGuess ) {

						try {

							System.out.print( "\033[H\033[2J" );
							System.out.flush();

							System.out.println ( WrongGuessLess );

							Thread.sleep(800);

						} catch ( InterruptedException Break ) {

							System.out.println ( ErrorMsg );

						}
 
            		} else if ( Num > usrGuess ) {

						try {

							System.out.print( "\033[H\033[2J" );
							System.out.flush();

							System.out.println ( WrongGuessGreater );

							Thread.sleep(800);

						} catch ( InterruptedException Break ) {

							System.out.println ( ErrorMsg );

						}

            		} else if ( Num == usrGuess ) {

						try {

							System.out.print( "\033[H\033[2J" );
							System.out.flush();

							System.out.println ( CorrectGuess );

							Thread.sleep(800);

							System.exit(0);

						} catch ( InterruptedException Break ) {

							System.out.println ( ErrorMsg );

						}

            		}

    		}

		} finally { 
			usrInput.close();
		}

    }

}