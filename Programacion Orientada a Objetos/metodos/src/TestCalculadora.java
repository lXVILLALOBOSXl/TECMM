import java.util.Scanner;

/**
 * Luis Adrian Villalobos Rivera 2ISC 220120379 P1 TM
 * Main class to test Calculadora class and run our main program
 */
public class TestCalculadora {

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
        Calculadora calculadora;
        boolean repeat = true; //When the requested function finalizes, the option menu will be printed again

        switch (option){
            case 1: //sum
                //asks for the numbers that the operation will be done and creates an instance with that numbers to use its methods
                calculadora = new Calculadora(getNumber("number 1"), getNumber("number 2"));
                //ask and print the requested function
                System.out.println("Sum of " + calculadora.getN1() + " + " + calculadora.getN2() + " = " + calculadora.add());
                return repeat;
            case 2: //subtraction
                calculadora = new Calculadora(getNumber("number 1"), getNumber("number 2"));
                System.out.println("Subtraction of " + calculadora.getN1() + " - " + calculadora.getN2() + " = " + calculadora.subtract());
                return repeat;
            case 3: //multiplication
                calculadora = new Calculadora(getNumber("number 1"), getNumber("number 2"));
                System.out.println("Multiplication of " + calculadora.getN1() + " * " + calculadora.getN2() + " = " + calculadora.multiply());
                return repeat;
            case 4: //division
                calculadora = new Calculadora(getNumber("number 1"), getNumber("number 2"));
                System.out.println("Division of " + calculadora.getN1() + " / " + calculadora.getN2() + " = " + calculadora.split());
                return repeat;
            case 5: //factorial
                calculadora = new Calculadora(getNumber("number 1"));

                System.out.println("Factorial of " + calculadora.getN1() + " is = " + calculadora.factorial());
                return repeat;
            case 6: //pair
                calculadora = new Calculadora(getNumber("number"));
                System.out.println("Is " + calculadora.getN1() + " pair?: " + calculadora.isPair());
                return repeat;
            case 7: //perfect number
                calculadora = new Calculadora(getNumber("number"));
                System.out.println("Is " + calculadora.getN1() + " perfect number?: " + calculadora.isPerfectNumber());
                return repeat;
            case 8: //friends number
                calculadora = new Calculadora(getNumber("number 1"), getNumber("number 2"));
                System.out.println("Are " + calculadora.getN1() + " and " + calculadora.getN2() + " friends numbers?: " + calculadora.areFriendsNumbers());
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
