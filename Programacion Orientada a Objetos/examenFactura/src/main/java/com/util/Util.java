package com.util;

import com.dto.Date;
import com.dto.Product;
import com.dto.Saleman;

import java.util.Locale;
import java.util.Scanner;

public class Util {
    /**
     * Asks for the int inputs and analyzes if is a correct input
     * @param message Kind of input, for example: number 1, number 2, option
     * @return recorded entry
     */
    public static int askPositiveInt(String message){
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
                if(number < 1){
                    throw new Exception();
                }
            } catch (Exception ex) { //Warn the user that it input isn't correct input
                System.out.println("Incorrect input, please try again. ");
                incorrectInput = true;
            }
        }while (incorrectInput); //If the input isn't correct, input again

        return number;
    }

    public static double askPositiveDouble(String message){
        Scanner scanner = new Scanner(System.in);
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
                    throw new Exception();
                }
            } catch (Exception ex) { //Warn the user that it input isn't correct input
                System.out.println("Incorrect input, please try again. ");
                incorrectInput = true;
            }
        }while (incorrectInput); //If the input isn't correct, input again

        return number;
    }

    /**
     * Asks for the inputs
     * @param message Kind of input, for example: number 1, number 2, option
     * @return recorded entry
     */
    public static String askString(String message){
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.printf("Type a correct " + message + ": ");
        input = scanner.nextLine();
        return input;
    }

    public static char warning(String message){
        Scanner scanner = new Scanner(System.in);
        char input;
        System.out.printf(message);
        input = scanner.next().toLowerCase(Locale.ROOT).charAt(0);
        return input;
    }

    public static Date askDate(String message){
        System.out.println("Type a correct " + message + ". ");
        return new Date(Util.askPositiveInt("day"),Util.askPositiveInt("month"),Util.askPositiveInt("year"));
    }

    public static Saleman askSalesman(){
        System.out.println("Add a correct salesman. ");
        return new Saleman(Util.askString("name"),Util.askString("first last name"),Util.askString("second last name"),Util.askDate("birthday"),Util.askString("area"),Util.askPositiveDouble("commission"),Util.askPositiveDouble("salary"));
    }

    public static Product askProduct(){
        System.out.println("Add a correct product. ");
        String description = Util.askString("description");
        double price = Util.askPositiveDouble("price");
        return new Product(description,price);
    }


}
