package com.main;

import com.geometry.*;
import com.util.Util;

public class Test {

    private static GeometricFigure geometricFigure;

    /**
     * Runs main program
     * @param args
     */
    public static void main(String[] args) {
        do {
            menu(); //Print menu
        }while (operations(Util.getInt("option"))); //If option isn't exist*/
    }

    /**
     * Prints all kind of main menu options
     */
    private static void menu(){
        System.out.println("\nWelcome to Geometry program! \n" +
                "1) Circle\n" +
                "2) Triangle\n" +
                "3) Square\n" +
                "4) Ellipse\n" +
                "0) Exit\n");
    }

    /**
     * Asks and prints for the requested function
     * @param option function that the user want to use
     * @return if the menu will be printed again
     */
    private static boolean operations(int option){
        boolean repeat = true; //When the requested function finalizes, the option menu will be printed again

        switch (option){
            case 1: //Circle
                //ask figure values
                geometricFigure = new Circle(Util.getDouble("radius"));
                break;
            case 2: //Triangle
                geometricFigure = new Triangle(Util.getDouble("base"),Util.getDouble("height"));
                break;
            case 3: //Square
                geometricFigure = new Square(Util.getDouble("side"));
                break;
            case 4: //Ellipse
                geometricFigure = new Ellipse(Util.getDouble("radius A"),Util.getDouble("radius B"));
                break;
            case 0: //Exit
                System.out.println("Bye!");
                return !repeat;
            default: //If the option was a correct int but a incorrect option
                System.out.println("Incorrect option, please try again."); //advises to user
                operations(Util.getInt("option")); //requests a correct option again
                return repeat;
        }
        //print figure values
        System.out.println(geometricFigure);
        return repeat;
    }

}
