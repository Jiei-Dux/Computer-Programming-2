// package LabExer5B;

import java.util.*;

public class LabExer5B {

	public LabExer5B() {

		// Scanner
		Scanner usrInput = new Scanner(System.in);

		String Question[] = {
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

		// Answers
		String Choice1[] = {
				" Yen ", // 1
				" copy ", // 2
				" cd ", // 3
				" mkdir ", // 4
				" cp ", // 5
				" what ", // 6
				" changeOwner ", // 7
				" delete ", // 8
				" NTFS ", // 9
				" uptime ", // 10
		};
		String Choice2[] = {
				" Yin ", // 1
				" cp ", // 2
				" rm ", // 3
				" makedir ", // 4
				" cd ", // 5
				" which ", // 6
				" change ", // 7
				" remove ", // 8
				" EXT4 ", // 9
				" downtime ", // 10
		};
		String Choice3[] = {
				" Ben ", // 1
				" cd ", // 2
				" delete ", // 3
				" addfolder ", // 4
				" cr ", // 5
				" who ", // 6
				" chown ", // 7
				" clear ", // 8
				" BTRFS ", // 9
				" primetime ", // 10
		};
		char Answer[] = {
				'A', // 1
				'B', // 2
				'B', // 3
				'A', // 4
				'B', // 5
				'C', // 6
				'C', // 7
				'C', // 8
				'B', // 9
				'A', // 10
		};

		// Answers Cheat Sheet
		/*
		 * {
		 * 1. A
		 * 2. B
		 * 3. B
		 * 4. A
		 * 5. B
		 * 6. C
		 * 7. C
		 * 8. C
		 * 9. B
		 * 10. A
		 * }
		 */
		// Variables
		int x,
				QuestionNumber = 1,
				QuestionCounter = 0,
				ScoreCounter = 0;

		//
		String DisplayPrompt = " Enter your answer: ";

		try {

			do {

				try {

					// Variables
					String Indicator = " Question #" + QuestionNumber + ": \n\n";

					/* ~~~~ CLEAR TERMINAL / CONSOLE ~~~~ */
					System.out.print("\033[H\033[2J");
					System.out.flush();

					/* ~~~~ INDICATOR ~~~~ */
					for (x = 0; x < Indicator.length(); x++) {

						System.out.printf("%c", Indicator.charAt(x));
						try {

							Thread.sleep(20);

						} catch (InterruptedException INTERRUPT) {

							//
						}

					}

					/* ~~~~ QUESTION #1 ~~~~ */
					for (x = 0; x < Question[QuestionCounter].length(); x++) {

						System.out.printf("%c", Question[QuestionCounter].charAt(x));
						try {

							Thread.sleep(20);

						} catch (InterruptedException INTERRUPT) {

							//
						}

					}

					/* ~~~~ CHOICES FOR QUESTION #1 ~~~~ */
					// Choice 1
					System.out.print("\n\n A.");

					for (x = 0; x < Choice1[QuestionCounter].length(); x++) {

						System.out.printf("%c", Choice1[QuestionCounter].charAt(x));
						try {

							Thread.sleep(20);

						} catch (InterruptedException INTERRUPT) {

							//
						}

					}

					// Choice 2
					System.out.print("\n\n B.");

					for (x = 0; x < Choice2[QuestionCounter].length(); x++) {

						System.out.printf("%c", Choice2[QuestionCounter].charAt(x));
						try {

							Thread.sleep(20);

						} catch (InterruptedException INTERRUPT) {

							//
						}

					}

					// Choice 3
					System.out.print("\n\n C.");

					for (x = 0; x < Choice3[QuestionCounter].length(); x++) {

						System.out.printf("%c", Choice3[QuestionCounter].charAt(x));
						try {

							Thread.sleep(20);

						} catch (InterruptedException INTERRUPT) {

							//
						}

					}

					/* ~~~~ PROMPT DISPLAYING #1 ~~~~ */
					System.out.print("\n\n");

					for (x = 0; x < DisplayPrompt.length(); x++) {

						System.out.printf("%c", DisplayPrompt.charAt(x));
						try {

							Thread.sleep(20);

						} catch (InterruptedException INTERRUPT) {

							//
						}

					}

					String usrChoice = usrInput.nextLine();

					/* ~~~~ ANSWER CHECKING #1 ~~~~~ */
					if (usrChoice.equalsIgnoreCase('A') || usrChoice.equalsIgnoreCase('B')
							|| usrChoice.equalsIgnoreCase('C')) {
						if (usrChoice.equalsIgnoreCase(Answer[QuestionCounter])) {
							++ScoreCounter;
						}
					}

				} catch (Exception ERROR) {

					//

				}

				QuestionNumber++;
				QuestionCounter++;

			} while (QuestionCounter < 10);

		} finally {

			usrInput.close();

		}

		System.out.println(" Your score is " + ScoreCounter + " out of 10 ");

	}

	public static void main(String[] args) {

		new LabExer5B();

	}

}
