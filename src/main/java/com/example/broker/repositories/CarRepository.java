package com.example.broker.repositories;

import com.example.broker.entities.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;


@Repository
@Transactional
public class CarRepository {

    @Autowired
    EntityManager em;
    Logger logger= LoggerFactory.getLogger(this.getClass());

    public Car findById(long id){
        return em.find(Car.class,id);

    }
    public void deleteById(long id){
        Car car=findById(id);
        em.remove(car);
    }
    public Car save(Car car){
        if(car.getId()==null){
            em.persist(car);
        }else {
            em.merge(car);
        }
        return car;
    }




}
