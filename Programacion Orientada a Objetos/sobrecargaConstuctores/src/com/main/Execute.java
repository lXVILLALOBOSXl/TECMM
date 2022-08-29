package com.main;

import com.others.Date;

import java.util.Scanner;

public class Execute {
    public static void main(String[] args) {

        Date date = new Date();
        int day, month, year;

        Scanner reader = new Scanner(System.in);
        System.out.println("Type the day: ");
        day = reader.nextInt();;
        System.out.println("Type the month: ");
        month = reader.nextInt();;
        System.out.println("Type the year: ");
        year = reader.nextInt();;

        Date date2 = new Date(day, month, year);

        System.out.println("Default date: " + date.toString());
        System.out.println("Date 2: " + date2.toString());

    }
}
