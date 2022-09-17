import java.util.ArrayList;

public class TestProbabilidadYEstadistica {
    public static void main(String[] args) {
        do {
            menu(); //Print menu
        }while (operations(Util.getIntNumber("option"))); //If option isn't exit*/

    }

    /**
     * Prints all kind of options
     */
    private static void menu(){
        System.out.println("\nWelcome to Probability and Statics program! \n" +
                "1) Arithmetic Average\n" +
                "2) Mode\n" +
                "3) Median\n" +
                "4) Range\n" +
                "5) Variance\n" +
                "6) Standart deviation\n" +
                "7) Variation coefficient\n" +
                "8) Stem and leaf diagram\n" +
                "9) Frecuency distribuition table\n" +
                "10) All of the above options\n" +
                "11) Combination\n" +
                "12) Permutation\n" +
                "13) Binomial distrubution\n" +
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
            case 1:
                System.out.println("Arithmetic Average: " + ProbabilityAndStatics.arithmeticAverage(fillNumbersList()));
                return repeat;
            case 2:
                System.out.println("mode: " + ProbabilityAndStatics.mode(fillNumbersList()));
                return repeat;
            case 3:
                System.out.println("median: " + ProbabilityAndStatics.median(fillNumbersList()));
                return repeat;
            case 4:
                System.out.println("range: " + ProbabilityAndStatics.range(fillNumbersList()));
                return repeat;
            case 5:
                System.out.println("variance: " + ProbabilityAndStatics.variance(fillNumbersList()));
                return repeat;
            case 6:
                System.out.println("standard deviation: " + ProbabilityAndStatics.standardDeviation(fillNumbersList()));
                return repeat;
            case 7:
                System.out.println("variation coefficient: " + ProbabilityAndStatics.variationCoefficient(fillNumbersList()));
                return repeat;
            case 8:
                System.out.println(ProbabilityAndStatics.stemAndLeaf(fillNumbersList()));
                return repeat;
            case 9:
                System.out.println(ProbabilityAndStatics.frecuencyDistributionTable(fillNumbersList(),Util.getIntNumber("class number")));
                return repeat;
            case 10:
                ArrayList<Double> numbersList = fillNumbersList();
                System.out.println("Arithmetic Average: " + ProbabilityAndStatics.arithmeticAverage(numbersList));
                System.out.println("mode: " + ProbabilityAndStatics.mode(numbersList));
                System.out.println("median: " + ProbabilityAndStatics.median(numbersList));
                System.out.println("range: " + ProbabilityAndStatics.range(numbersList));
                System.out.println("variance: " + ProbabilityAndStatics.variance(numbersList));
                System.out.println("standard deviation: " + ProbabilityAndStatics.standardDeviation(numbersList));
                System.out.println("variation coefficient: " + ProbabilityAndStatics.variationCoefficient(numbersList));
                System.out.println(ProbabilityAndStatics.stemAndLeaf(numbersList));
                System.out.println(ProbabilityAndStatics.frecuencyDistributionTable(numbersList,Util.getIntNumber("class number")));
                return repeat;
            case 11:
                System.out.println("combination: " + ProbabilityAndStatics.combination(Util.getDoubleNumber("n"),Util.getDoubleNumber("r")) + " units");
                return repeat;
            case 12:
                System.out.println("permutation: " + ProbabilityAndStatics.permutation(Util.getDoubleNumber("n"),Util.getDoubleNumber("r")) + " units");
                return repeat;
            case 13:
                System.out.println("binomial distribuition: ");
                double n = Util.getDoubleNumber("n"), p = Util.getDoubleNumber("p"), q = Util.getDoubleNumber("q");
                ArrayList<Double> arrayList = ProbabilityAndStatics.binomialDistribuition(n,p,q);
                for (int P = 0; P < n; P++){
                    System.out.println("P" + (P+1) + ": " + arrayList.get(P) + " units");
                }
                return repeat;
            case 0: //Exit
                System.out.println("Bye!");
                return !repeat;
            default: //If the option was a correct int but a incorrect option
                System.out.println("Incorrect option, please try again."); //advises to user
                operations(Util.getIntNumber("option")); //requests a correct option again
                return repeat;
        }
    }

    private static ArrayList<Double> fillNumbersList(){
        ArrayList<Double> arrayList = new ArrayList<Double>();
        int n = 0;
        String input;
        boolean incorrectInput = false;
        double doubleInput = Util.getDoubleNumber("number " + n);
        do {
            arrayList.add(doubleInput);
            System.out.print("Enter q to quit, or ");
            input = Util.getInput("number " + (++n));
            if(input.equals("q")|| input.equals("Q")){
                break;
            }
            do {
                try { //If the input recorded isn't a double
                    doubleInput = Double.parseDouble(input);
                } catch (Exception ex) { //Warn the user that it input isn't correct input
                    System.out.println("Incorrect input, please try again. ");
                    incorrectInput = true;
                }
            }while (incorrectInput); //If the input isn't correct, input again
        }while (input != "q");
        return arrayList;
    }


}
