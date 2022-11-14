package com.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Read {
    public static ArrayList<Integer> read(String filename){
        ArrayList<Integer> readData = new ArrayList<>();
        File file = new File(filename);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null){
                readData.add(Integer.parseInt(line));
                line = bufferedReader.readLine();
            }
            fileReader.close();
        }catch (IOException e){
            System.out.println(e);
        }
        return readData;
    }
}
