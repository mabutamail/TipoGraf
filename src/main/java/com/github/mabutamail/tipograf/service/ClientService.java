package com.github.mabutamail.tipograf.service;

import com.github.mabutamail.tipograf.model.Client;

import javax.persistence.EntityManager;

import static com.github.mabutamail.tipograf.ProgramStart.EMF;

public class ClientService {

    public EntityManager em = EMF.createEntityManager();

    public Client add(Client client) {
        em.getTransaction().begin();
        Client clientFromDB = em.merge(client);
        em.getTransaction().commit();
        return clientFromDB;
    }

    public Client getById(long id) {
        return em.find(Client.class, id);
    }

//    public List<Client> getAll() {
//        TypedQuery<Client> namedQuery = em.createNamedQuery("Client.getAll", Client.class);
//        return namedQuery.getResultList();
//    }

    public void update(Client client) {
        em.getTransaction().begin();
        em.merge(client);
        em.getTransaction().commit();
    }

    public void delete(long id) {
        em.getTransaction().begin();
        em.remove(getById(id));
        em.getTransaction().commit();
    }

//    @Override
//    public Serializable create(Object newInstance) {
//        return null;
//    }
//
//    @Override
//    public Object read(Serializable id) {
//        return null;
//    }
//
//    @Override
//    public void update(Object transientObject) {
//
//    }
//
//    @Override
//    public void delete(Object persistentObject) {

//    }
}