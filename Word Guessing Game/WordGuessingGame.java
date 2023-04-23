// package LabExer6A;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class WordGuessingGame {

	public WordGuessingGame() {

		File File = new File("Custom-Words.txt");
		Path FilePath = Paths.get(File.toString());

		String Array1[] = new String[100];
		String Array2[];

		Random rnd = new Random();
		Scanner usrInput = new Scanner(System.in);

		String ErrorMsg = "Something went wrong... exiting...";
		String HiddenWord, DisplayedWord;
		int x, Count = 0;

		try {

			try {

				InputStream input = Files.newInputStream(FilePath);
				BufferedReader FileReader = new BufferedReader(new InputStreamReader(input));

				String word = null;

				while ( ( word = FileReader.readLine() ) != null ) {

					Array1[Count] = word.toUpperCase();
					++Count;
				}

				Array2 = new String[Count];
				Array2 = Array1;

				HiddenWord = Array2[rnd.nextInt(Count)];
				DisplayedWord = HiddenWord;

				String Congratulatory = 
					"Congrats! " +
					HiddenWord +
					" was the word!";
				String Unfortunate = 
					"""
					\n\n
					No Rewards though unfotunately...


					So just exit and move on...





					Press ENTER to Exit...""";

				for ( x = 0; x < HiddenWord.length()-2; x++ ) {

					DisplayedWord = DisplayedWord.replace(DisplayedWord.charAt(rnd.nextInt(DisplayedWord.length())), '?');

				}

				boolean WordGuessed = false;

				/*~~~~ INSTRUCTION ~~~~*/
				try {

					System.out.print( "\033[H\033[2J" );
					System.out.flush();

					String Instructions =
						"""
						INSTRUCTIONS:

							You will be given a word for you to guess.
							You can either ENTER a letter or a word.

							Once you know what the word is, ENTER the word.

					
						NOTE:
							The Program will not end even if the word is already
							revealed if you only enter letters.

							To end or exit the program, you will need to ENTER
							the whole word itself, sorry for the inconviniences...






						Press ENTER to continue...""" 
						;

					for ( x = 0; x < Instructions.length(); x++ ) {

						System.out.printf ("%c", Instructions.charAt(x));

            			try { Thread.sleep(8); } 
						catch ( InterruptedException Error ) { System.out.println ( ErrorMsg ); }

					}

					try {

						System.in.read();

						System.out.print( "\033[H\033[2J" );
						System.out.flush();

					} catch ( Exception Error ) {

						System.out.println ( ErrorMsg );
						System.exit(1);

					}

				} catch ( Exception Error ) { 

					System.out.println ( ErrorMsg );
					System.exit(1);

				}

			

				do {

					System.out.println("\n\n " + DisplayedWord + " \n\n");
					System.out.print ("Guess: ");

					String usrGuess = usrInput.nextLine().toUpperCase();

					if ( usrGuess.length() > 1 ) {

						if ( usrGuess.equalsIgnoreCase(HiddenWord) ) {

							try {

								System.out.print( "\033[H\033[2J" );
								System.out.flush();
							
								// System.out.println ( Congratulatory );
								// System.out.println ( Unfortunate );

								for ( x = 0; x < Congratulatory.length(); x++ ) {

									System.out.printf ("%c", Congratulatory.charAt(x));

            						try { Thread.sleep(10); } 
									catch ( InterruptedException Error ) { System.out.println ( ErrorMsg ); }

								}

								for ( x = 0; x < Unfortunate.length(); x++ ) {

									System.out.printf ("%c", Unfortunate.charAt(x));

            						try { Thread.sleep(10); } 
									catch ( InterruptedException Error ) { System.out.println ( ErrorMsg ); }

								}

								System.in.read();

								System.out.print( "\033[H\033[2J" );
								System.out.flush();
								System.exit(0);

							} catch ( Exception Error ) {

								System.out.println ( ErrorMsg );
								System.exit(1);

							}

						} else {

							try {

								System.out.println ("Nope~ \nGuess Again~ ");

								Thread.sleep (800);
								System.out.print( "\033[H\033[2J" );
								System.out.flush();

							} catch ( InterruptedException Interrupt ) { 

								System.out.println ( ErrorMsg );
								System.exit(1);

							}

						}

					} else {

						WordGuessed = false;

						for ( x = 0; x < HiddenWord.length(); x++ ) {

							if ( usrGuess.equalsIgnoreCase(String.valueOf(HiddenWord.charAt(x)))) {

								DisplayedWord = DisplayedWord.substring(0,x) + 
								usrGuess + 
								DisplayedWord.substring(x+1);
								WordGuessed = true;

							}

						}

					}

					if ( WordGuessed == true ) {


						try {

							System.out.println (usrGuess + " added! ");

							Thread.sleep (800);
							System.out.print( "\033[H\033[2J" );
							System.out.flush();

						} catch ( InterruptedException Interruption ) {

							System.out.println ( ErrorMsg );
							System.exit(1);

						}

					} else {

						try {

							System.out.println (usrGuess + " not found...");

							Thread.sleep (800);
							System.out.print( "\033[H\033[2J" );
							System.out.flush();

						} catch ( InterruptedException Interruption ) {

							System.out.println ( ErrorMsg );
							System.exit(1);

						}

					}

				} while ( true );

			} catch ( IOException ex ) {

				System.out.println ( ErrorMsg );
				System.exit(1);

			}
		} finally {
			usrInput.close();
		}

	}

	public static void main(String[] arg) {

		new WordGuessingGame();

	}

}