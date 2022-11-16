package com.dao;

import com.dto.Person;
import com.exception.DataAccessException;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Releated about all File Transactions
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
    public List<Person> unserialize(String filePath) throws DataAccessException {
        List<Person> people = null;

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
            people = gson.fromJson(jsonData.toString(), new TypeToken<List<Person>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return people;
    }


    /**
     * Serialize and append new object into a JSON file
     * @param person
     * @param filePath
     * @param append
     * @throws DataAccessException
     */
    @Override
    public void serialize(Person person, String filePath, boolean append) throws DataAccessException {
        //SERIALIZE LIST OBJECT TO JSON
        Gson gson = new GsonBuilder().create();

        //it checks if already exist JSON info, not JSON File
        List<Person> people = unserialize(filePath);

        //"Unserialize" to get the info in "Java format" to manipulate it
        //and next "Serialize again" after the info was modified by Java

        try(FileWriter writer = new FileWriter(filePath)) {
            //If already exist info, it has to append
            if (people != null) {
                //Adds new person
                people.add(person);
                //Serialize new info
                String json = gson.toJson(people, new TypeToken<List<Person>>() {}.getType());
                writer.append(json);
            }else{
                //it creates new List Object info
                people = new ArrayList<>();
                people.add(person);
                String json = gson.toJson(people, new TypeToken<List<Person>>() {}.getType());
                writer.append(json);
            }
        }catch (IOException ex) {
            System.err.format("An IO Exception was occurred: %s%n", ex);
            System.exit(-1);
        }
    }

    /**
     * Serializes info that already exist, used  it like in a update
     * @param people
     * @param filePath
     * @param append
     * @throws DataAccessException
     */
    @Override
    public void serialize(List<Person> people, String filePath, boolean append) throws DataAccessException {
        Gson gson = new GsonBuilder().create();
        try(FileWriter writer = new FileWriter(filePath)) {
            if (people != null) {
                String json = gson.toJson(people, new TypeToken<List<Person>>() {}.getType());
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
