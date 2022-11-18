package com.dao;

import com.dto.Person;
import com.exception.DataAccessException;
import com.google.gson.reflect.TypeToken;
import com.util.Util;

/**
 * Common methods to manipulate info between language and files
 */
public abstract class CRUD {

    private static final DataAccess data = new DataAccess();

    /**
     * Add new Object into a file
     * @param object
     * @param filePath
     * @param typeToken Kind of Object
     */
    public static void create(Object object, String filePath, TypeToken typeToken) {
        try {
            data.serialize(object, typeToken, filePath);
            System.out.println("added");
        }catch (DataAccessException e){
            System.out.println("data access error");
            e.printStackTrace(System.out);
        }
    }

}
