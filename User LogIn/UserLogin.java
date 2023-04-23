
/*==== LIBRARY IMPORTS ==== */
import java.io.*;
import java.util.*;
import java.nio.file.*;
import static java.lang.System.*;
import static java.nio.file.StandardOpenOption.*;

public class UserLogin {

	/* ==== CLASSES ==== */
	Scanner usrInput = new Scanner(in);
	String filename = "records.txt";



	/* ==== CLEAR CONSOLE TERMINAL ==== */
	private void clear() {

		out.print("\033[H\033[2J");
		out.flush();

	}



	/* ==== ERROR MESSAGES ==== */
	private void ErrorMsg_INTERRUPT() {

		out.println("Something Interrupted the Process... Exiting");
		exit(1);

	}



	/* ==== PRESS ENTER TO CONTINUE ==== */
	private void pressENTER() {

		String pressENTER = "Press ENTER to Continue... ";

		for (int x = 0; x < pressENTER.length(); x++) {

			System.out.printf("%c", pressENTER.charAt(x));
			try {
				Thread.sleep(15);
			} catch (InterruptedException INTERRUPT) {
				ErrorMsg_INTERRUPT();
			}

		}

		try {
			System.in.read();
			System.exit(0);
		} catch (Exception ERRORS) {
			ErrorMsg_INTERRUPT();
		}

	}



	/* ==== ADD MORE ACCOUNTS? ==== */
	private void Accounts



	/* ==== MAIN MENU ==== */
	private void MainMenu() {

		String mainmenu = """
				========== ========== ========== ==========

				Choose what you want to do:

					a. Create a User Account

					b. Login a User Account

				========== ========== ========== ==========



				""";

		for (int x = 0; x < mainmenu.length(); x++) {

			out.printf("%c", mainmenu.charAt(x));
			try {
				Thread.sleep(5);
			} catch (InterruptedException INTERRUPT) {
				ErrorMsg_INTERRUPT();
			}

		}

	}



	/* ==== INPUT CHECKING ==== */
	private void Answer() {

		String Ans = "Enter Answer: ";

		for (int x = 0; x < Ans.length(); x++) {

			out.printf("%c", Ans.charAt(x));
			try {
				Thread.sleep(5);
			} catch (InterruptedException INTERRUPT) {
				ErrorMsg_INTERRUPT();
			}

		}

		String usrChoice = usrInput.nextLine();

		if (usrChoice.equalsIgnoreCase("a")) {

			CreateAccount();

		} else if (usrChoice.equalsIgnoreCase("b")) {

			LoginAccount();

		}

	}










	void CreateAccount() {

		try {

			Path filepath = Paths.get(filename.toString());
			OutputStream output = new BufferedOutputStream(Files.newOutputStream(filepath, APPEND));
			BufferedWriter editor = new BufferedWriter(new OutputStreamWriter(output));

			out.print("Enter username: ");
			String username = usrInput.nextLine();

			out.print("Enter password: ");
			String passwd = usrInput.nextLine();

			editor.write(username + " " + passwd);
			editor.newLine();

			out.println("Account saved!");

			editor.close();
			output.close();

		} catch (Exception ERRORS) {



		}

	}










	void LoginAccount() {

		try {

			Path filepath = Paths.get(filename.toString());
			InputStream input = Files.newInputStream(filepath);
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));

			out.print("Enter username: ");
			String username = usrInput.nextLine();

			out.print("Enter password: ");
			String passwd = usrInput.nextLine();

			String _temp = null;
			String _user, _pass;
			boolean found = false;

			while ((_temp = reader.readLine()) != null) {

				String[] account = _temp.split(" ");
				_user = account[0];
				_pass = account[1];

				if (_user.equals(username) && _pass.equals(passwd)) {
					found = true;
				}

			}

			if (found == true) {

				out.println("LOGGED IN!");

			} else {

				out.println("Screw off bro...");
				pressENTER();

			}


		} catch ( IOException ERROR) {}
		



	}










	/* ==== PROGRAM FUNCTIONS ==== */
	public UserLogin() {

		try {

			clear();
			MainMenu();
			Answer();
			



		} catch (Exception ERROR) {

		}

	}










	/* ==== RUN PROGRAM ==== */
	public static void main(String[] args) {

		new UserLogin();

	}

}
