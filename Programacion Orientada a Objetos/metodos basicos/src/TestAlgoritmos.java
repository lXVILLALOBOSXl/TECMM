// Luis Adrian Villalobos Rivera 220120379 2ISC
import java.util.Scanner;

/**
 *
 */
public class TestAlgoritmos {

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
                "1) Triangle area\n" +
                "2) Circle srea\n" +
                "3) Grade average\n" +
                "4) ºC to ºF\n" +
                "5) Calculate interest\n" +
                "6) Job payment\n" +
                "7) Extra hours payment\n" +
                "8) Minutes to days, hours and minutes\n" +
                "9) Conversion system\n" +
                "10) Gas calculator\n" +
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
     * Asks and prints for the requested function
     * @param option function that the user want to use
     * @return if the menu will be printed again
     */
    private static boolean operations(int option){
        boolean repeat = true; //When the requested function finalizes, the option menu will be printed again

        switch (option){
            case 1: //sum
                //ask and print the requested function
                System.out.println("Triangle area " + " = " + Algoritmos.triangleArea(getNonNegativeNumber("base"), getNonNegativeNumber("height")));
                return repeat;
            case 2: //Circle area
                System.out.println("Circle area " + " = " + Algoritmos.circleArea(getNonNegativeNumber("radio")));
                return repeat;
            case 3: //Grade average
                System.out.println("Grade average " + " = " + Algoritmos.gradeAverage((int)getNonNegativeNumber("number of subjects")));
                return repeat;
            case 4: //C to F
                System.out.println("Cº " + " = " + Algoritmos.celsiusToFarenheit(getNumber("ºC")) + " ºF ");
                return repeat;
            case 5: //Calculate interest
                System.out.println("Interest " + " = " + Algoritmos.calculateInterest(getNonNegativeNumber("amount")));
                return repeat;
            case 6: //Calculate salary
                System.out.println("Salary " + " = " + Algoritmos.jobPayment(getNonNegativeNumber("work hours"), getNonNegativeNumber("salary per hour"), getNonNegativeNumber("taxes percentage")));
                return repeat;
            case 7: //Calculate extra hours
                System.out.println("Salary " + " = " + Algoritmos.extraHoursPayment(getNonNegativeNumber("work hours"), getNonNegativeNumber("salary per hour")));
                return repeat;
            case 8: //Change minutes to days, hours and minutes
                System.out.println(Algoritmos.getTime(getNonNegativeNumber("minutes")));
                return repeat;
            case 9: //Conversions distances system
                double meters = getNonNegativeNumber("meters");
                System.out.println("meters = " + Algoritmos.metersToCm(meters) + " cm, " + Algoritmos.metersToKm(meters) + " km, " + Algoritmos.metersToFt(meters) + " feeds, " + Algoritmos.metersToIn(meters) + " in, ");
                return repeat;
            case 10: //Oil Calculator
                //Get all the necessary arguments to work and get clear code
                double drivenKm = getNonNegativeNumber("driven km");
                double oilPricePerLt = getNonNegativeNumber("oil price in EUR per lt");
                double oilExpense = getNonNegativeNumber("oil expense in EUR");
                double hoursTravelTime = getNonNegativeNumber("Hours in travel time");
                double minutesTravelTime = getNonNegativeNumber("Minutes in travel time");
                double litersPurchased = oilExpense / oilPricePerLt;
                //ask and print all the requested function
                System.out.println("oil consume = " + Algoritmos.ltPer100Km(litersPurchased) + " lts, " + Algoritmos.euroPer100Km(oilExpense) + " eur per 100km\n" +
                        "oil consume = " + Algoritmos.ltPerKm(drivenKm, litersPurchased) + " lts, " + Algoritmos.euroPerKm(drivenKm, oilExpense) + " eur per km\n" +
                        "speed = " + Algoritmos.speedCalculatorKH(hoursTravelTime,minutesTravelTime,drivenKm) + " km/h, " + Algoritmos.speedCalculatorMS(hoursTravelTime,minutesTravelTime,drivenKm) + " m/s");
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
