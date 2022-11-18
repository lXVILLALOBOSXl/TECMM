package com.dao;

import com.dto.Saleman;
import com.exception.DataAccessException;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
/**
 * Salesman Data Access Object: common interface between app and files
 */
public class SalesmanDAO extends CRUD{

    private static final DataAccess dataAccess = new DataAccess();
    public static final String FILE_PATH = "././salesmen.json";
    public static final TypeToken TYPE_TOKEN = new TypeToken<List<Saleman>>() {};
    public static List<Object> salesMen = getSalesMen(); //Has all file info as objects

    public SalesmanDAO() {
    }

    /**
     * @return file info as object
     */
    public static List<Object> getSalesMen(){
        try {
            List<Object> salesmen = dataAccess.unserialize(FILE_PATH,TYPE_TOKEN);
            if(salesmen != null){ //If in the file are already valid objects
                return salesmen; //File info will be part as objects
            }else{ //File info will be part as objects
                return new ArrayList<>(); //Makes a empty list object
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    /**
     * Finds object on the actual all object info
     * @param idSaleman
     * @return object found it
     */
    public static Saleman find(int idSaleman) {
        Saleman saleman;
        for (Object object : salesMen) {
            saleman = (Saleman) object;
            if(saleman.getId() == idSaleman){
                return saleman;
            }
        }
        return null;
    }

    /**
     * Update the seller's information every time a sale is made, the information will change
     * @param saleman
     */
    public static void update(Saleman saleman) {
        //In the actual info as objects, delete old version and add new version
        salesMen.add(saleman);
        salesMen.remove(saleman);

        //Serializes again to save new changes
        try {
            dataAccess.serialize(salesMen,TYPE_TOKEN,FILE_PATH);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        //Bring the new changes from the file
        salesMen = getSalesMen();

    }
}
