package com.dao;

import com.exception.DataAccessException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Manipulate the files
 */
public class DataAccess implements IDataAccess{

    /**
     * Verify if a file exist
     * @param filePath
     * @return does file exist?
     */
    @Override
    public boolean exist(String filePath){
        File file = new File(filePath);
        return file.exists();
    }

    /**
     * Cast JSON file to Object List
     * @param filePath
     * @return JSON file info as an Object List
     * @throws DataAccessException
     */
    @Override
    public List<Object> unserialize(String filePath, TypeToken typeToken) throws DataAccessException {
        List<Object> objects = null;

        //If the file doesn't exist it makes it to avoid write on a file that doesn't exist
        if(!exist(filePath)){
            create(filePath);
        }

        //UNSERIALIZE JSON TO LIST OBJECT
        Gson gson = new GsonBuilder().create();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            //Pass the JSON file content into a string
            StringBuilder jsonData = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null) {
                jsonData.append(line);
            }
            //Convert string on a JSON format to a list object
            objects = gson.fromJson(jsonData.toString(), typeToken.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return objects;
    }


    /**
     * Serialize and append new object into a JSON file
     * @param object
     * @param filePath
     * @throws DataAccessException
     */
    public void serialize(Object object, TypeToken typeToken,String filePath) throws DataAccessException {
        //SERIALIZE LIST OBJECT TO JSON
        Gson gson = new GsonBuilder().create();

        //it checks if already exist JSON info, not JSON File
        List<Object> objects = unserialize(filePath,typeToken);

        //"Unserialize" to get the info in "Java format" to manipulate it
        //and next "Serialize again" after the info was modified by Java

        try(FileWriter writer = new FileWriter(filePath)) {
            //If already exist info, it has to append
            if (objects != null) {
                //Adds new person
                objects.add(object);
                //Serialize new info
                String json = gson.toJson(objects, typeToken.getType());
                writer.append(json);
            }else{
                //it creates new List Object info
                objects = new ArrayList<>();
                objects.add(object);
                String json = gson.toJson(objects,typeToken.getType());
                writer.append(json);
            }
        }catch (IOException ex) {
            System.err.format("An IO Exception was occurred: %s%n", ex);
            System.exit(-1);
        }
    }

    /**
     * Serializes info that already exist, used  it like in a update
     * @param objects
     * @param filePath
     * @throws DataAccessException
     */
    @Override
    public void serialize(List<Object> objects, TypeToken typeToken, String filePath) throws DataAccessException {
        Gson gson = new GsonBuilder().create();
        try(FileWriter writer = new FileWriter(filePath)) {
            if (objects != null) {
                String json = gson.toJson(objects,typeToken.getType());
                writer.append(json);
            }else{
                throw new DataAccessException("people was null");
            }
        }catch (IOException ex) {
            System.err.format("An IO Exception was occurred: %s%n", ex);
            System.exit(-1);
        }
    }

    /**
     * Create a file
     * @param filePath
     * @throws DataAccessException
     */
    @Override
    public void create(String filePath) throws DataAccessException {
        File file = new File(filePath);
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(file));
            printWriter.close();
            System.out.println("File has been created");
        } catch (IOException e) {
            e.printStackTrace();
            throw new DataAccessException("Error has occurred creating file: " + e.getMessage());
        }
    }

    /**
     * Delete a file
     * @param filePath
     */
    @Override
    public void delete(String filePath){
        File file = new File(filePath);
        if (file.exists()){
            file.delete();
        }
        System.out.println("The file: " + filePath + " has been deleted");
    }
}
