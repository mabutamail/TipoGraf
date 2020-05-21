package com.github.mabutamail.tipograf;


import com.github.mabutamail.tipograf.models.Client;
import com.github.mabutamail.tipograf.models.PrintOrder;
import com.github.mabutamail.tipograf.utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ProgramStart {
    public final static Logger logger = LoggerFactory.getLogger(ProgramStart.class);

    public static void main(String[] args) {
        logger.info("====================       Начало программы        ====================");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        Client client1 = new Client();
        client1.setClientName("Рога и Копыта");
        client1.setClientComment("тел (495) 123-45-67");
        session.save(client1);
        logger.info("====================       Клиент создан         ====================");
        PrintOrder zakaz1 = new PrintOrder();
        zakaz1.setClient(client1);
        zakaz1.setPrice(123_456L);
        zakaz1.setComment("оплата наличными, готовность - к 31.05.20 17:00");
        zakaz1.setClient(client1);
        client1.getPrintOrders().add(zakaz1);
        session.save(zakaz1);
        logger.info("====================       Заказ создан         ====================");

        session.getTransaction().commit();
        logger.info("====================       Транзакция завершена         ====================");

        session.close();
        logger.info("====================       Сессия закрыта         ====================");

        logger.info("====================       Конец программы         ====================");

    }
}