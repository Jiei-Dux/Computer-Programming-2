/* ==== LIBRARY IMPORTS ==== */
import java.util.*;
import java.util.regex.*;
import static java.lang.System.*;

/* ==== MAIN CODE ==== */
public class StudentLogin {

	// MAIN CLASS //
	public static void main(String[] args) {

		// SCANNER //
		Scanner usrInput = new Scanner(in);


		// VARIABLES //
		String studnum;

		// MAIN PROCESS //
		out.print("Enter your student number: ");
		studnum = usrInput.nextLine();
		usrInput.close();

		//out.print(studnum.matches("\\d{4}-\\d{2}-\\d{3}"));

		if ( studnum.matches("\\d{4}-\\d{2}-\\d{3}") == true ) {

			out.print("Ayo! You are now logged in");
			exit(0);

		} else {

			out.print("What in the he** did you do?");
			exit(1);

		}

	}

}