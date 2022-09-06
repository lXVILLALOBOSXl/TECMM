//Luis Adrian Villalobos Rivera 220120379 2ISC
import java.util.Scanner;

public class TestCondicionales {
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
        System.out.println("\nWelcome to Calculadora program! \n" +
                "1) Is adult?\n" +
                "2) Life stage\n" +
                "3) Higher number\n" +
                "4) Is zero,negative or positive?\n" +
                "5) Pair or impair?\n" +
                "6) Salary by categorie\n" +
                "7) Can I do my military service?\n" +
                "8) Sale commission\n" +
                "9) Salary increase\n" +
                "10) Math functions\n" +
                "11) Exit\n");
    }

    /**
     * Asks for the inputs and analyzes if is a correct input
     * @param message Kind of input, for example: number 1, number 2, option
     * @return recorded entry
     */
    public static double getNumber(String message){
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
     * Asks for the inputs and analyzes if is a correct possitive input
     * @param message Kind of input, for example: number 1, number 2, option
     * @return recorded possitive inout
     */
    public static double getNonNegativeNumber(String message){
        double number;
        do {
            number = getNumber(message);
            if(number < 0){
                System.out.println("You number can't be negative");
            }
        }while (number < 0);

        return number;
    }

    /**
     * Ask for a text input
     * @param message Kind of input, for example: number 1, number 2, option
     * @return recorded text input
     */
    public static String getText(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Type a correct " + message + ": ");
        String input = scanner.nextLine();
        return input;
    }

    /**
     * Asks and prints for the requested function
     * @param option function that the user want to use
     * @return if the menu will be printed again
     */
    private static boolean operations(int option){
        boolean repeat = true; //When the requested function finalizes, the option menu will be printed again

        switch (option){
            case 1: //Determines if a person is adult
                //ask and print the requested function
                System.out.println("Is adult? " + Condicionales.isAdult((int)getNonNegativeNumber("age")));
                return repeat;
            case 2: //Determines life stage
                System.out.println("Age of life? " + Condicionales.lifeStage((int)getNonNegativeNumber("age")));
                return repeat;
            case 3: //Determines the highest number
                System.out.println("Highest " + " = " + Condicionales.whoIsHighest(getNumber("number 1"),getNumber("number 2"), getNumber("number 3")));
                return repeat;
            case 4: //Determines kind of number
                System.out.println("Your number is: " + Condicionales.kindOfNumber(getNumber("number")));
                return repeat;
            case 5: //Determines if a number is pair
                System.out.println("Is pair? " + Condicionales.isPair(getNumber("number")));
                return repeat;
            case 6: //Calculate salary and its increase
                double salary = getNonNegativeNumber("salary");
                double salaryIncrease = salary * Condicionales.getSalaryIncrease((int)getNonNegativeNumber("categorie"));
                System.out.println("Net salary " + " = " + (salary + salaryIncrease) + ", salary increase = " + salaryIncrease);
                return repeat;
            case 7: //Determines if a person is able to do military service
                System.out.println("Can I do my Military Service? " + Condicionales.canDoMilitaryService((int)getNonNegativeNumber("age"),getText("nacionality"),getText("genre")));
                return repeat;
            case 8: //Commsion of sale amount
                System.out.println("Commision = " + Condicionales.getCommision(getNonNegativeNumber("sale amount")));
                return repeat;
            case 9: //Net salary by categorie
                System.out.println("Net salary = " + Condicionales.salaryIncrease(getText("categorie"),getNonNegativeNumber("salary")));
                return repeat;
            case 10: // Y functions to X
                System.out.println("y = " + Condicionales.mathFunctions(getNumber("number")));
                return repeat;
            case 11: //Exit
                System.out.println("Bye!");
                return !repeat;
            default: //If the option was a correct int but a incorrect option
                System.out.println("Incorrect option, please try again."); //advises to user
                operations((int) getNumber("option")); //requests a correct option again
                return repeat;
        }
    }
}
