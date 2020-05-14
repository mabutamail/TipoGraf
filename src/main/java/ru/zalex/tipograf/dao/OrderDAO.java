package ru.zalex.tipograf.dao;

import ru.zalex.tipograf.model.PrintOrder;

import java.util.List;

public interface OrderDAO {
    void add(PrintOrder zakaz);

    PrintOrder getByNumber(Long id);

    List<PrintOrder> getAll();

    void update(PrintOrder zakaz);

    void remove(PrintOrder zakaz);

}