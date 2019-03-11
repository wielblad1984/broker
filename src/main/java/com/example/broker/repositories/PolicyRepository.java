package com.example.broker.repositories;

import com.example.broker.entities.Policy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional

public class PolicyRepository {
    @Autowired
    EntityManager em;
    Logger logger= LoggerFactory.getLogger(this.getClass());

    public Policy findById(long id){
        return em.find(Policy.class,id);

    }
    public void deleteById(long id){
        Policy policy=findById(id);
        em.remove(policy);
    }
    public Policy save(Policy policy){
        if(policy.getId()==null){
            em.persist(policy);
        }else {
            em.merge(policy);
        }
        return policy;
    }

}


