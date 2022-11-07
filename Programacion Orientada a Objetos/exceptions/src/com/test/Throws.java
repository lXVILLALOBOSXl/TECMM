package com.test;

import com.thro.UseThrows;

import java.io.IOException;

public class Throws {
    public static void main(String[] args) {
        char ch;
        try{
            ch = UseThrows.prompt("Type a letter");
        } catch (java.io.IOException exc) {
            System.out.println("In and out exception");
            ch = 'X';
        }
    }
}
