package com.thro;

public class UseThrows {
    public static char prompt(String str) throws java.io.IOException{
        System.out.println(str + ": ");
        return (char) System.in.read();
    }
}
