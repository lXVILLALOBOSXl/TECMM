package com.dao;

public interface ICRUD {
    void create(String name, String lastName, String cellphone, String address);
    void find(int id);
    void update(int id);
    void delete(int id);
}
