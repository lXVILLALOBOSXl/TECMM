package com.dto;

import com.exception.DateException;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year){
        try {
            //Params to make a valid date
            if((day < 1 || day > 31) || (month < 1 || month > 12) || (year < 1900 || year > 2022) || (month == 2 && day > 29)) {
                throw new DateException("Invalid Date");
            }
            this.day = day;
            this.month = month;
            this.year = year;
        } catch (DateException e) {
            e.printStackTrace();
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
