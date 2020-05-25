package com.github.mabutamail.tipograf.dao;

import com.github.mabutamail.tipograf.models.PrintOrder;

public interface Dao {
//    CRUD Create Read Update Delete
    void create(Object o);

    PrintOrder readById(Long id);

//    List<PrintOrder> getAll();

    void update(Object o);

    void delete(Object o);

}