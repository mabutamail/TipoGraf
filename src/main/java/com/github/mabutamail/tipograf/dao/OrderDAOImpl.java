package com.github.mabutamail.tipograf.dao;

import com.github.mabutamail.tipograf.models.PrintOrder;

import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public void add(PrintOrder zakaz) {

    }

    @Override
    public PrintOrder getByNumber(Long id) {
        return null; //HibernateSessionFactory.getSessionFactory().openSession().get(PrintOrder.class, id);
    }

    @Override
    public List<PrintOrder> getAll() {
        return null;
    }

    @Override
    public void update(PrintOrder zakaz) {
    }

    @Override
    public void remove(PrintOrder zakaz) {
    }
}