package com.github.mabutamail.tipograf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProgramStart {
    public final static Logger LOGGER = LoggerFactory.getLogger(ProgramStart.class);
    public final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("TIPOGRAF");

    public static void main(String[] args) {
        LOGGER.info("====================       Начало программы        ====================");
//        ClientDaoJpaImpl client = new ClientDaoJpaImpl();
//        client.create();
//        client.read();
//        client.update();
//        client.delete();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TIPOGRAF");
        LOGGER.info("====================       создана Entity Manager Factory        ====================");



        emf.close();
        LOGGER.info("====================       Entity Manager Factory закрыта         ====================");
        LOGGER.info("====================       Конец программы         ====================");

    }
}