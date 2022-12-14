package com.util;

import java.util.Scanner;

public abstract class Util {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * Asks for the inputs and analyzes if is a correct input
     * an check if it's positive number
     * @param message Kind of input, for example: number 1, number 2, option
     * @return recorded entry
     */
    public static int getInt(String message){
        String input;
        int number = 0;
        boolean incorrectInput;

        do {
            incorrectInput = false;
            System.out.printf("Type a correct " + message + ": ");
            input = scanner.nextLine();
            try { //If the input recorded isn't a int
                number = Integer.parseInt(input);
                if(number < 0){
                    System.out.println("You number can't be negative");
                    throw new Exception();
                }
            } catch (Exception ex) { //Warn the user that it input isn't correct input
                System.out.println("Incorrect input, please try again. ");
                incorrectInput = true;
            }
        }while (incorrectInput); //If the input isn't correct, input again

        return number;
    }

    public static double getDouble(String message){
        String input;
        double number = 0;
        boolean incorrectInput;

        do {
            incorrectInput = false;
            System.out.printf("Type a correct " + message + ": ");
            input = scanner.nextLine();
            try { //If the input recorded isn't a int
                number = Double.parseDouble(input);
                if(number < 0){
                    System.out.println("You number can't be negative");
                    throw new Exception();
                }
            } catch (Exception ex) { //Warn the user that it input isn't correct input
                System.out.println("Incorrect input, please try again. ");
                incorrectInput = true;
            }
        }while (incorrectInput); //If the input isn't correct, input again

        return number;
    }

    public static String getString(String message){
        System.out.printf("Type a correct " + message + ": ");
        return scanner.nextLine();
    }

}
