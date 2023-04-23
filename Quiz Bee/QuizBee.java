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

		System.out.println("Why would you do that?? ");
		System.exit(1);

	}

	/* ==== ENTER TO CONTINUE ==== */

	private void pressEnterToContinue() {

		String pressENTER = "Press ENTER to Continue... ";

		for (int x = 0; x < pressENTER.length(); x++) {

			System.out.printf("%c", pressENTER.charAt(x));
			try {
				Thread.sleep(15);
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
				"What is Japan's currency?",
				"What command is used to copy a file?",
				"What is the command to delete a file?",
				"What command creates an empty directory?",
				"What command is used to change directories?",
				"Which command(s) shows users that are logged in?",
				"What command is used to change ownership of a file?",
				"Which command clears the contents of your terminal display?",
				"What filesystem does most Linux distributions uses by default?",
				"What command shows you how long it has been since the system was rebooted?"
		};

		/* ++ CHOICES ++ */
		String Choices[][] = {
				{ "Yen", "Yin", "Ben" },
				{ "copy", "cp ", "cd" },
				{ "cd", "rm ", "delete" },
				{ "mkdir", "makedir", "addfolder" },
				{ "cp", "cd ", "cr" },
				{ "what", "which", "who" },
				{ "changeOwner", "change", "chown" },
				{ "delete", "remove ", "clear" },
				{ "NTFS", "EXT4", "BTRFS" },
				{ "uptime", "downtime", "primetime" }
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
		String Welcome = "\nWelcome to my TiaMP - QuizBee Edition!";
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

					Thread.sleep(15);

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

					Thread.sleep(10);

				} catch (InterruptedException INTERRUPT) {

					errorMsgInterrupt();

				}

			}

			System.out.println("\n\n");
			pressEnterToContinue();

			do {

				try {

					/* ~~~~ Y VARIABLES ~~~~ */
					String Guide = "Question #" + QuestNum + ": \n\n";
					String DisplayPrompt = "Enter your answer: ";

					/* ++ GUIDE ++ */
					clearConsoleTerminal();

					for (x = 0; x < Guide.length(); x++) {

						System.out.printf("%c", Guide.charAt(x));
						try {

							Thread.sleep(15);

						} catch (InterruptedException INTERRUPT) {

							errorMsgInterrupt();

						}

					}

					/* -- QUESTION DISPLAYING -- */
					for (x = 0; x < Questions[QuestCount].length(); x++) {

						System.out.printf("%c", Questions[QuestCount].charAt(x));
						try {

							Thread.sleep(15);

						} catch (InterruptedException INTERRUPT) {

							errorMsgInterrupt();

						}

					}

					/* -- CHOICE A -- */
					System.out.print("\n\nA. ");

					for (x = 0; x < Choices[QuestCount][0].length(); x++) {

						System.out.printf("%c", Choices[QuestCount][0].charAt(x));
						try {

							Thread.sleep(15);

						} catch (InterruptedException INTERRUPT) {

							errorMsgInterrupt();

						}

					}

					/* -- CHOICE B -- */
					System.out.print("\n\nB. ");

					for (x = 0; x < Choices[QuestCount][1].length(); x++) {

						System.out.printf("%c", Choices[QuestCount][1].charAt(x));
						try {

							Thread.sleep(15);

						} catch (InterruptedException INTERRUPT) {

							errorMsgInterrupt();

						}

					}

					/* -- CHOICE C -- */
					System.out.print("\n\nC. ");

					for (x = 0; x < Choices[QuestCount][2].length(); x++) {

						System.out.printf("%c", Choices[QuestCount][2].charAt(x));
						try {

							Thread.sleep(15);

						} catch (InterruptedException INTERRUPT) {

							errorMsgInterrupt();

						}

					}

					/* -- GET ANSWER -- */
					System.out.println("\n\n");

					for (x = 0; x < DisplayPrompt.length(); x++) {

						System.out.printf("%c", DisplayPrompt.charAt(x));
						try {

							Thread.sleep(15);

						} catch (InterruptedException INTERRUPT) {

							errorMsgInterrupt();

						}

					}

					String usrChoice = usrInput.nextLine();

					/* -- CHECK ANSWER -- */
					if (usrChoice.equalsIgnoreCase("A") || usrChoice.equalsIgnoreCase("B") || usrChoice.equalsIgnoreCase("C")) {

						if (usrChoice.equalsIgnoreCase(Answer[QuestCount])) {

							++ScoreCount;

						}

					}
					
					if (usrChoice.isBlank()) {

						throw new Exception("\n\nInput something moron! ");

					}
					
					if (usrChoice.length() != 1) {

						throw new InputMismatchException("\n\nInput one letter only moron! ");

					}

				} catch (Exception ERRORS) {

					System.out.println(ERRORS);
					System.exit(1);

				}

				QuestNum++;
				QuestCount++;

			} while (QuestCount < 10);

		} finally {

			usrInput.close();

		}

		System.out.println("Your score is " + ScoreCount + " out of 10 ");

	}

	public static void main(String[] args) {

		new QuizBee();

	}

}
