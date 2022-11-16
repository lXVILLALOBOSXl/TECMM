package com.dao;

import com.dto.Person;
import com.exception.DataAccessException;
import com.util.Util;

import java.util.List;

public class Directory implements ICRUD{
    private static final String FILE_PATH = "././directory.json";
    private final DataAccess data;

    public Directory() {
        this.data = new DataAccess();
    }

    /**
     * Add new person to a JSON File
     * @param name
     * @param lastName
     * @param cellphone
     * @param address
     */
    @Override
    public void create(String name, String lastName, String cellphone, String address) {
        try {
            Person person = new Person(name,lastName,cellphone,address);
            data.serialize(person, FILE_PATH,data.exist(FILE_PATH));
            System.out.println("added");
        }catch (DataAccessException e){
            System.out.println("data access error");
            e.printStackTrace(System.out);
        }
    }

    /**
     * Finds into a JSON file, unserializes to manipulate the info with java
     * @param id
     */
    @Override
    public void find(int id) {
        List<Person> people = null;
        try {
            people = data.unserialize(FILE_PATH);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        if(people != null){
            for (Person person : people) {
               if(person.getId() == id){
                   System.out.println("1 match");
                   System.out.println(person);
                   return;
               }
            }
        }
        System.out.println("no matches");
    }

    /**
     * Update object into a JSON file, unserializes to manipulate the info with java, and next serializes to save the info
     * @param id
     */
    @Override
    public void update(int id) {
        List<Person> people = null;
        try {
            people = data.unserialize(FILE_PATH);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        if(people != null){
            for (Person person : people) {
                if(person.getId() == id){
                    people.add(new Person(id,Util.getInput("name"),Util.getInput("last name"),Util.getInput("cellphone"),Util.getInput("address")));
                    people.remove(person);
                    try {
                        data.serialize(people, FILE_PATH,data.exist(FILE_PATH));
                        System.out.println("updated");
                        return;
                    } catch (DataAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("no matches");
    }

    /**
     * DElete object into a JSON file, unserializes to erase the info with java, and next serializes to save the info
     * @param id
     */
    @Override
    public void delete(int id) {
        List<Person> people = null;
        try {
            people = data.unserialize(FILE_PATH);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        if(people != null){
            for (Person person : people) {
                if(person.getId() == id){
                    people.remove(person);
                    try {
                        data.serialize(people, FILE_PATH,data.exist(FILE_PATH));
                        System.out.println("deleted");
                        return;
                    } catch (DataAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("no matches");
    }

    /**
     * Creates a file, and warns to user after that delete file
     */
    public void initFile() {
        try {
            if (this.data.exist(FILE_PATH)){
                if(Util.warning("It will be delete the actual information, are you sure?, y = yes. :") == 'y' ){
                    this.data.delete(FILE_PATH);
                    this.data.create(FILE_PATH);
                    return;
                }
                System.out.println("No problem");
            }else{
                this.data.create(FILE_PATH);
            }
        } catch (DataAccessException e) {
            System.out.println("Error has occured creating the file");
            e.printStackTrace();
        }
    }
}
