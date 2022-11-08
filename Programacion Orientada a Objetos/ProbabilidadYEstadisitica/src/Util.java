import java.util.Scanner;

public class Util {
    /**
     * Asks for the int inputs and analyzes if is a correct input
     * @param message Kind of input, for example: number 1, number 2, option
     * @return recorded entry
     */
    public static int getIntNumber(String message){
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
     * Asks for the double inputs and analyzes if is a correct input
     * @param message Kind of input, for example: number 1, number 2, option
     * @return recorded entry
     */
    public static double getDoubleNumber(String message){
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
    public static String  getInput(String message){
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.printf("Type a correct " + message + ": ");
        input = scanner.nextLine();
        return input;
    }

}
