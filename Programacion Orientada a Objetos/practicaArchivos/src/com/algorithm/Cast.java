package com.algorithm;

import java.util.ArrayList;

public class Cast {
    /**
     * Algortihm to change numbers list to count number asterisk
     * @param numbers
     * @return
     */
    public static ArrayList<String> intToAsterisks(ArrayList<Integer> numbers){
        ArrayList<String> asterisks = new ArrayList<>();
        String line = "";
        for (Integer number : numbers) { //For each number
            for (int i = 0; i < number; i++) { //It has to concat the same asterisk's number
                line += "*";
            }
            asterisks.add(line);
            line = "";
        }
        return asterisks;
    }
}
