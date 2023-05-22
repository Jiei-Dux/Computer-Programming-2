/* ==== LIBRARY IMPORTS ==== */
import java.util.*;
import java.util.regex.*;
import static java.lang.System.*;

// ---- MAIN CLASS ---- //
public class RhymeChecker {

	public static void main(String[] args) {

		// STRING VARIABLES //
		String word1, word2, sub;

		// SCANNER //
		Scanner usrInput = new Scanner(in);

		// FUNCTIONS //
		out.print("Enter first word: ");
		word1 = usrInput.nextLine();

		out.print("Enter second word: ");
		word2 = usrInput.nextLine();

		sub = word1.substring(word1.length()-2, word1.length());

		usrInput.close();

		// INIT //
		Pattern layout = Pattern.compile("[a-z, A-Z]{1,2}" + sub + "");
		Matcher same = layout.matcher(word2);

		// MATCH CHECKER //
		if (same.matches()) {
			out.println(word2 + " rhymes with " + word1);
		} else {
			out.println("oop... looks like " + 
						word2 + 
						" does not rhyme with " + 
						word1 + 
						" or theres more than 2 letters before '" + sub + "'. ");
		}

	}

}