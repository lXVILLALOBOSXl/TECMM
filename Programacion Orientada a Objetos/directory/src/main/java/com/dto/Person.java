package com.dto;

import com.dao.DataAccess;
import com.exception.DataAccessException;
import com.exception.DataReadException;

import java.util.List;

public class Person {
    private static final DataAccess dataAccess = new DataAccess();
    private static int personNumber = getPersonNumber();
    private static final String FILE_PATH = "././directory.json";


    private int id;
    private String name;
    private String lastName;
    private String cellphone;
    private String address;

    public Person(String name, String lastName, String cellphone, String address) {
        this.id = ++Person.personNumber;
        this.name = name;
        this.lastName = lastName;
        this.cellphone = cellphone;
        this.address = address;
    }

    public Person(int id, String name, String lastName, String cellphone, String address) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.cellphone = cellphone;
        this.address = address;
    }

    private static int getPersonNumber(){
        try {
            List<Person> people = dataAccess.unserialize(FILE_PATH);
            if(people != null){
                return dataAccess.unserialize(FILE_PATH).size();
            }else{
                return 0;
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
