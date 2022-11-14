package com;

import java.io.*;

public class FileWriteExample {
    public static void main(String[] args) {
        File file = new File("././example.txt");
        try{
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (int i = 1; i <= 20; i++) {
              printWriter.println(i);
            }
            fileWriter.close();
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
