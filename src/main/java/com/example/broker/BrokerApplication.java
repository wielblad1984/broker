package com.example.broker;

import com.example.broker.entities.Broker;
import com.example.broker.entities.Car;
import com.example.broker.entities.Policy;
import com.example.broker.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.management.Query;
import javax.persistence.EntityManager;
import java.util.List;

@SpringBootApplication
public class BrokerApplication implements CommandLineRunner {

    private Logger logger= LoggerFactory.getLogger(this.getClass());


	@Autowired
	private BrokerRepository brokerRepository;
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private InsuranceCompanyRepository insuranceCompanyRepository;
	@Autowired
	private PolicyRepository policyRepository;

	public static void main(String[] args) {
		SpringApplication.run(BrokerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		








    }
}
