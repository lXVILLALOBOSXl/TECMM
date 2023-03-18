package com.test;

import com.data.DataSet;
import com.maths.MultipleLinearRegresion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        DataSet dsSixSigma = new DataSet(
                new double[][]{ {1,108},
                                {1,115},
                                {1,106},
                                {1,97},
                                {1,95},
                                {1,91},
                                {1,97},
                                {1,83},
                                {1,83},
                                {1,78},
                                {1,54},
                                {1,67},
                                {1,56},
                                {1,53},
                                {1,61},
                                {1,115},
                                {1,81},
                                {1,78},
                                {1,30},
                                {1,45},
                                {1,99},
                                {1,32},
                                {1,25},
                                {1,28},
                                {1,90},
                                {1,89}, },
                new double[]{95,96,95,97,93,94,95,93,92,86,73,80,65,69,77,96,87,89,60,63,95,61,55,56,94,93}
        );

        MultipleLinearRegresion mlr = new MultipleLinearRegresion(dsSixSigma);
        System.out.println(mlr.equation());
        System.out.println("Number to predict: ");
        int toPredict = s.nextInt();
        System.out.println("Prediction for " +  toPredict + ": " + mlr.predict(new double[]{toPredict}));
    }
}
