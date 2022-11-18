package com.dao;

import com.dto.Product;
import com.exception.DataAccessException;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Product Data Access Object: common interface between app and files
 */
public class ProductDAO extends CRUD {
    private static final DataAccess dataAccess = new DataAccess();
    public static final String FILE_PATH = "././products.json";
    public static final TypeToken TYPE_TOKEN = new TypeToken<List<Product>>() {};
    public static List<Object> products = getProducts(); //Has all file info as objects

    public ProductDAO() {
    }

    /**
     * @return file info as object
     */
    public static List<Object> getProducts(){
        try {
            List<Object> products = dataAccess.unserialize(FILE_PATH,TYPE_TOKEN);
            if(products != null){ //If in the file are already valid objects
                return products; //File info will be part as objects
            }else{ //If the file doesn't have info / No objects
                return new ArrayList<>(); //Makes a empty list object
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    /**
     * Finds object on the actual all object info
     * @param idProduct
     * @return object found it
     */
    public static Product find(int idProduct) {
        Product product;
        for (Object object : products) {
            product = (Product) object;
            if(product.getId() == idProduct){
                return product;
            }
        }
        return null;
    }

}
