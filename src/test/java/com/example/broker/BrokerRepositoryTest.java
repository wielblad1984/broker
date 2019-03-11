package com.example.broker;

import com.example.broker.entities.Broker;
import com.example.broker.entities.Car;
import com.example.broker.repositories.BrokerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BrokerApplication.class)

public class BrokerRepositoryTest {

    @Autowired
    EntityManager em;
    @Autowired
    BrokerRepository brokerRepository;

   Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void findById() {
        Broker broker = brokerRepository.findById(101L);
        Assert.assertEquals("Anna", broker.getName());
        Assert.assertEquals("Nowak", broker.getSurname());

    }

    @Test
    @DirtiesContext
    public void deleteById() {
        brokerRepository.deleteById(102L);
        Assert.assertNull(brokerRepository.findById(102L));
    }

    @Test
    @DirtiesContext
    public void save_edit() {
        Broker broker = brokerRepository.findById(103L);
        Assert.assertEquals("Maria", broker.getName());

        broker.setName("Maria Maria");
        brokerRepository.save(broker);

        Broker broker1 = brokerRepository.findById(103L);
        Assert.assertEquals("Maria Maria", broker1.getName());
    }

    @Test
    @DirtiesContext
    public void save_insert() {
        Broker broker=brokerRepository.findById(1L);
        Assert.assertNull(broker);

        broker=new Broker("Halina","Kalina");
        brokerRepository.save(broker);

        Broker broker2=brokerRepository.findById(1L);
        Assert.assertEquals("Halina",broker2.getName());

    }

    @Test
    public void findByIdQuery() {
        List resultList = em.createNamedQuery("get_all_brokers").getResultList();
        logger.info("Result -> {}", resultList); }

     @Test
    public void getBrokerWithCarTest(){
        Broker broker=brokerRepository.findById(101L);
        logger.info("BROKER->{}",broker);
        logger.info("CAR->{}",broker.getCar());
     }
     @Test
    public void getBrokerByCarTest(){
        Car car=em.find(Car.class,999L);
        logger.info("CAR->{}",car);
        logger.info("BROKER->{}",car.getBroker());
     }



}
