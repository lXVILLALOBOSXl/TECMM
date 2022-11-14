package com.test;

import com.algorithm.Cast;
import com.file.Read;
import com.file.Write;
import com.util.Util;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        do {
            menu(); //Print menu
        }while (operations(Util.getPositiveInt("option"))); //If option isn't exit*/
    }

    /**
     * Prints all kind of options
     */
    private static void menu(){
        System.out.println("\nWelcome to Files program! \n" +
                "1) Add\n" +
                "2) Calculate\n" +
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
            case 1: //Ask and write numbers into File
                Write.write("numbers.txt",fillNumbersList());
                return repeat;
            case 2: //Reads numbers and Write asterisk into File
                Write.write("././asterisks.txt",Cast.intToAsterisks(Read.read("././numbers.txt")));
                return repeat;
            case 0: //Exit
                System.out.println("Bye!");
                return !repeat;
            default: //If the option was a correct int but a incorrect option
                System.out.println("Incorrect option, please try again."); //advises to user
                operations(Util.getPositiveInt("option")); //requests a correct option again
                return repeat;
        }
    }

    /**
     * Asks and save the user's double inputs
     * @return List with all user's couble inputs
     */
    private static ArrayList<String> fillNumbersList(){
        ArrayList<String> arrayList = new ArrayList<>(); //Save data as String to put chars into file
        int n = 0; //Index counter
        String input = "";
        int intInput = Util.getPositiveInt("number " + n); //Verify if it's a int
        arrayList.add(Integer.toString(intInput));
        do {
            System.out.print("Enter q to quit, or ");
            input = Util.getInput("number " + (++n));
            if(input.equals("Q") || input.equals("q")){ //Ends the recorder inputs
                break;
            }
            try { //Verify if it's a int
                intInput = Integer.parseInt(input);
                arrayList.add(Integer.toString(intInput));
            }catch (Exception e){
                System.out.println("Incorrect input try again");
                --n;
            }
        }while (true);

        return arrayList;
    }
}
