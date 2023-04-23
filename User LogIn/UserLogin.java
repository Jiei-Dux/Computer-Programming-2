
/* ==== LIBRARY IMPORTS ==== */
import java.io.*;
import java.util.*;
import java.nio.file.*;
import static java.lang.System.*;
import static java.nio.file.StandardOpenOption.*;

/* ==== MAIN CLASS ==== */
public class UserLogin {

	/* ==== SCANNER ==== */
	Scanner usrInput = new Scanner(in);

	/* ==== GLOBAL VARIABLES ==== */
	int x;
	String filename = "records.txt";
	String Username, Passwd;

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

	/* ==== SUCCESSFUL LOGIN MESSAGE ==== */
	private void Success() {

		String successLogIn = "You are now LOGGED IN!";

		for (x = 0; x < successLogIn.length(); x++) {

			out.printf("%c", successLogIn.charAt(x));
			try {
				Thread.sleep(5);
			} catch (InterruptedException INTERRUPT) {
				ErrorMsg_INTERRUPT();
			}

		}

		out.println();
		pressENTER();
		exit(0);

	}

	/* ==== FAILED LOGIN MESSAGE ==== */
	private void Failed() {

		String failLogIn = "Wrong Username and/or Password...";

		for (x = 0; x < failLogIn.length(); x++) {

			out.printf("%c", failLogIn.charAt(x));
			try {
				Thread.sleep(5);
			} catch (InterruptedException INTERRUPT) {
				ErrorMsg_INTERRUPT();
			}

		}

		out.println();
		pressENTER();
		exit(1);

	}

	/* ==== PRESS ENTER TO CONTINUE ==== */
	private void pressENTER() {

		String pressENTER = "Press ENTER to Continue... ";

		for (x = 0; x < pressENTER.length(); x++) {

			out.printf("%c", pressENTER.charAt(x));
			try {
				Thread.sleep(5);
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

	/* ==== MAIN MENU ==== */
	private void MainMenu() {

		clear();

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

			if (usrChoice.isBlank()) {
				throw new Exception("\n\nInput something moron! ");
			}

			if (usrChoice.length() != 1) {
				throw new InputMismatchException("\n\nInput only one letter moron! ");
			}

		} catch (Exception ERRORS) {

			clear();
			out.println(ERRORS);
			exit(1);

		}

	}

	/* ==== CREATE ACCOUNT ==== */
	void CreateAccount() {

		try {

			clear();

			Path filepath = Paths.get(filename.toString());
			OutputStream output = new BufferedOutputStream(Files.newOutputStream(filepath, APPEND));
			BufferedWriter editor = new BufferedWriter(new OutputStreamWriter(output));

			Input();

			editor.write(Username + " " + Passwd);
			editor.newLine();

			out.println("Account added!");

			editor.close();
			output.close();

			addAccounts();

		} catch (IOException ERRORS) {

			out.println(ERRORS.getMessage());

		}

	}

	/* ==== LOGIN ACCOUNT ==== */
	void LoginAccount() {

		try {

			clear();

			Path filepath = Paths.get(filename.toString());
			InputStream input = Files.newInputStream(filepath);
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));

			Input();

			String File = null;
			String username, passwd;
			boolean found = false;

			while ((File = reader.readLine()) != null) {

				String[] account = File.split(" ");
				username = account[0];
				passwd = account[1];

				if (username.equals(Username) && passwd.equals(Passwd)) {
					found = true;
				}

			}

			if (found == true) {
				Success();
			} else {
				Failed();
				pressENTER();
			}

		} catch (IOException ERROR) {
			out.println(ERROR.getMessage());
		}

	}

	/* ==== ASK USER FOR INPUT ==== */
	private void Input() {

		String askUsername = "Enter username: ";
		String askPasswd = "Enter password: ";

		for (x = 0; x < askUsername.length(); x++) {

			out.printf("%c", askUsername.charAt(x));
			try {
				Thread.sleep(5);
			} catch (InterruptedException INTERRUPT) {
				ErrorMsg_INTERRUPT();
			}

		}
		Username = usrInput.nextLine().toLowerCase();

		for (x = 0; x < askPasswd.length(); x++) {

			out.printf("%c", askPasswd.charAt(x));
			try {
				Thread.sleep(5);
			} catch (InterruptedException INTERRUPT) {
				ErrorMsg_INTERRUPT();
			}

		}
		Passwd = usrInput.nextLine().toLowerCase();

	}

	/* ==== ADD MORE ACCOUNTS? ==== */
	private void addAccounts() {

		clear();

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
				CreateAccount();
			} else if (usrChoice.equalsIgnoreCase("N")) {

				clear();

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
			CreateAccount();
		}

	}

	/* ==== PROGRAM FUNCTIONS ==== */
	public UserLogin() {

		try {
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
