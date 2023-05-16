import java.util.Scanner;
import static java.lang.System.*;

public class EnumDemo {

    enum Period { PRELIM, MIDTERM, PREFINAL, FINAL };

    public static void main (String[] args) {

        Period pd;
        String input;
        int position;
        //int comparison;

        Scanner usrInput = new Scanner (System.in);
        out.println("The grading periods are: ");
        for (Period p : Period.values())

        out.print(p + " \n");
        out.print("\nSelect a grading period: ");
        input = usrInput.nextLine().toUpperCase();
        pd = Period.valueOf(input);
        usrInput.close();

        out.println("\nYou entered " + pd + "\n");
        position = pd.ordinal();

        out.println(pd + " is in position " + position);
        out.println("So its period number is " + (position + 1));

    }

}