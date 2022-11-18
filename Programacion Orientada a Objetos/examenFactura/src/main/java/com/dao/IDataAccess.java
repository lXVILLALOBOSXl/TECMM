package com.dao;

import com.exception.DataAccessException;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public interface IDataAccess {
    boolean exist(String filePath) throws DataAccessException;
    List<Object> unserialize(String filePath, TypeToken typeToken) throws DataAccessException;
    void serialize(Object object, TypeToken typeToken, String filePath) throws DataAccessException;
    void serialize(List<Object> objects, TypeToken typeToken, String filePath) throws DataAccessException;
    void create(String filePath) throws  DataAccessException;
    void delete(String filePath) throws DataAccessException;
}
