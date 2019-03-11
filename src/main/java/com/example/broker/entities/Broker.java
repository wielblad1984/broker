package com.example.broker.entities;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

@Entity
@Table(name = "broker")
@NamedQuery(name = "get_all_brokers",
        query = "Select c from Broker c")
public class Broker {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "surname",nullable = false)
    private String surname;
    @OneToOne(fetch=FetchType.LAZY)
    private Car car;


    protected Broker(){}

    public Broker(String name, String surname) {
        this.name = name;
        this.surname = surname;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Car getCar(){
        return car;
    }
    public void setCar(Car car){
        this.car=car;

    }


    @Override
    public String toString() {
        return "Broker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }


}
