package com.test;

import com.data.DataSet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        DataSet dsSixSigma = new DataSet(
                new double[]{108,115,106,97,95,91,97,83,83,78,54,67,56,53,61,115,81,78,30,45,99,32,25,28,90,89},
                new double[]{95,96,95,97,93,94,95,93,92,86,73,80,65,69,77,96,87,89,60,63,95,61,55,56,94,93}
        );

        //MulltipleLR mlr = new MulltipleLR(dsSixSigma);
    }
}
