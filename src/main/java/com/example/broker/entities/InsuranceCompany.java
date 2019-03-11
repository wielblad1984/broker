package com.example.broker.entities;


import javax.persistence.*;

@Entity
@Table(name = "insurance_company")
@NamedQuery(name = "get_all_companies",
        query = "Select c from InsuranceCompany c")
public class InsuranceCompany {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    protected InsuranceCompany(){}

    public InsuranceCompany(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "InsuranceCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
