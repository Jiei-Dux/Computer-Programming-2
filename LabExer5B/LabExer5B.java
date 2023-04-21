// package LabExer5B;

import java.util.*;

public class LabExer5B {

	public LabExer5B() {

		// Scanner
		Scanner usrInput = new Scanner(System.in);

		// Questions
		String Question[] = new String[10];

		Question[0] = " What is the color of the Sun.";
		Question[1] = " What is the smallest planet in our solar system ( also known as Dwarf Planet )?";
		Question[2] = " What is Japan's currency?";
		Question[3] = " What do you call a magic owl?";
		Question[4] = "";
		Question[5] = "";
		Question[6] = "";
		Question[7] = "";
		Question[8] = "";
		Question[9] = "";

		// Answers
		String Choice1[] = {
				" Yellow", // 1
				"", // 2
				"", // 3
				"", // 4
				"", // 5
				"", // 6
				"", // 7
				"", // 8
				"", // 9
				"", // 10
		};
		String Choice2[] = {
				" Red", // 1
				"", // 2
				"", // 3
				"", // 4
				"", // 5
				"", // 6
				"", // 7
				"", // 8
				"", // 9
				"", // 01
		};
		String Choice3[] = {
				" Blue", // 1
				"", // 2
				"", // 3
				"", // 4
				"", // 5
				"", // 6
				"", // 7
				"", // 8
				"", // 9
				"", // 10
		};
		String Answer[] = {
				"Yellow", // 1
				"", // 2
				"", // 3
				"", // 4
				"", // 5
				"", // 6
				"", // 7
				"", // 8
				"", // 9
				"", // 10
		};

		// Variables
		int x,
				QuestionCounter = 0,
				ScoreCounter = 0;

		//
		String DisplayPrompt = " Enter your answer: ";
		String Indicator = " Question #" + QuestionCounter + 1 + ": \n\n";

		do {

			try {

				/* ~~~~ CLEAR TERMINAL / CONSOLE ~~~~ */
				System.out.print( "\033[H\033[2J" );
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

				/* ~~~~ PROMT DISPLAYING #1 ~~~~ */
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
				if (usrChoice.equalsIgnoreCase("A") || usrChoice.equalsIgnoreCase("B")|| usrChoice.equalsIgnoreCase("C")) {
					if (usrChoice.equalsIgnoreCase(Answer[QuestionCounter])) {
						++ScoreCounter;
					}
				}

			} catch (Exception ERROR) {

				//

			}

			QuestionCounter++;

		} while (QuestionCounter < 1);

		System.out.print(" Your score is " + ScoreCounter + " out of 10 ");

	}

	public static void main(String[] args) {

		new LabExer5B();

	}

}
