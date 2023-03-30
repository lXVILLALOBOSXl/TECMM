package com.test;

import com.data.DataSet;
import com.maths.MultipleLinearRegresion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        DataSet dsSixSigmaL = new DataSet(
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

        DataSet dsSixSigmaQ = new DataSet(
                new double[][]{
                        {1,108,Math.pow(108,2)},
                        {1,115,Math.pow(115,2)},
                        {1,106,Math.pow(106,2)},
                        {1,97,Math.pow(97,2)},
                        {1,95,Math.pow(95,2)},
                        {1,91,Math.pow(91,2)},
                        {1,97,Math.pow(97,2)},
                        {1,83,Math.pow(83,2)},
                        {1,83,Math.pow(83,2)},
                        {1,78,Math.pow(78,2)},
                        {1,54,Math.pow(54,2)},
                        {1,67,Math.pow(67,2)},
                        {1,56,Math.pow(56,2)},
                        {1,53,Math.pow(53,2)},
                        {1,61,Math.pow(61,2)},
                        {1,115,Math.pow(115,2)},
                        {1,81,Math.pow(81,2)},
                        {1,78,Math.pow(78,2)},
                        {1,30,Math.pow(30,2)},
                        {1,45,Math.pow(45,2)},
                        {1,99,Math.pow(99,2)},
                        {1,32,Math.pow(32,2)},
                        {1,25,Math.pow(25,2)},
                        {1,28,Math.pow(28,2)},
                        {1,90,Math.pow(90,2)},
                        {1,89,Math.pow(89,2)}, },
                new double[]{95,96,95,97,93,94,95,93,92,86,73,80,65,69,77,96,87,89,60,63,95,61,55,56,94,93}
        );

        DataSet dsSixSigmaC = new DataSet(
                new double[][]{
                        {1,108,Math.pow(108,2),Math.pow(108,3)},
                        {1,115,Math.pow(115,2),Math.pow(115,3)},
                        {1,106,Math.pow(106,2),Math.pow(106,3)},
                        {1,97,Math.pow(97,2),Math.pow(97,3)},
                        {1,95,Math.pow(95,2),Math.pow(95,3)},
                        {1,91,Math.pow(91,2),Math.pow(91,3)},
                        {1,97,Math.pow(97,2),Math.pow(97,3)},
                        {1,83,Math.pow(83,2),Math.pow(83,3)},
                        {1,83,Math.pow(83,2),Math.pow(83,3)},
                        {1,78,Math.pow(78,2),Math.pow(78,3)},
                        {1,54,Math.pow(54,2),Math.pow(54,3)},
                        {1,67,Math.pow(67,2),Math.pow(67,3)},
                        {1,56,Math.pow(56,2),Math.pow(56,3)},
                        {1,53,Math.pow(53,2),Math.pow(53,3)},
                        {1,61,Math.pow(61,2),Math.pow(61,3)},
                        {1,115,Math.pow(115,2),Math.pow(115,3)},
                        {1,81,Math.pow(81,2),Math.pow(81,3)},
                        {1,78,Math.pow(78,2),Math.pow(78,3)},
                        {1,30,Math.pow(30,2),Math.pow(30,3)},
                        {1,45,Math.pow(45,2),Math.pow(45,3)},
                        {1,99,Math.pow(99,2),Math.pow(99,3)},
                        {1,32,Math.pow(32,2),Math.pow(32,3)},
                        {1,25,Math.pow(25,2),Math.pow(25,3)},
                        {1,28,Math.pow(28,2),Math.pow(28,3)},
                        {1,90,Math.pow(90,2),Math.pow(90,3)},
                        {1,89,Math.pow(89,2),Math.pow(89,3)}},
                new double[]{95,96,95,97,93,94,95,93,92,86,73,80,65,69,77,96,87,89,60,63,95,61,55,56,94,93}
        );



        MultipleLinearRegresion mlr = new MultipleLinearRegresion(dsSixSigmaL);
        System.out.println(mlr.equation());
        System.out.println("Number to predict: ");
        int toPredict = s.nextInt();
        System.out.println("Prediction for " +  toPredict + ": " + mlr.predict(toPredict));

        mlr = new MultipleLinearRegresion(dsSixSigmaQ);
        System.out.println("\n" + mlr.equation());
        System.out.println("Number to predict: ");
        toPredict = s.nextInt();
        System.out.println("Prediction for " +  toPredict + ": " + mlr.predict(toPredict));

        mlr = new MultipleLinearRegresion(dsSixSigmaC);
        System.out.println("\n" + mlr.equation());
        System.out.println("Number to predict: ");
        toPredict = s.nextInt();
        System.out.println("Prediction for " +  toPredict + ": " + mlr.predict(toPredict));
    }
}
