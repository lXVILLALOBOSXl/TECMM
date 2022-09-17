import java.util.*;

public final class ProbabilityAndStatics {

    private ProbabilityAndStatics() { }

    //util

    private static void sort(ArrayList<Double> numbersList){
        Collections.sort(numbersList);
    }

    private static double sum(ArrayList<Double> numbersList){
        double sum = 0;
        for (double number:numbersList) {
            sum += number;
        }
        return sum;
    }

    private static int widhtColumn(ArrayList<Double> numbersList, int classNumber){
        return (int)Math.round(ProbabilityAndStatics.range(numbersList) / classNumber);
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
        return sum(numbersList) / numbersList.size();
    }

    public static double mode(ArrayList<Double> numbersList){
        int maxCount = 0;
        double mode = 0;

        for(int i = 0; i < numbersList.size(); ++i){
            int count = 0;
            for (int j = 0; j < numbersList.size(); ++j){
                if(numbersList.get(j) == numbersList.get(i)){
                    ++count;
                }

                if (count > maxCount) {
                    maxCount = count;
                    mode = numbersList.get(i);
                }
            }
        }
        return mode;
    }

    public static double median(ArrayList<Double> numbersList){
        ProbabilityAndStatics.sort(numbersList);
        if(numbersList.size() %2 == 0 ){
            //arithmetic average between the 2 median numbers
            return (ProbabilityAndStatics.arithmeticAverage(new ArrayList<Double>(
                Arrays.asList(
                      numbersList.get(numbersList.size()/2),
                      numbersList.get((numbersList.size()/2)-1)
                )
            )));
        }
        return numbersList.size()/2;
    }

    //Dispersion Measures

    public static double range(ArrayList<Double> numbersList){
        ProbabilityAndStatics.sort(numbersList);
        return numbersList.get(numbersList.size()-1) - numbersList.get(0);
    }

    public static double variance(ArrayList<Double> numbersList){
        double arithmeticAverage = ProbabilityAndStatics.arithmeticAverage(numbersList);
        double numerator = 0;
        for (int i = 0; i < numbersList.size(); ++i){
            numerator += Math.pow((numbersList.get(i)-arithmeticAverage),2);
        }
        return numerator / (numbersList.size() - 1);
    }

    public static double standardDeviation(ArrayList<Double> numbersList){
        return Math.sqrt(variance(numbersList));
    }

    public static double variationCoefficient(ArrayList<Double> numbersList){
        return (standardDeviation(numbersList)/ProbabilityAndStatics.arithmeticAverage(numbersList)) * 100;
    }

    //Ordened classification

    public static String stemAndLeaf(ArrayList<Double> numbersList){
        ProbabilityAndStatics.sort(numbersList);
        String diagram = "\n";
        int firstIntPart  = numbersList.get(0).intValue(), secondIntPart;
        diagram += firstIntPart;
        for(int i = 0; i < numbersList.size(); ++i){
            secondIntPart = numbersList.get(i).intValue();
            if(secondIntPart == firstIntPart){
                diagram += "\t" + String.format( "%.0f",(numbersList.get(i) - firstIntPart)*100);
                continue;
            }
            diagram += "\n" + secondIntPart;
            diagram += "\t" + String.format( "%.0f",(numbersList.get(i) - secondIntPart)*100);
            firstIntPart = secondIntPart;
        }
        return diagram;
    }


    public static String frecuencyDistributionTable(ArrayList<Double> numbersList, int classNumber){
        ProbabilityAndStatics.sort(numbersList);
        double widhtColumn = ProbabilityAndStatics.widhtColumn(numbersList,classNumber);
        int index = 0, observationNumber;
        double toNumber, observationNumberD;
        String table = "\nColumn\tWidht Column\tObservation Number\tPercentage\n";

        while (widhtColumn < 1){
            if(ProbabilityAndStatics.range(numbersList) == 0){
                table += 1 + "\t\t";
                table += numbersList.get(0) + " to " + numbersList.get(numbersList.size()-1) + "\t\t\t";
                table += numbersList.size() + "\t\t\t\t";
                table += "100%\n";
                return table;
            }
            System.out.println("Incorrect class");
            classNumber = Util.getIntNumber("class");
            widhtColumn = ProbabilityAndStatics.widhtColumn(numbersList,classNumber);
        }

        for (int i = 0; i < classNumber; ++i){
            table += "\t" + (i+1);
            table += "\t" + (numbersList.get(index) + " to " );

            if(numbersList.get(index) == numbersList.get(numbersList.size()-1)){
                toNumber = numbersList.get(index);
                table += toNumber;
                observationNumberD = 1;
                table += "\t\t\t" + 1 + "\t\t\t\t" +String.format( "%.2f", ((observationNumberD*100)/numbersList.size())) + "%\n";
                break;
            }else{
                toNumber = numbersList.get(index) + widhtColumn;
            }
            observationNumber = 0;
            for (int k = index; k < numbersList.size(); ++k) {
                if (numbersList.get(k) <= toNumber) {
                    observationNumber++;
                    if(numbersList.get(k) == toNumber){
                        table += toNumber;
                        index = ++k;
                        break;
                    }
                }else{
                    toNumber = numbersList.get(k - 1);
                    table += toNumber;
                    index = k;
                    break;
                }
                if(k == numbersList.size()-1){
                    toNumber = numbersList.get(k - 1);
                    table += toNumber;
                }
            }
            observationNumberD = observationNumber;
            table += "\t\t\t" + observationNumber + "\t\t\t\t" +String.format( "%.2f", ((observationNumberD*100)/numbersList.size())) + "%\n";
            if(index == numbersList.size()){
                break;
            }
        }
        return table;
    }


    //Probability distribution

    public static double combination(double n, double r){
        return factorial(n)/(factorial(r)*factorial(n-r));
    }

    public static double permutation(double n, double r){
        return factorial(n)/factorial(n-r);
    }

    //Binomial distribution

    public static ArrayList<Double> binomialDistribuition(double n, double p, double q){
        ArrayList<Double> list = new ArrayList<Double>();
        for (double i = 1d; i <= n; i++){
            list.add((combination(n,i))*Math.pow(p/100d,i)*Math.pow(q/100d,n-i));
        }
        return list;
    }

    @Override
    public String toString() {
        return "";
    }
}
