import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        /*DataSet dsSixSigma = new DataSet(
                new double[]{-3,-2,-1,0,1,2,3},
                new double[]{7.5,3,0.5,1,3,6,14}
        );*/
        /*DataSet dsAIDS = new DataSet(
                new double[]{2004,2005,2006,2007,2008,2009,2010,2011,2012,2013},
                new double[]{8804,17512,25102,30744,35661,38945,40118,41568,39995,37832}
        );*/

        /*DataSet dsSixSigma = new DataSet(
                new double[]{108,115,106,97,95,91,97,83,83,78,54,67,56,53,61,115,81,78,30,45,99,32,25,28,90,89},
                new double[]{95,96,95,97,93,94,95,93,92,86,73,80,65,69,77,96,87,89,60,63,95,61,55,56,94,93}
        );*/

        DataSet dsSixSigma = new DataSet(
                new double[]{3,5,6,8,10,12,15},
                new double[]{3.45,6.9,8.79,12.91,17.48,22.49,30.85,}
        );


        /*QLR qlr = new QLR(dsVarsity);

        System.out.println(dsVarsity);
        System.out.println("b0: " + qlr.getB0());
        System.out.println("b1: " + qlr.getB1());
        System.out.println("b2: " + qlr.getB2());
        System.out.println("Equation: " + qlr.getEquation());
        System.out.print("Number to predict: ");
        double n = s.nextDouble();
        System.out.println("Predict for " + n + ": " + qlr.predict(n));
        System.out.println("----------------------------------------");


        qlr = new QLR(dsAIDS);

        System.out.println(dsAIDS);
        System.out.println("b0: " + qlr.getB0());
        System.out.println("b1: " + qlr.getB1());
        System.out.println("b2: " + qlr.getB2());
        System.out.println("Equation: " + qlr.getEquation());
        System.out.print("Year to predict: ");
        n = s.nextDouble();
        System.out.println("Predict for " + n + ": " + qlr.predict(n));
        System.out.println("----------------------------------------");*/

        QLR qlr = new QLR(dsSixSigma);
        System.out.println(dsSixSigma);
        System.out.println("b0: " + qlr.getB0());
        System.out.println("b1: " + qlr.getB1());
        System.out.println("b2: " + qlr.getB2());

        System.out.println("Equation: " + qlr.getEquation());
        System.out.print("Batch to predict: ");
        double n = s.nextDouble();
        System.out.println("Predict for " + n + ": " + qlr.predict(n));
        System.out.println("----------------------------------------");
    }
}
