package com.example.broker.entities;

import javax.persistence.*;

@Entity
@Table(name = "client")
@NamedQuery(name = "get_all_clients",
        query = "Select c from Client c")

public class Client {
    @Id
    @GeneratedValue
    private Long id;

    private String name;



    protected Client(){}

    public Client(String name) {
        this.name = name;
    }

    public Long getId()
    {
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
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
