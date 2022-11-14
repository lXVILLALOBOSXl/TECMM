package com.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Write {
    public static void write(String filename, ArrayList<String> data){
        File file = new File(filename);
        try{
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (String s : data) {
                printWriter.println(s);
            }
            fileWriter.close();
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
