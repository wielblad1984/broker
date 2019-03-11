package com.example.broker.repositories;

import com.example.broker.entities.Broker;
import com.example.broker.entities.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BrokerRepository {

    @Autowired
    EntityManager em;
    Logger logger = LoggerFactory.getLogger(this.getClass());


    public Broker findById(long id) {

        return em.find(Broker.class, id);
    }

    public void deleteById(long id) {
        Broker brokerToDelete = findById(id);
        em.remove(brokerToDelete);
    }

    public Broker save(Broker broker) {
        if (broker.getId() == null) {
            em.persist(broker);
        } else {
            em.merge(broker);
        }
        return broker;
    }
    public void saveBrokerWithCar(){
        Car car=new Car("DW5984");
        em.persist(car);
        Broker broker=new Broker("Kazimierz","Pokora");
        broker.setCar(car);
        em.persist(broker);
    }


}
