package com.main;

import com.dao.Directory;
import com.util.Util;

public class Run {
    private static final Directory directory = new Directory();

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
                "1) New file\n" +
                "2) Create\n" +
                "3) Find\n" +
                "4) Update\n" +
                "5) Delete\n" +
                "6) Exit\n");
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
                directory.initFile();
                return repeat;
            case 2: //Reads numbers and Write asterisk into File
                directory.create(Util.getInput("name"),Util.getInput("last name"),Util.getInput("cellphone"),Util.getInput("address"));
                return repeat;
            case 3: //Ask and write numbers into File
                directory.find(Util.getPositiveInt("id"));
                return repeat;
            case 4: //Reads numbers and Write asterisk into File
                directory.update(Util.getPositiveInt("id"));
                return repeat;
            case 5: //Ask and write numbers into File
                directory.delete(Util.getPositiveInt("id"));
                return repeat;
            case 6: //Exit
                System.out.println("Bye!");
                return !repeat;
            default: //If the option was a correct int but a incorrect option
                System.out.println("Incorrect option, please try again."); //advises to user
                operations(Util.getPositiveInt("option")); //requests a correct option again
                return repeat;
        }
    }


}
