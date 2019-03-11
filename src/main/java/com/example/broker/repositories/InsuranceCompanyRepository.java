package com.example.broker.repositories;

import com.example.broker.entities.InsuranceCompany;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional

public class InsuranceCompanyRepository {
    @Autowired
    EntityManager em;
    Logger logger= LoggerFactory.getLogger(this.getClass());

    public InsuranceCompany findById(long id){
        return em.find(InsuranceCompany.class,id);

    }
    public void deleteById(long id){
        InsuranceCompany insuranceCompany=findById(id);
        em.remove(insuranceCompany);
    }
    public InsuranceCompany save(InsuranceCompany insuranceCompany){
        if(insuranceCompany.getId()==null){
            em.persist(insuranceCompany);
        }else {
            em.merge(insuranceCompany);
        }
        return insuranceCompany;
    }

}


