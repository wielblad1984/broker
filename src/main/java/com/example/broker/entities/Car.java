package com.example.broker.entities;

import javax.persistence.*;

@Entity
@Table(name = "car")
@NamedQuery(name = "get_all_cars",
        query = "Select c from Car c")
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    private String registrationNumber;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "car")
    private Broker broker;

    protected Car(){}

    public Car( String registrationNumber) {

        this.registrationNumber = registrationNumber;
    }

    public Long getId() {
        return id;
    }



    public String getRegistrationNumber()
    {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString() {
        return String.format("Car[%s]",registrationNumber);
    }
    public Broker getBroker(){
        return broker;
    }
    public void setBroker(Broker broker){
        this.broker=broker;
    }
}
