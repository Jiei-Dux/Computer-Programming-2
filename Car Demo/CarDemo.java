/* ==== LIBRARY IMPORTS ==== */
import static java.lang.System.*;

/* ==== ENUMS AND SUB CLASSES ==== */
class Color {

    enum Colors { RED, GREEN, BLUE, BLACK, GRAY, WHITE };

}

class Model {

    enum Models { SEDAN, SUV, CONVERTIBLE, HATCHBACK };

}

/*
 *
 *      Just a quick note... It said in the Instructions to make the
 *      class and enum have the same names but, just as I have guessed...
 *      it will never work because they have the same ******* name...
 * 
 *      Which is why I changed their names... (e.g. Model and Color)
 * 
 */

class Car {

    private int year;
    private Model.Models model;
    private Color.Colors color;

    /* ---- CONSTRUCTOR FOR CAR CLASS ---- */
    Car(int yr, Model.Models m, Color.Colors c) {

        year = yr;
        model = m;
        color = c;

    }

    /* ---- DISPLAY METHOD ---- */
    public void display() {

        out.print("Model: " + model + "\n" + "Color: " + color + "\n" + "Year: " + year + "\n\n" );

    }

}

/* ==== MAIN CLASS ==== */
public class CarDemo {

    public static void main(String[] args) {

        Car car1 = new Car(2014, Model.Models.SUV, Color.Colors.RED);
        Car car2 = new Car(2019, Model.Models.HATCHBACK, Color.Colors.BLACK);

        car1.display();
        car2.display();

    }

}