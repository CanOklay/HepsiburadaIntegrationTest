package com.hepsiburada.model;

public class Category {
    private float id;
    private String name;


    // Getter Methods

    public float getId() {
        return id;
    }

    public Category(float id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
