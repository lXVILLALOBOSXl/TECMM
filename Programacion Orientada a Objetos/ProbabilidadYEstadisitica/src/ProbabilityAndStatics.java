import java.util.*;

public final class ProbabilityAndStatics {

    private ProbabilityAndStatics() { }

    //util

    /**
     * Sort any kind of numbers list from lower to Higher
     * @param numbersList
     */
    private static void sort(ArrayList<Double> numbersList){
        Collections.sort(numbersList);
    }

    /**
     * Sums all number list content
     * @param numbersList
     * @return number list sum
     */
    private static double sum(ArrayList<Double> numbersList){
        double sum = 0;
        for (double number:numbersList) {
            sum += number;
        }
        return sum;
    }

    private static int classNumber(ArrayList<Double> numbersList){
        //Only get the int part and round if it has any decimal to next int, 7.0001 = 8
        return (int)Math.ceil(numbersList.size()/10.0); //Formula
    }

    private static int widhtColumn(ArrayList<Double> numbersList){
        //Only get the int part and round if it has any decimal 2.49 = 2 and 2.5 = 3
        return (int)Math.round(ProbabilityAndStatics.range(numbersList) / ProbabilityAndStatics.classNumber(numbersList)); //formula
    }

    private static double factorial(double n) {
        double fact = 1d;
        for (double i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    //Central tendency measures

    public static double arithmeticAverage(ArrayList<Double> numbersList){
        return sum(numbersList) / numbersList.size(); //formula
    }


    public static double mode(ArrayList<Double> numbersList){
        int maxCount = 0;
        double mode = 0;

        for(int i = 0; i < numbersList.size(); ++i){ //The static number to compair
            int count = 0;
            for (int j = 0; j < numbersList.size(); ++j){ //The number could be the same
                if(numbersList.get(j).equals(numbersList.get(i))){ //Are equals?
                    ++count; //Coincidence
                }
                if (count > maxCount) { //If it had more coincidences than the last max
                    maxCount = count; //The new max are the new coincidences
                    mode = numbersList.get(i); //Mode is the static number comparision
                }
            }
        }
        return mode;
    }

    public static double median(ArrayList<Double> numbersList){
        ProbabilityAndStatics.sort(numbersList);

        if(numbersList.size() %2 == 0 ){ //Is number size pair?
            //arithmetic average between the 2 median numbers
            return (ProbabilityAndStatics.arithmeticAverage(new ArrayList<Double>(
                Arrays.asList(
                      numbersList.get(numbersList.size()/2),
                      numbersList.get((numbersList.size()/2)-1)
                )
            )));
        }
        return numbersList.get(numbersList.size()/2);
    }

    //Dispersion Measures

    public static double range(ArrayList<Double> numbersList){
        ProbabilityAndStatics.sort(numbersList);
        //Sorted list the higher less the lower
        return numbersList.get(numbersList.size()-1) - numbersList.get(0); //Formula
    }

    public static double variance(ArrayList<Double> numbersList){
        double arithmeticAverage = ProbabilityAndStatics.arithmeticAverage(numbersList);
        double numerator = 0;
        for (int i = 0; i < numbersList.size(); ++i){
            numerator += Math.pow((numbersList.get(i)-arithmeticAverage),2); //Formula
        }
        return numerator / (numbersList.size() - 1);
    }

    public static double standardDeviation(ArrayList<Double> numbersList){
        return Math.sqrt(variance(numbersList)); //Formula
    }

    public static double variationCoefficient(ArrayList<Double> numbersList){
        return (standardDeviation(numbersList)/ProbabilityAndStatics.arithmeticAverage(numbersList)) * 100; //Formula
    }

    //Ordened classification

    public static String stemAndLeaf(ArrayList<Double> numbersList){
        ProbabilityAndStatics.sort(numbersList);
        String diagram = "\n";
        int firstIntPart  = numbersList.get(0).intValue();
        int secondIntPart;
        diagram += firstIntPart;
        //Moves into the list numbers
        for(int i = 0; i < numbersList.size(); ++i){
            secondIntPart = numbersList.get(i).intValue();
            if(secondIntPart == firstIntPart){ //If 2 numbers has the same int part
                //Only puts the actual int decimal part
                diagram += "\t" + String.format( "%.0f",(numbersList.get(i) - firstIntPart)*100);
                continue;
            }
            diagram += "\n" + secondIntPart; //Another row if not are the same int part
            //Put its decimals
            diagram += "\t" + String.format( "%.0f",(numbersList.get(i) - secondIntPart)*100);
            //To the next compairsons
            firstIntPart = secondIntPart;
        }
        return diagram;
    }


    public static String frecuencyDistributionTable(ArrayList<Double> numbersList){
        ProbabilityAndStatics.sort(numbersList);
        double widhtColumn = ProbabilityAndStatics.widhtColumn(numbersList);
        int index = 0, observationNumber, classNumber = ProbabilityAndStatics.classNumber(numbersList);
        double toNumber, observationNumberD;
        String table = "\nColumn\tWidht Column\tObservation Number\tPercentage\n";

        //If there aren't less than 11 data
        while (widhtColumn < 1){
                //Only 1 row
                table += 1 + "\t\t" + numbersList.get(0) + " to " + numbersList.get(numbersList.size()-1) + "\t\t\t" + numbersList.size() + "\t\t\t\t" + "100%\n";
                return table;
        }

        //Make the rows
        for (int i = 0; i < classNumber; ++i){

            table += "\t" + (i+1) + "\t" + (numbersList.get(index) + " to " );
            toNumber = numbersList.get(index) + widhtColumn;
            observationNumber = 0;

            //Moves into the list number
            for (int k = index; k < numbersList.size(); ++k) {
                //If is any number into the range
                if (numbersList.get(k) <= toNumber) {
                    observationNumber++;
                    //If the actual number is exactly the final widht column number
                    if(numbersList.get(k) == toNumber){
                        table += toNumber;
                        //Sums to no repeat the number if is the last, (actual + 1) will be the first widht column number
                        index = ++k;
                        break;
                    }
                }else{ //If the number next to the first widht column number is more than widht column
                    //The final widht column will be the first
                    toNumber = numbersList.get(k - 1);
                    table += toNumber;
                    index = k;
                    break;
                }
                //If the number isn't between into the las widht column but is the last, it will be the end widht column
                if(k == numbersList.size()-1){
                    toNumber = numbersList.get(k);
                    table += toNumber;
                }
            }
            //Put the percentages
            observationNumberD = observationNumber;
            table += "\t\t\t" + observationNumber + "\t\t\t\t" +String.format( "%.2f", ((observationNumberD*100)/numbersList.size())) + "%\n";
        }
        return table;
    }


    //Probability distribution

    public static double combination(double n, double r){
        return factorial(n)/(factorial(r)*factorial(n-r)); //Formula
    }

    public static double permutation(double n, double r){
        return factorial(n)/factorial(n-r); //Formula
    }

    //Binomial distribution

    public static ArrayList<Double> binomialDistribuition(double n, double p, double q){
        ArrayList<Double> list = new ArrayList<Double>();
        for (double i = 1d; i <= n; i++){
            list.add((combination(n,i))*Math.pow(p/100d,i)*Math.pow(q/100d,n-i)); //Formula
        }
        return list; // Possibles occurences
    }

    @Override
    public String toString() {
        return "";
    }
}
