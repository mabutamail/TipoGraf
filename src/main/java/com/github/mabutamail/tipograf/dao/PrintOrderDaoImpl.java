package com.github.mabutamail.tipograf.dao;

import com.github.mabutamail.tipograf.utils.HibernateSessionFactory;
import org.hibernate.Session;

public class PrintOrderDaoImpl {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();

//    @Override
//    public void create(Object o) {
//        session.save(o);
//    }
//
//    @Override
//    public PrintOrder readByNumber(Long id) {
//        return null;
//    }
//
//    @Override
//    public List<PrintOrder> readAll() {
//        return null;//session.createQuery("from Client" ).list();
//    }
//
//    @Override
//    public void update(Object o) {
//        session.save(o);
//    }
//
//    @Override
//    public void delete(Object o) {
//        //(PrintOrder)o.;
//    }
}