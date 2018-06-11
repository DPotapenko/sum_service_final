package com.example.sum_service;


import javax.persistence.*;

@Entity
@Table (name = "test_table")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String  name;
    @Column(name = "value")
    private int value;

    public Model() { }

    public Model(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

}
