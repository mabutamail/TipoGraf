package com.github.mabutamail.tipograf.dao;

import com.github.mabutamail.tipograf.models.Client;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ClientService {

    public EntityManager em = Persistence.createEntityManagerFactory("TIPOGRAF").createEntityManager();

    public Client add(Client client) {
        em.getTransaction().begin();
        Client clientFromDB = em.merge(client);
        em.getTransaction().commit();
        return clientFromDB;
    }

//    public Client getById(long id) {
//        return em.find(Client.class, id);
//    }
//
//    public List<Client> getAll() {
//        TypedQuery<Client> namedQuery = em.createNamedQuery("Client.getAll", Client.class);
//        return namedQuery.getResultList();
//    }
//
//    public void update(Client client) {
//        em.getTransaction().begin();
//        em.merge(client);
//        em.getTransaction().commit();
//    }
//
//    public void delete(long id) {
//        em.getTransaction().begin();
//        em.remove(getById(id));
//        em.getTransaction().commit();
//    }

}