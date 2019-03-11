package com.example.broker;

import com.example.broker.entities.Client;
import com.example.broker.repositories.ClientRepository;
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
public class ClientRepositoryTest {

    @Autowired
    EntityManager em;
    @Autowired
    ClientRepository clientRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void findById() {
        Client client = clientRepository.findById(20L);
        Assert.assertEquals("Murex", client.getName());


    }

    @Test
    @DirtiesContext
    public void deleteById() {
        clientRepository.deleteById(20L);
        Assert.assertNull(clientRepository.findById(20L));
    }

    @Test
    @DirtiesContext
    public void save_edit() {
        Client client = clientRepository.findById(30L);
        Assert.assertEquals("Credo", client.getName());

        client.setName("Credowo");
        clientRepository.save(client);

        Client client1= clientRepository.findById(30L);
        Assert.assertEquals("Credowo", client1.getName());
    }

    @Test
    @DirtiesContext
    public void save_insert() {
        Client client=clientRepository.findById(9999L);
        Assert.assertNull(client);

        client=new Client("JOK");
        clientRepository.save(client);

        Client client2=clientRepository.findById(1L);
        Assert.assertEquals("JOK",client2.getName());

    }
    @Test public void findByIdQuery() {
        List resultList = em.createNamedQuery("get_all_clients").getResultList();
        logger.info("Result -> {}", resultList); }

}
