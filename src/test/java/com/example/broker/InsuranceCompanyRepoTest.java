package com.example.broker;

import com.example.broker.entities.InsuranceCompany;
import com.example.broker.repositories.InsuranceCompanyRepository;
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

public class InsuranceCompanyRepoTest {

    @Autowired
    EntityManager em;
    @Autowired
    InsuranceCompanyRepository insuranceCompanyRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void findById() {
        InsuranceCompany insuranceCompany = insuranceCompanyRepository.findById(1L);
        Assert.assertEquals("PZA", insuranceCompany.getName());


    }

    @Test
    @DirtiesContext
    public void deleteById() {
        insuranceCompanyRepository.deleteById(2L);
        Assert.assertNull(insuranceCompanyRepository.findById(2L));
    }

    @Test
    @DirtiesContext
    public void save_edit() {
        InsuranceCompany insuranceCompany = insuranceCompanyRepository.findById(3L);
        Assert.assertEquals("Heneral", insuranceCompany.getName());

        insuranceCompany.setName("Heneral_New");
        insuranceCompanyRepository.save(insuranceCompany);

        InsuranceCompany insuranceCompany1 = insuranceCompanyRepository.findById(3L);
        Assert.assertEquals("Heneral_New", insuranceCompany.getName());
    }

    @Test
    @DirtiesContext
    public void save_insert() {
        InsuranceCompany insuranceCompany=insuranceCompanyRepository.findById(100L);
        Assert.assertNull(insuranceCompany);

        InsuranceCompany insuranceCompany1=new InsuranceCompany("DAD");
        insuranceCompanyRepository.save(insuranceCompany1);

        InsuranceCompany insuranceCompany2=insuranceCompanyRepository.findById(11111L);
        Assert.assertEquals("DAD",insuranceCompany2.getName());

    }


    @Test public void findByIdQuery() {
        List resultList = em.createNamedQuery("get_all_companies").getResultList();
        logger.info("Result -> {}", resultList); }

}
