import java.util.*;
import static java.lang.System.*;

public class Concurrency extends Thread {

	public static void main(String[] args) {

		// Thingamajigs //
		Scanner usrInput = new Scanner(in);
		Concurrency Thread1 = new Concurrency();
		Concurrency Thread2 = new Concurrency();

		// Scanner //
		out.print("Enter First Thread's Name: ");
		String FirstThreadName = usrInput.nextLine();
		Thread1.setName(FirstThreadName);

		out.print("Enter Second Thread's Name: ");
		String SecondThreadName = usrInput.nextLine();
		Thread2.setName(SecondThreadName);
		usrInput.close();

		// is New? //
		out.println(Thread1.getName() + " is NEW");
		out.println(Thread2.getName() + " is NEW");

		// Starting Message //
		out.println("\n\nStarting the threads...");

		// START THREAD??? //
		Thread1.start();
		Thread2.start();

		// SCHLEEP //
		try {
			Thread.sleep(1000);
			out.println("\n\nAfter sleep...");
		} catch (InterruptedException ERROR) {
		}

	}

	public void run() {

		// YES //
		try {
			Thread.sleep(500);
			out.println(Thread.currentThread().getName() + " is RUNNING");
		} catch (InterruptedException ERROR) {
		}

		// NO //
		try {
			Thread.sleep(500);
			out.println(Thread.currentThread().getName() + " is TERMINATED");
		} catch (InterruptedException ERROR) {
		}

	}

}