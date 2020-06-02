package com.github.mabutamail.tipograf;

import com.github.mabutamail.tipograf.models.Client;
import com.github.mabutamail.tipograf.models.PrintOrder;
import com.github.mabutamail.tipograf.utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProgramStartTest {
    public final static Logger logger = LoggerFactory.getLogger(com.github.mabutamail.tipograf.ProgramStart.class);

    @Test
    public void main() {
        logger.info("====================       Начало программы        ====================");
        jpaExample();
        hibernateExample();

        logger.info("====================       Конец программы         ====================");

//        logger.error("ERROR - информация об ошибках, возникших в работе модулей");
//        logger.warn("WARNING - информация о событиях, которые могут привести к ошибкам в работе модулей");
//        logger.info("INFO - подтверждение, информация о событиях, не приводящих к ошибкам в работе модулей");
//        logger.debug("DEBUG - подробное и детальное логирование всей системной информации");
//        logger.trace("TRACE: менее приоритетные логи для отладки, с наименьшим уровнем логирования");

    }


    private void jpaExample() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TIPOGRAF");
        EntityManager em = emf.createEntityManager();
        logger.info("====================       создан Entity Manager         ====================");

        em.getTransaction().begin();
        logger.info("====================       начало транзакции Entity Manager         ====================");

        Client clientEM = new Client();
        clientEM.setClientName("Рога и Копыта _ Entity Manager");
        clientEM.setClientComment("тел (495) 123-45-67 Entity Manager");
        em.persist(clientEM);
        logger.info("====================       Клиент создан Entity Manager        ====================");

        PrintOrder zakazEM = new PrintOrder();
        zakazEM.setClient(clientEM);
        zakazEM.setPrice(222_456L);
        zakazEM.setComment("оплата наличными, готовность - к 31.05.20 17:00 Entity Manager");
        clientEM.getPrintOrders().add(zakazEM);
        em.persist(zakazEM);
        logger.info("====================       Заказ создан Entity Manager         ====================");

        em.getTransaction().commit();
        logger.info("====================       Транзакция завершена Entity Manager         ====================");


        em.getTransaction().begin();
        logger.info("====================       начало транзакции Entity Manager         ====================");

        Client clientEM2 = new Client();
        clientEM2.setClientName("Рога и Копыта _ Entity Manager2222");
        clientEM2.setClientComment("тел (495) 123-45-67 Entity Manager2222");
        em.persist(clientEM2);
        logger.info("====================       Клиент создан Entity Manager 2222        ====================");

        em.getTransaction().commit();
        logger.info("====================       Транзакция завершена Entity Manager         ====================");


        logger.info("\n\n====================       Список клиентов Entity Manager         ====================");
        logger.info("{}\n", em.createQuery("from Client").getResultList());

        logger.info("\n\n====================       Список заказов Entity Manager         ====================");
        logger.info("{}\n", em.createQuery("from PrintOrder").getResultList());

        em.close();
        logger.info("====================       Entity Manager закрыт         ====================");
    }


    private void hibernateExample() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        logger.info("====================       получили коннект к БД         ====================");

        session.beginTransaction();
        logger.info("====================       начало транзакции         ====================");

        Client client1 = new Client();
        client1.setClientName("Рога и Копыта");
        client1.setClientComment("тел (495) 123-45-67");
        session.save(client1);
        logger.info("====================       Клиент создан         ====================");

        PrintOrder zakaz1 = new PrintOrder();
        zakaz1.setClient(client1);
        zakaz1.setPrice(123_456L);
        zakaz1.setComment("оплата наличными, готовность - к 31.05.20 17:00");
        client1.getPrintOrders().add(zakaz1);
        session.save(zakaz1);
        logger.info("====================       Заказ создан         ====================");

        session.getTransaction().commit();
        logger.info("====================       Транзакция завершена         ====================");

        session.beginTransaction();
        Client client2 = new Client();
        client2.setClientName("Мордор inc");
        client2.setClientComment("тел (495) 123-45-67 платят кровью");
        session.save(client2);
        session.getTransaction().commit();

        logger.info("\n\n====================       Список клиентов         ====================");
        logger.info("{}\n", session.createQuery("from Client").list());

        logger.info("\n\n====================       Список заказов         ====================");
        logger.info("{}\n", session.createQuery("from PrintOrder").list());

        session.close();
        logger.info("====================       Сессия закрыта         ====================");
    }
}