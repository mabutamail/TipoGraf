package com.github.mabutamail.tipograf.dao;

import com.github.mabutamail.tipograf.models.PrintOrder;

import java.util.List;

public interface OrderDAO {
    void add(PrintOrder zakaz);

    PrintOrder getByNumber(Long id);

    List<PrintOrder> getAll();

    void update(PrintOrder zakaz);

    void remove(PrintOrder zakaz);

}