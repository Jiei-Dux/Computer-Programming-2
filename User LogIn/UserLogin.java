
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

	/* ==== GLOBAL VARIABLES ==== */
	int x;

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

		for (x = 0; x < pressENTER.length(); x++) {

			out.printf("%c", pressENTER.charAt(x));
			try {
				Thread.sleep(15);
			} catch (InterruptedException INTERRUPT) {
				ErrorMsg_INTERRUPT();
			}

		}

		try {
			in.read();
			exit(0);
		} catch (Exception ERRORS) {
			ErrorMsg_INTERRUPT();
		}

	}

	/* ==== ADD MORE ACCOUNTS? ==== */
	private void addAccounts() {

		String addAccounts = "Continue Adding Accounts? (Y/n): ";
		String aight = "Aight then... exiting... ";

		for (x = 0; x < addAccounts.length(); x++) {

			out.printf("%c", addAccounts.charAt(x));
			try {
				Thread.sleep(5);
			} catch (InterruptedException INTERRUPT) {
				ErrorMsg_INTERRUPT();
			}

		}

		String usrChoice = usrInput.nextLine();

		/* CHECK INPUT */
		if (usrChoice.equalsIgnoreCase("Y") || usrChoice.equalsIgnoreCase("N")) {

			if (usrChoice.equalsIgnoreCase("Y")) {

				new UserLogin();

			} else if (usrChoice.equalsIgnoreCase("N")) {

				for (x = 0; x < aight.length(); x++) {

					out.printf("%c", aight.charAt(x));
					try {
						Thread.sleep(5);
					} catch (InterruptedException INTERRUPT) {
						ErrorMsg_INTERRUPT();
					}

				}

			}

		}

		/* DEFAULTS TO "YES" IF USER ONLY PRESSED <ENTER> */
		if (usrChoice.isBlank()) {

			new UserLogin();

		}

		if (usrChoice.length() != 1) {

			throw new InputMismatchException("\n\nInput only one letter moron! ");

		}

	}

	/* ==== MAIN MENU ==== */
	private void MainMenu() {

		String mainmenu = """
				========== ========== ========== ==========

				Choose what you want to do:

					a. Create a User Account

					b. Login a User Account

				========== ========== ========== ==========



				""";

		for (x = 0; x < mainmenu.length(); x++) {

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

		try {

			String Ans = "Enter Answer: ";

			for (x = 0; x < Ans.length(); x++) {

				out.printf("%c", Ans.charAt(x));
				try {
					Thread.sleep(5);
				} catch (InterruptedException INTERRUPT) {
					ErrorMsg_INTERRUPT();
				}

			}

			String usrChoice = usrInput.nextLine();

			if (usrChoice.equalsIgnoreCase("A") || usrChoice.equalsIgnoreCase("B")) {

				if (usrChoice.equalsIgnoreCase("A")) {
					CreateAccount();
				} else if (usrChoice.equalsIgnoreCase("B")) {
					LoginAccount();
				}

			}

			if (usrChoice.length() != 1) {
				throw new InputMismatchException("\n\nInput only one letter moron! ");
			}

			if (usrChoice.isBlank()) {
				throw new Exception("\n\nInput something moron! ");
			}

		} catch (Exception ERRORS) {

			out.println(ERRORS);
			exit(1);

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

			out.println("Account added!");

			editor.close();
			output.close();

			addAccounts();

		} catch (IOException ERRORS) {

			out.println(ERRORS.getMessage());

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

				out.println("You are now LOGGED IN!");
				out.println("Exiting... ");
				exit(0);

			} else {

				out.println("Screw off bro...");
				pressENTER();

			}

		} catch (IOException ERROR) {
			out.println(ERROR.getMessage());
		}

	}

	/* ==== PROGRAM FUNCTIONS ==== */
	public UserLogin() {

		try {

			clear();
			MainMenu();
			Answer();

		} catch (Exception ERROR) {
			out.println(ERROR.getMessage());
		}

	}

	/* ==== RUN PROGRAM ==== */
	public static void main(String[] args) {

		new UserLogin();

	}

}
