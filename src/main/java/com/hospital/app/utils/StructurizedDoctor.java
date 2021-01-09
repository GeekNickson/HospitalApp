package com.hospital.app.utils;

import java.io.Serializable;

public class StructurizedDoctor {
    private Integer id;

    private String name;

    private String specialty;

    private String category;

    public StructurizedDoctor(Integer id, String name, String specialty, String category) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
