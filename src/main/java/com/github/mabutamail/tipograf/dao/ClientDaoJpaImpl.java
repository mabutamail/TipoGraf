package com.github.mabutamail.tipograf.dao;

import com.github.mabutamail.tipograf.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import static com.github.mabutamail.tipograf.ProgramStart.EMF;

public class ClientDaoJpaImpl implements Dao {
    public EntityManager em = EMF.createEntityManager();

    @Override
    public void create(Client client) {
        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();
    }

    @Override
    public Client read(Client clientName) {
        return em.find(Client.class, clientName);
    }

    @Override
    public void update(Client client) {
        em.getTransaction().begin();
        em.merge(client);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Client clientName) {
        em.getTransaction().begin();
        em.persist(clientName);
        em.getTransaction().commit();
    }

    @Override
    public List<Client> getAll(){
        TypedQuery<Client> namedQuery = em.createNamedQuery("Client.getAll", Client.class);
        return namedQuery.getResultList();
    }

}
