package com.test;

import com.numbers.Calculator;
import java.util.Scanner;

/**
 * Luis Adrian Villalobos Rivera 2ISC 220120379 P1 TM
 * Main class to test Calculator class and run our main program
 */
public class CalculatorTest {

    /**
     * Runs main program
     * @param args
     */
    public static void main(String[] args) {
        do {
            menu(); //Print menu
        }while (operations((int) getNumber("option"))); //If option isn't exit
    }

    /**
     * Prints all kind of options
     */
    private static void menu(){
        System.out.println("\nWelcome to Calculator program! \n" +
                "1) Sum\n" +
                "2) Subtraction\n" +
                "3) Multiplication\n" +
                "4) Division\n" +
                "5) Factorial\n" +
                "6) Is pair?\n" +
                "7) Is perfect number?\n" +
                "8) Are friends numbers?\n" +
                "9) Exit\n");
    }

    /**
     * Asks for the inputs and analyzes if is a correct input
     * @param message Kind of input, for example: number 1, number 2, option
     * @return recorded entry
     */
    private static double getNumber(String message){
        Scanner scanner = new Scanner(System.in);
        String input;
        int number = 0;
        boolean incorrectInput;


        do {
            incorrectInput = false;
            System.out.printf("Type a correct " + message + ": ");
            input = scanner.nextLine();
            try { //If the input recorded isn't a int
                number = Integer.parseInt(input);
            } catch (Exception ex) { //Warn the user that it input isn't correct input
                System.out.println("Incorrect input, please try again. ");
                incorrectInput = true;
            }
        }while (incorrectInput); //If the input isn't correct, input again

        return number;
    }

    /**
     * Asks and prints for the requested function
     * @param option function that the user want to use
     * @return if the menu will be printed again
     */
    private static boolean operations(int option){
        Calculator calculator;
        boolean repeat = true; //When the requested function finalizes, the option menu will be printed again

        switch (option){
            case 1: //sum
                //asks for the numbers that the operation will be done and creates an instance with that numbers to use its methods
                calculator = new Calculator(getNumber("number 1"), getNumber("number 2"));
                //ask and print the requested function
                System.out.println("Sum of " + calculator.getN1() + " + " + calculator.getN2() + " = " + calculator.add());
                return repeat;
            case 2: //subtraction
                calculator = new Calculator(getNumber("number 1"), getNumber("number 2"));
                System.out.println("Subtraction of " + calculator.getN1() + " - " + calculator.getN2() + " = " + calculator.subtract());
                return repeat;
            case 3: //multiplication
                calculator = new Calculator(getNumber("number 1"), getNumber("number 2"));
                System.out.println("Multiplication of " + calculator.getN1() + " * " + calculator.getN2() + " = " + calculator.multiply());
                return repeat;
            case 4: //division
                calculator = new Calculator(getNumber("number 1"), getNumber("number 2"));
                System.out.println("Division of " + calculator.getN1() + " / " + calculator.getN2() + " = " + calculator.split());
                return repeat;
            case 5: //factorial
                calculator = new Calculator(getNumber("number 1"), getNumber("number 2"));
                System.out.println("Factorial of " + calculator.getN1() + " is = " + calculator.factorial());
                return repeat;
            case 6: //pair
                calculator = new Calculator(getNumber("number"));
                System.out.println("Is " + calculator.getN1() + " pair?: " + calculator.isPair());
                return repeat;
            case 7: //perfect number
                calculator = new Calculator(getNumber("number"));
                System.out.println("Is " + calculator.getN1() + " perfect number?: " + calculator.isPerfectNumber());
                return repeat;
            case 8: //friends number
                calculator = new Calculator(getNumber("number 1"), getNumber("number 2"));
                System.out.println("Are " + calculator.getN1() + " and " + calculator.getN2() + " friends numbers?: " + calculator.areFriendsNumbers());
                return repeat;
            case 9: //finishes it repeats print menu
                return !repeat;
            default: //If the option was a correct int but a incorrect option
                System.out.println("Incorrect option, please try again."); //advises to user
                operations((int) getNumber("option")); //requests a correct option again
                return repeat;
        }
    }

}
