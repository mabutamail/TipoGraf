package com.github.mabutamail.tipograf.dao;

import com.github.mabutamail.tipograf.utils.HibernateSessionFactory;
import org.hibernate.Session;

import java.io.Serializable;

public class ClientDaoHibernateImpl <T, PK extends Serializable> implements Dao<T, PK> {
    private Class<T> type;

    Session session = HibernateSessionFactory.getSessionFactory().openSession();

    public ClientDaoHibernateImpl(Class<T> type) {
        this.type = type;
    }

    public PK create(T o) {
        return (PK) session.getSession().save(o);
    }

    public T read(PK id) {
        return (T) session.getSession().get(type, id);
    }

    public void update(T o) {
        session.getSession().update(o);
    }

    public void delete(T o) {
        session.getSession().delete(o);
    }
}
