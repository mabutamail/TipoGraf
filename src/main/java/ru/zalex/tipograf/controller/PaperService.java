//package service;
//
//import bl.UtilOLD;
//import ru.zalex.tipograf.dao.PaperDAO;
//import ru.zalex.tipograf.model.Paper;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.List;
//
//public class PaperService extends UtilOLD implements PaperDAO {
//
//    Connection connection = getConnection();
//
//    @Override
//    public void add(Paper paper) {
//        PreparedStatement preparedStatement = null;
//        String sql = "INSERT INTO PAPER (ID, NAME, WEIGHT) VALUES(?, ?, ?)";
//        try {
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setLong   (1, paper.getId());
//            preparedStatement.setString (2, paper.getName());
//            preparedStatement.setLong   (3, paper.getWeight());
//
//            preparedStatement.executeUpdate();
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public List<Paper> getAll() {
//        return null;
//    }
//
//    @Override
//    public Paper getById(Long id) {
//        return null;
//    }
//
//    @Override
//    public void update(Paper paper) {
//
//    }
//
//    @Override
//    public void remove(Paper paper) {
//
//    }
//}

package ru.zalex.tipograf.controller;

import ru.zalex.tipograf.dao.SessionUtil;
import ru.zalex.tipograf.model.Paper;
import org.hibernate.Session;

import org.hibernate.query.Query;

import java.util.List;


public class PaperService extends SessionUtil {

    public void add(Paper paper) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(paper);

        //close session with a transaction
        closeTransactionSesstion();
    }

    public List<Paper> getAll() {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM PAPER";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Paper.class);
        List<Paper> paperList = query.list();

        //close session with a transaction
        closeTransactionSesstion();

        return paperList;
    }

    public Paper getById(Long id) {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM PAPER WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Paper.class);
        query.setParameter("id", id);

        Paper paper = (Paper) query.getSingleResult();

        //close session with a transaction
        closeTransactionSesstion();

        return paper;
    }

    public void update(Paper paper) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(paper);

        //close session with a transaction
        closeTransactionSesstion();
    }

    public void remove(Paper paper) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(paper);

        //close session with a transaction
        closeTransactionSesstion();
    }

}