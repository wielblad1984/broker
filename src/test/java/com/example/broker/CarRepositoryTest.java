package com.example.broker;

import com.example.broker.entities.Car;
import com.example.broker.repositories.CarRepository;
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
import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BrokerApplication.class)

public class CarRepositoryTest {
    @Autowired
    EntityManager em;

    @Autowired
    CarRepository carRepository;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void findById() {
        Car car = carRepository.findById(555L);
        Assert.assertEquals("JIHU", car.getRegistrationNumber());

    }

    @Test
    @DirtiesContext
    public void delete() {
        carRepository.deleteById(999L);
        Assert.assertNull(carRepository.findById(999L));


    }

    @Test
    @DirtiesContext
    public void save_edit() {
        Car car = carRepository.findById(555L);
        Assert.assertEquals("JIHU", car.getRegistrationNumber());

        car.setRegistrationNumber("Maria Maria");
        carRepository.save(car);

        Car car1 = carRepository.findById(555L);
        Assert.assertEquals("Maria Maria", car1.getRegistrationNumber());
    }
    @Test
    @DirtiesContext
    public void save_insert() {
        Car car=carRepository.findById(1L);
        Assert.assertNull(car);

       car=new Car("New_Car");
        carRepository.save(car);

        Car car1=carRepository.findById(1L);
        Assert.assertEquals("New_Car",car1.getRegistrationNumber());

    }
    @Test public void findByIdQuery() {
        List resultList = em.createNamedQuery("get_all_cars").getResultList();
        logger.info("Result -> {}", resultList); }


     }



