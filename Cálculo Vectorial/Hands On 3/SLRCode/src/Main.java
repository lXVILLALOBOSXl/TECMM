import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        DataSet dataSet = new DataSet(
                new double[]{1,2,3,4,5,6,7,8,9,10},
                new double[]{3,6,9,12,15,18,21,24,27,30}
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
