package com.github.mabutamail.tipograf;

import com.github.mabutamail.tipograf.models.Client;
import com.github.mabutamail.tipograf.models.PrintOrder;
import com.github.mabutamail.tipograf.utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProgramStartTest {
    public final static Logger logger = LoggerFactory.getLogger(com.github.mabutamail.tipograf.ProgramStart.class);
//    public EntityManager em = Persistence.createEntityManagerFactory("TIPOGRAF").createEntityManager();

    @Test
    public void main() {
        logger.info("====================       Начало программы        ====================");

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
        zakaz1.setClient(client1);
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

        logger.info("====================       Список клиентов1         ====================");
        logger.info("{}\n", session.createQuery("from Client").list());
        logger.info("====================       Список заказов         ====================");
        logger.info("{}\n", session.createQuery("from PrintOrder").list());

        session.close();
        logger.info("====================       Сессия закрыта         ====================");
        logger.info("====================       Конец программы         ====================");

//        logger.error("ERROR - информация об ошибках, возникших в работе модулей");
//        logger.warn("WARNING - информация о событиях, которые могут привести к ошибкам в работе модулей");
//        logger.info("INFO - подтверждение, информация о событиях, не приводящих к ошибкам в работе модулей");
//        logger.debug("DEBUG - подробное и детальное логирование всей системной информации");
//        logger.trace("TRACE: менее приоритетные логи для отладки, с наименьшим уровнем логирования");

    }
}