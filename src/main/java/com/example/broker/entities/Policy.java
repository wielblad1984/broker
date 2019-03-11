package com.example.broker.entities;

import javax.persistence.*;

@Entity
@Table(name = "policy")
@NamedQuery(name = "get_all_policies",
        query = "Select c from Policy c")
public class Policy {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private int number;

    private String insuranceType;

    protected Policy(){}

    public Policy(int number, String insuranceType) {
        this.number = number;
        this.insuranceType = insuranceType;
    }
    public Long getId() {
        return id;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getInsuranceType() {
        return insuranceType;
    }
    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "id=" + id +
                ", number=" + number +
                ", insuranceType='" + insuranceType + '\'' +
                '}';
    }
}
