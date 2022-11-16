package com.dao;

import com.dto.Person;
import com.exception.DataAccessException;
import com.exception.DataReadException;
import com.exception.DataWriteException;

import java.util.List;

public interface IDataAccess{
    boolean exist(String nombreArchivo) throws DataAccessException;
    List<Person> unserialize(String nombreArchivo) throws DataAccessException;
    void serialize(Person person, String filePath, boolean append) throws DataAccessException;
    void serialize(List<Person> people, String filePath, boolean append) throws DataAccessException;
    void create(String nombreArchivo) throws  DataAccessException;
    void delete(String nombreArchivo) throws DataAccessException;
}
