package com.example.broker;

import com.example.broker.entities.Policy;
import com.example.broker.repositories.PolicyRepository;
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
public class PolicyRepoTest {
    @Autowired
    EntityManager em;
    @Autowired
    PolicyRepository policyRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void findById() {
        Policy policy = policyRepository.findById(1001L);
        Assert.assertEquals(5689, policy.getNumber());


    }

    @Test
    @DirtiesContext
    public void deleteById() {
        policyRepository.deleteById(1004L);
        Assert.assertNull(policyRepository.findById(1004L));
    }

    @Test
    @DirtiesContext
    public void save_edit() {
        Policy policy = policyRepository.findById(1005L);
        Assert.assertEquals(5478, policy.getNumber());

        policy.setNumber(5111);
        policyRepository.save(policy);

        Policy policy1 = policyRepository.findById(1005L);
        Assert.assertEquals(5111, policy1.getNumber());
    }

    @Test
    @DirtiesContext
    public void save_insert() {
        Policy policy=policyRepository.findById(654321L);
        Assert.assertNull(policy);

        Policy policy1=new Policy(1551,"life");
        policyRepository.save(policy1);

        Policy policy2=policyRepository.findById(1L);
        Assert.assertEquals(1551,policy2.getNumber());
        Assert.assertEquals("life",policy2.getInsuranceType());

    }


    @Test public void findByIdQuery() {
        List resultList = em.createNamedQuery("get_all_policies").getResultList();
        logger.info("Result -> {}", resultList); }

}
