package com.github.mabutamail.tipograf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProgramStart {
    public final static Logger logger = LoggerFactory.getLogger(ProgramStart.class);
    public final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("TIPOGRAF");

    public static void main(String[] args) {
        logger.info("====================       Начало программы        ====================");
//        ClientDaoJpaImpl client = new ClientDaoJpaImpl();
//        client.create();
//        client.read();
//        client.update();
//        client.delete();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TIPOGRAF");
        logger.info("====================       создана Entity Manager Factory        ====================");



        emf.close();
        logger.info("====================       Entity Manager Factory закрыта         ====================");
        logger.info("====================       Конец программы         ====================");

    }
}