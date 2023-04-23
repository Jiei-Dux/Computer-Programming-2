import java.util.*;

public class QuizBee {

	/* ==== CLEAR CONSOLE TERMINAL ==== */
	private void clearConsoleTerminal() {

		System.out.print("\033[H\033[2J");
		System.out.flush();

	}




	/* ==== EXCEPTION ERRORS ==== */

	/* ~~~~ INTERRUPT ERROR ~~~~ */
	private void errorMsgInterrupt() {

		System.out.println(" Why would you do that?? ");
		System.exit(1);

	}

	/* ~~~~ ERRORS ~~~~ */
	private void errorMsgErrors() {

		System.out.println(" Uh... what? ");
		System.exit(1);

	}




	/* ==== ENTER TO CONTINUE ==== */

	private void pressEnterToContinue() {

		String pressENTER = " Press ENTER to Continue... ";

		for (int x = 0; x < pressENTER.length(); x++) {

			System.out.printf("%c", pressENTER.charAt(x));

			try {

				Thread.sleep(20);

			} catch (InterruptedException INTERRUPT) {

				errorMsgInterrupt();

			}

		}

		try {

			System.in.read();

		} catch (Exception ERRORS) {

			errorMsgInterrupt();

		}

	}




	/* ==== GAME FUNCTIONS ==== */

	public QuizBee() {

		/* ~~~~~ CLASSES ~~~~~ */
		Scanner usrInput = new Scanner(System.in);

		/* ~~~~ COMPONENTS ~~~~ */

		/* ++ QUESTIONS ++ */
		String Questions[] = {
				" What is Japan's currency? ",
				" What command is used to copy a file? ",
				" What is the command to delete a file? ",
				" What command creates an empty directory? ",
				" What command is used to change directories? ",
				" Which command(s) shows users that are logged in? ",
				" What command is used to change ownership of a file? ",
				" Which command clears the contents of your terminal display? ",
				" What filesystem does most Linux distributions uses by default? ",
				" What command shows you how long it has been since the system was rebooted? "
		};

		/* ++ CHOICES ++ */
		String Choices[][] = {
				{ " Yen ", 			" Yin ", 		" Ben " }, 			// 1 A B C
				{ " copy ", 		" cp ", 		" cd " }, 			// 2
				{ " cd ", 			" rm ", 		" delete " }, 		// 3
				{ " mkdir ", 		" makedir ", 	" addfolder " }, 	// 4
				{ " cp ", 			" cd ",		 	" cr " }, 			// 5
				{ " what ", 		" which ", 		" who " }, 			// 6
				{ " changeOwner ", 	" change ", 	" chown " }, 		// 7
				{ " delete ", 		" remove ", 	" clear " }, 		// 8
				{ " NTFS ", 		" EXT4 ", 		" BTRFS " }, 		// 9
				{ " uptime ", 		" downtime ", 	" primetime " } 	// 10
		};

		/* ++ ANSWERS ++ */
		String Answer[] = {
				"A",
				"B",
				"B",
				"A",
				"B",
				"C",
				"C",
				"C",
				"B",
				"A",
		};

		/* ~~~~ X VARIABLES ~~~~ */
		String Welcome = " Welcome to my TiaMP - QuizBee Edition!";
		String Instructions = """

				 You will now be given 9 questions about Linux.

				 Answer them to the best of your abilities~

				 Good Luuuuuck~~

				""";
		int x,
				QuestNum = 1,
				QuestCount = 0,
				ScoreCount = 0;

		try {

			/* ++ WELCOME MESSAGE ++ */
			clearConsoleTerminal();

			for (x = 0; x < Welcome.length(); x++) {

				System.out.printf("%c", Welcome.charAt(x));
				try {

					Thread.sleep(20);

				} catch (InterruptedException INTERRUPT) {

					errorMsgInterrupt();

				}

			}

			System.out.println("\n\n");
			pressEnterToContinue();

			/* ++ INSTRUCTIONS ++ */
			clearConsoleTerminal();

			for (x = 0; x < Instructions.length(); x++) {

				System.out.printf("%c", Instructions.charAt(x));
				try {

					Thread.sleep(20);

				} catch (InterruptedException INTERRUPT) {

					errorMsgInterrupt();

				}

			}

			System.out.println("\n\n");
			pressEnterToContinue();

			do {

				try {

					/* ~~~~ Y VARIABLES ~~~~ */
					String Guide = " Question #" + QuestNum + ": \n\n";
					String DisplayPrompt = " Enter your answer: ";

					/* ++ GUIDE ++ */
					clearConsoleTerminal();

					for (x = 0; x < Guide.length(); x++) {

						System.out.printf("%c", Guide.charAt(x));
						try {

							Thread.sleep(20);

						} catch (InterruptedException INTERRUPT) {

							errorMsgInterrupt();

						}

					}

					/* -- QUESTION DISPLAYING -- */
					for (x = 0; x < Questions[QuestNum].length(); x++) {

						System.out.printf("%c", Questions[QuestNum].charAt(x));
						try {

							Thread.sleep(20);

						} catch (InterruptedException INTERRUPT) {

							errorMsgInterrupt();

						}

					}

					/* -- CHOICE A -- */
					System.out.print("\n\n A. ");

					for (x = 0; x < Choices[QuestNum][0].length(); x++) {

						System.out.printf("%c", Choices[QuestNum][0].charAt(x));
						try {

							Thread.sleep(20);

						} catch (InterruptedException INTERRUPT) {

							errorMsgInterrupt();

						}

					}

					/* -- CHOICE B -- */
					System.out.print("\n\n B. ");

					for (x = 0; x < Choices[QuestNum][1].length(); x++) {

						System.out.printf("%c", Choices[QuestNum][1].charAt(x));
						try {

							Thread.sleep(20);

						} catch (InterruptedException INTERRUPT) {

							errorMsgInterrupt();

						}

					}

					/* -- CHOICE C -- */
					System.out.print("\n\n C. ");

					for (x = 0; x < Choices[QuestNum][2].length(); x++) {

						System.out.printf("%c", Choices[QuestNum][2].charAt(x));
						try {

							Thread.sleep(20);

						} catch (InterruptedException INTERRUPT) {

							errorMsgInterrupt();

						}

					}

					/* -- GET ANSWER -- */
					System.out.println("\n\n");
					
					for (x = 0; x < DisplayPrompt.length(); x++) {

						System.out.printf("%c", DisplayPrompt.charAt(x));
						try {

							Thread.sleep(20);

						} catch (InterruptedException INTERRUPT) {

							errorMsgInterrupt();

						}

					}

					String usrChoice = usrInput.nextLine();

					/* -- CHECK ANSWER -- */
					try {

						if (usrChoice.equalsIgnoreCase("A") || usrChoice.equalsIgnoreCase("B")
								|| usrChoice.equalsIgnoreCase("C")) {

							if (usrChoice.equalsIgnoreCase(Answer[QuestCount])) {

								++ScoreCount;

							}

						} else if (usrChoice.isBlank()) {

							throw new Exception(" Input something moron! ");

						}

					} catch (Exception ERRORS) {

						errorMsgErrors();

					}

				} catch (Exception ERRORS) {

					errorMsgErrors();

				}

				QuestNum++;
				QuestCount++;

			} while (QuestCount < 10);

		} finally {

			usrInput.close();

		}

		System.out.println(" Your score is " + ScoreCount + " out of 10 ");

	}

	public static void main(String[] args) {

		new QuizBee();

	}

}
