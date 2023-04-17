// package LabExer5B;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class LabExer5B {

		public LabExer5B() {

			File File = new File("Questions.txt");
			Path FilePath = Paths.get(File.toString());

			String Array1[] = new String[1000];
			String Array2[];

			Random Argh = new Random();
			Scanner usrInput = new Scanner(System.in);

			String ErrorMsg = "Something went wrong... Exiting...";
			String Questions;
			int Count;

			try {

				try {

					InputStream input = Files.newInputStream(FilePath);
					BufferedReader FileReader = new BufferedReader(new InputStreamReader(input));

					String Doc = null;

					while ((Doc = FileReader.readLine()) != null ) {

						Array1[Count] = Doc;
						++Count;

					}

					Questions = Array1[Argh.nextInt(Count)];

					/* */
					try {

						System.out.print( "\033[H\033[2J" );
						System.out.flush();

						try {

							System.in.read();

							System.out.print( "\033[H\033[2J" );
							System.out.flush();

						} catch ( Exception Error ) {

							System.out.println ( ErrorMsg );
							System.exit(1);

						}

					} catch ( Exception Error ) {

						System.out.println ( ErrorMsg );
						System.exit(1);

					}

					do {

						System.out.println ( Questions );
						

					} while (true);

				} catch () {}

			} catch () {}

		}

		public static void main (String[] args) {

			new LabExer5B();

		}
	
}
