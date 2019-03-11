package com.example.broker;

import com.example.broker.entities.Broker;
import com.example.broker.repositories.BrokerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BrokerApplication.class)
public class BrokerApplicationTests {


	@Test
	public void contextLoads() {
	}

}
