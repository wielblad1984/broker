package com.example.broker.repositories;

import com.example.broker.entities.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ClientRepository {

    @Autowired
    EntityManager em;
    Logger logger= LoggerFactory.getLogger(this.getClass());

    public Client findById(long id){
        return em.find(Client.class,id);

    }
    public void deleteById(long id){
        Client client=findById(id);
        em.remove(client);
    }
    public Client save(Client client){
        if(client.getId()==null){
            em.persist(client);
        }else {
            em.merge(client);
        }
        return client;
    }

}
