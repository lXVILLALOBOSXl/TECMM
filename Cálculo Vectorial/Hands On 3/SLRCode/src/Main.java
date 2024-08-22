import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        DataSet dataSet = new DataSet(
                new double[]{ 58, 58, 52, 58, 57, 52, 55, 53, 49, 54,
                        59, 56, 53, 58, 57, 58, 56, 51, 50, 59,
                        59, 59, 55, 50, 55, 52, 53, 54, 61, 56,
                        55, 60, 57, 56, 61, 58, 53, 57, 57, 55,
                        60, 51, 52, 56, 55, 57, 58, 57, 51, 59},
                new double[]{39, 38, 37, 39, 38, 35, 37, 36, 35, 40,
                        40, 36, 38, 39, 42, 42, 36, 36, 35, 41,
                        42, 38, 37, 35, 40, 36, 35, 39, 41, 37,
                        35, 41, 39, 41, 42, 42, 36, 37, 37, 39,
                        42, 35, 36, 41, 41, 41, 39, 39, 35, 39}
        );

        SLR slr = new SLR(dataSet);

        System.out.println(dataSet);
        System.out.println("b0: " + slr.getB0());
        System.out.println("b1: " + slr.getB1());
        System.out.println("Equation: " + slr.getEquation());
        System.out.print("Invest to predict: ");
        double n = s.nextDouble();
        System.out.println("Predict for " + n + ": " + slr.predict(n));
    }
}
